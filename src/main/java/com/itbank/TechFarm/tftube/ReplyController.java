package com.itbank.TechFarm.tftube;



import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.login.member.MemberDTO;
import com.itbank.TechFarm.tftube.dao.ReplyDAO;
import com.itbank.TechFarm.tftube.dto.ReplyDTO;




@Controller
public class ReplyController {
	
	@Autowired
	private ReplyDAO replyDAO;	

	private HttpSession session=null;
	private String msg=null, url=null;	
	private static HashMap<String, HashMap<String, Date>> map=new HashMap<String,HashMap<String,Date>>();
	@RequestMapping(value="/tftube_reply_insert")
	public ModelAndView tftube_reply_insert(HttpServletRequest arg0, 
								HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();	
		
		session=arg0.getSession();
		Object member_raw=session.getAttribute("memberDTO");
		if(member_raw==null){
				msg="로그인이 필요한 서비스 입니다. 로그인을 해주세요.";
				url="login";
				mv.addObject("msg",msg);
				mv.addObject("url",url);
				mv.setViewName("tftube/message");					
		}
		MemberDTO member=(MemberDTO)member_raw;
		ReplyDTO dto=new ReplyDTO();//space to save reply information.	
		
		String re_step_raw=arg0.getParameter("re_step");//not exist reply
		String re_level_raw=arg0.getParameter("re_level");
		
		int re_step=0;
		int re_level=0;
		if(re_step_raw!=null){
		re_step=Integer.parseInt(re_step_raw);}
		if(re_level_raw!=null){
			re_level=Integer.parseInt(re_level_raw);
		}
		
		String mode=arg0.getParameter("mode");		
		String content=null;
		int res=0;	
		
		dto.setMember_no(member.getNo());		
		dto.setVideo_name(arg0.getParameter("video_name"));
		
		if(mode.equals("general")){			
			content=arg0.getParameter("content");			 
			dto.setRe_level(0);
			dto.setRe_step(0);
			dto.setContent(content);
			
			res=replyDAO.insertReply(dto);
			replyDAO.update_re_step();
		}else{
			 content=arg0.getParameter("content_reply");
		
			 dto.setRe_level(1);//distinction reply and re_reply
			 dto.setRe_step(re_step);			
			 dto.setContent(content);			 
			 res=replyDAO.insertReply(dto);
			 replyDAO.update_re_step_reply(re_step);
		}
		
		
		
		int no=(Integer)session.getAttribute("video_no");
		if(res>0){
			mv.setViewName("redirect:tftube_videoView?no="+no);			
		}
		else{
			msg="fail to reply";
			url="tftube_main";
			mv.setViewName("tftube/message");
			mv.addObject("msg",msg);
			mv.addObject("url",url);				
		}			
		return mv;		
	}
	
	@RequestMapping(value="/tftube_reply_delete")
	public ModelAndView tftube_reply_delete(HttpServletRequest arg0, 
								HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();
		
		int no=0;
		/*ReplyDTO rdto=(ReplyDTO)arg0.getParameter("rdto");
		String rdto_raw=arg0.getParameter("rdto");
		if(rdto_raw!=null){
			rdto=(ReplyDTO)rdto_raw;
		}*/
		int r_no=0;
		ReplyDTO rdto=(ReplyDTO)arg0.getAttribute("rdto");
		
		//re_step, re_level
		String no_raw=arg0.getParameter("no");//video number
		if(no_raw!=null){
		no=Integer.parseInt(no_raw);}
		
		String r_no_raw=arg0.getParameter("r_no");//reply number
		if(r_no_raw!=null){
		r_no=Integer.parseInt(r_no_raw);}
		
		int res=replyDAO.delete_reply(r_no);
		if(res>0){
			mv.setViewName("redirect:tftube_videoView?no="+no);			
		}
		else{
			msg="fail to delete";
			url="tftube_main";
			mv.setViewName("tftube/message");
			mv.addObject("msg",msg);
			mv.addObject("url",url);				
		}		
		return mv;		
	}
	
	/*@RequestMapping(value="/videoView_reply")
	public ModelAndView tftube_videoView_reply(HttpServletRequest arg0, 
								HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();	
		HttpSession session=arg0.getSession();
		
		String no_raw=arg0.getParameter("no");//no of video
		//videoView or main
		int no=0;		
		if(no_raw!=null){
		no=Integer.parseInt(no_raw);}//tftube_video

		VideoDTO vdto=videoDAO.getVideo(no);//a video's total information	
		String video_name=vdto.getVideo_name();//video_name at present
		
		//?
		session.setAttribute("video_no",no);//error and time lag
		
		Date today=new Date();//today				
		Long today_day=today.getTime()/1000/3600/24;
		
		Date date=map.get(vdto.getVideo_hash());//video's date clicked information		

		String ip=arg0.getRemoteAddr();	
		
		//?
		MemberDTO member=new MemberDTO();
		
		//start of hits' validity
		
		Date date=null;
		HashMap<String,Date> log=map.get(vdto.getVideo_hash());//object null		
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
		map.put(vdto.getVideo_hash(),log_space);						
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
		//RecentVideo insert 		
		RecentVideoDTO recent_dto=new RecentVideoDTO();
		
		if(member_object!=null){
		recent_dto.setMember_no(member.getNo());
		recent_dto.setVideo_name(video_name);		
		recentvideoDAO.insertRecent(recent_dto);
		}
		//end of RecentVideo insert 		
		
		
		//ReplyList where=video		
		List<ReplyDTO> r_list=replyDAO.replyList_by_video(video_name);
		List<ReplyFormat> r_list=replyDAO.getName_by_video(video_name);
		String r_size=df.format(replyDAO.reply_number(video_name));
		
		//member_no
		
		//Reply writer
		String r_name=replyDAO.getName_by_video(vdto.getVideo_name());		

		
		//information of recent video
				
		//hits of reply
		mv.addObject("readcount",readcount);		
		//list of reply where video
		mv.addObject("r_list",r_list);
		//writer of reply

		mv.addObject("r_name",r_name);
		mv.addObject("vdto",vdto);
		//size of reply
		mv.addObject("r_size",r_size);
		mv.addObject("no",no);
		
			
		mv.setViewName("tftube/videoView");			
		
		int pageSize = 5;
		String pageNum = arg0.getParameter("pageNum");
		if (pageNum == null){
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = currentPage * pageSize - (pageSize - 1);
		int endRow = startRow + pageSize - 1;
		int countRow = boardDAO.getCount();  
		
		if (endRow>countRow) endRow = countRow;
		int number = countRow - (currentPage-1) * pageSize;
		
		List<ReplyDTO> list =replyDAO.listBoard(startRow, endRow);			
		
		if (countRow>0) {
			int pageCount = countRow/pageSize + (countRow%pageSize==0 ? 0 : 1);
			int pageBlock = 3;
			int startPage = (currentPage-1)/pageBlock * pageBlock + 1;
			int endPage = startPage + pageBlock - 1;
			if (endPage>pageCount) endPage = pageCount;			
			mv.addObject("startPage", startPage);
			mv.addObject("endPage", endPage);
			mv.addObject("pageBlock", pageBlock);
			mv.addObject("pageCount", pageCount);			
		}				
		mv.addObject("boardList", list);
		mv.addObject("number",number);	
		return mv;
		
		
	}*/
}
