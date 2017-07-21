package com.itbank.TechFarm.tftube;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.login.member.MemberDTO;
import com.itbank.TechFarm.tftube.dao.LikeVideoDAO;
import com.itbank.TechFarm.tftube.dao.ReplyDAO;
import com.itbank.TechFarm.tftube.dao.VideoDAO;
import com.itbank.TechFarm.tftube.dto.LikeVideoDTO;
import com.itbank.TechFarm.tftube.dto.ReplyFormat;
import com.itbank.TechFarm.tftube.dto.VideoDTO;

@Controller
public class LikeVideoController {
	@Autowired
	private VideoDAO videoDAO;
	@Autowired
	private LikeVideoDAO likevideoDAO;
	String msg=null,url=null;
	@Autowired
	private ReplyDAO replyDAO;	
	
	private static HashMap<String, HashMap<String, Date>> map=new HashMap<String,HashMap<String,Date>>();
	
	@RequestMapping(value="/likeVideo_list", method=RequestMethod.GET)
	public ModelAndView likeVideo_list(HttpServletRequest arg0, 
			HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();
		HttpSession session=arg0.getSession();		
		MemberDTO member=(MemberDTO)session.getAttribute("memberDTO");
		
		//로그인 사용자만 이용가능
		if(member==null){
			msg="로그인이 필요한 서비스 입니다. 로그인 페이지로 이동합니다.";
			url="login";
			mv.addObject("msg",msg);
			mv.addObject("url",url);
			mv.setViewName("tftube/message");
			return mv;
		}
		
		
		//request no,like_status,unlike_status
		String no_raw=arg0.getParameter("no");//no of video
		//두 값들이 혹시나 0이 들어 오진 않는가?
		String like_status_raw=arg0.getParameter("like_status");//like unlike 둘중 하나만 들어온다.
		String unlike_status_raw=arg0.getParameter("unlike_status");
		//새로 고침 했을때, 주소직접접근, main에서 넘어올때(except like button)
		int like_status=0,unlike_status=0;
		if(like_status_raw!=null){
		like_status=Integer.parseInt(like_status_raw);}
		if(unlike_status_raw!=null){
		unlike_status=Integer.parseInt(unlike_status_raw);}
		
		//tftube_video
		
		System.out.println("like_status:"+like_status);
		System.out.println("unlike_status:"+unlike_status);
		
		//videoView or main
		int no=0;		//direct approach
		if(no_raw!=null){no=Integer.parseInt(no_raw);}
		else{return new ModelAndView("redirect:tftube_main");}
		
		System.out.println("no:"+no);
		
		VideoDTO vdto=videoDAO.getVideo(no);//a video's total information
		
		System.out.println("vdto:"+vdto);
		mv.addObject("vdto",vdto);
		String video_name=vdto.getVideo_name();//video_name at present
		
		//지금 이 비디오에 이 아이디에 좋아요
		
		//like 2차원 코딩이 필요할듯.       
		//no member_no video_name like status unlike
		int member_no=member.getNo();
		//클릭할때마다 다른 값이들어오긴함.		
		
		//현재 회원이 좋아요 누른 동영상 조회 
		LikeVideoDTO lvdto_list=likevideoDAO.likevideo_list(member_no,no);
		//단, lvdto가 null인 경우도 있다.생각해보면 좋아요를 누르지 않으면 데이터가 없다.
		if(lvdto_list==null){//이게 싫으면 모든 사용자들에게 자동으로 0-개 비효율			
			mv.addObject("like_status",0);
			//mv.addObject("unlike_status",0);
		}else{
			mv.addObject("like_status",1);
			//mv.addObject("unlike_status",1);	
			}		
		
		//insert준비

		LikeVideoDTO lvdto_insert=new LikeVideoDTO();
		System.out.println("like컨트롤러 member_no:"+member_no);
		System.out.println("like컨트롤러 no:"+no);
		lvdto_insert.setMember_no(member_no);
		lvdto_insert.setVideo_no(no); 
		int res=0;		
		//when like_disabled
		if(like_status==1){
		res=likevideoDAO.like_insert(lvdto_insert);}
		else if(like_status==0){
		//when like
		res=likevideoDAO.like_delete(member_no,no);}		
		
		//좋아요 갯수 세기
		int count=likevideoDAO.likecount_member(member_no);	
		
		//좋아요 갯수 업데이트 dto.get
		VideoDTO vdto_like=new VideoDTO();
		vdto_like.setLikep(count);
		vdto_like.setNo(no);
		int res_update_like=videoDAO.updateLike(vdto_like);
		
		if(res_update_like>0){
		mv.addObject("likep",count);
		mv.setViewName("tftube/videoView");
		}
		
		else{
			msg="좋아요 갱신에 실패하였습니다.";
			url="videoView";
			mv.addObject("msg",msg);
			mv.addObject("url",url);
			mv.setViewName("tftube/message");			
		}
		//?
				session.setAttribute("video_no",no);//error and time lag
				
				Date today=new Date();//today				
				Long today_day=today.getTime()/1000/3600/24;
				
				/*Date date=map.get(vdto.getVideo_hash());//video's date clicked information*/		

				String ip=arg0.getRemoteAddr();	
				
				//?
				//MemberDTO member=new MemberDTO();
				
				//start of hits' validity
				
				Date date=null;
				HashMap<String,Date> log=map.get(vdto.getVideo_name());//object null		
				//map.values()->array []
				System.out.println("log:"+log);//not [](empty space)
				if(log!=null){
				date=log.get(ip);}
				
				if(log==null){
					videoDAO.hitUp(no);
				}else{
					if(today_day-date.getTime()>1){
					videoDAO.hitUp(no);					
					}				
				}	
				
				HashMap<String,Date> log_space=new HashMap<String,Date>();
				log_space.put(ip, today);
				map.put(vdto.getVideo_name(),log_space);						
				// end of hits' validity
						
				//start of hits' format 
				
				DecimalFormat df=new DecimalFormat("#,##0");
				vdto=videoDAO.getVideo(no);//pull update information
				String readcount=df.format(vdto.getReadcount());
				mv.addObject("readcount",readcount);	
				//end of hits' format 
				
				// logged in member information at present
				Object member_object=session.getAttribute("memberDTO");
				if(member_object!=null){
				member=(MemberDTO)member_object;
				}
				
			/*	//RecentVideo insert 		
				RecentVideoDTO recent_dto=new RecentVideoDTO();
				
				if(member_object!=null){
				recent_dto.setMember_no(member.getNo());
				recent_dto.setVideo_name(video_name);		
				recentvideoDAO.insertRecent(recent_dto);
				}
				//end of RecentVideo insert 		
		*/		
				
				//ReplyList where=video		
				/*List<ReplyDTO> r_list=replyDAO.replyList_by_video(video_name);*/
				List<ReplyFormat> r_list=replyDAO.getName_by_video(video_name);
				String r_size=df.format(replyDAO.reply_number(video_name));
				
				//member_no
				
				//Reply writer
				/*String r_name=replyDAO.getName_by_video(vdto.getVideo_name());*/		

				
				//information of recent video
						
				//hits of reply
				mv.addObject("readcount",readcount);		
				//list of reply where video
				mv.addObject("r_list",r_list);
				//writer of reply

				/*mv.addObject("r_name",r_name);*/
				
				//size of reply
				mv.addObject("r_size",r_size);
				mv.addObject("no",no);
				
					
				mv.setViewName("tftube/videoView");		
		return mv;
	}
	
}
