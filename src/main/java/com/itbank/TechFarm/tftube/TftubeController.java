package com.itbank.TechFarm.tftube;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bouncycastle.jcajce.provider.digest.Keccak.DigestKeccak;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.jcajce.provider.digest.SHA3.DigestSHA3;
import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.login.member.MemberDAO;
import com.itbank.TechFarm.login.member.MemberDTO;
import com.itbank.TechFarm.tftube.dao.MyChannelDAO;
import com.itbank.TechFarm.tftube.dao.RecentVideoDAO;
import com.itbank.TechFarm.tftube.dao.ReplyDAO;
import com.itbank.TechFarm.tftube.dao.SubedDAO;
import com.itbank.TechFarm.tftube.dao.SubingDAO;
import com.itbank.TechFarm.tftube.dao.VideoDAO;
import com.itbank.TechFarm.tftube.dto.RecentVideoDTO;
import com.itbank.TechFarm.tftube.dto.ReplyDTO;
import com.itbank.TechFarm.tftube.dto.ReplyFormat;
import com.itbank.TechFarm.tftube.dto.SubedDTO;
import com.itbank.TechFarm.tftube.dto.SubingDTO;
import com.itbank.TechFarm.tftube.dto.VideoDTO;
import com.itbank.TechFarm.tftube.java.Sha3;
import com.mysql.jdbc.log.Log;


 
@Controller
public class TftubeController {
	
	@Autowired
	private VideoDAO videoDAO;
	@Autowired
	private ReplyDAO replyDAO;	
	@Autowired
	private RecentVideoDAO recentvideoDAO;
	@Autowired
	private MyChannelDAO mychannelDAO;
	@Autowired
	private SubingDAO subingDAO;
	@Autowired
	private SubedDAO subedDAO;
	
	
	private String upPath_video=null;
	private String upPath_image=null;
	/*private HttpSession session=null;*///re_check Is it necessity?
	private String msg=null, url=null;
	
	private static HashMap<String, HashMap<String, Date>> map=new HashMap<String,HashMap<String,Date>>();
	
	
	//?Wrong (Constructor) Example 
	@RequestMapping(value = "/tftube_main", method = RequestMethod.GET)
	public ModelAndView tftube_main(HttpServletRequest arg0, 
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav=new ModelAndView();
		
		//local variable
		//Problems occur when you access another page directly without going through the main.
		HttpSession session=arg0.getSession();
		
		/*System.out.println("contextPath"+arg0.getContextPath());
		System.out.println("servletPath"+arg0.getServletPath());*/
		
		List<VideoDTO> list=videoDAO.listVideo();		
		MemberDTO member=(MemberDTO)session.getAttribute("memberDTO");
		System.out.println("member:"+member);
		/*System.out.println("main_list:"+list);*/
		
		/*no가 뭐냐? 필요 없는 코드 같은데. 중복 방지를 위해서*/
		/*if(session.getAttribute("no")!=null){
			session.removeAttribute("no");
		}*/
		
		/*upPath_image="D:\\workspace_tftube\\techfarm\\src\\main\\webapp\\resources\\tftube\\uploadImage";
		upPath_video="D:\\workspace_tftube\\techfarm\\src\\main\\webapp\\resources\\tftube\\uploadVideo";*/
		/*upPath_image=session.getServletContext().getRealPath("/resources/tftube/"+member.getId()+"Image");*/
		/*upPath_video=session.getServletContext().getRealPath("/resources/tftube/"+member.getId()+"Video");*/
		upPath_image=session.getServletContext().getRealPath("/resources/tftube/uploadImage");
		upPath_video=session.getServletContext().getRealPath("/resources/tftube/uploadVideo");
		
		
				
		session.setAttribute
		("upPath_image",upPath_image);		
		session.setAttribute
		("upPath_video", upPath_video);	
		session.setAttribute
		("list",list);		
		mav.setViewName("tftube/main");
		
		return mav;
	}	
	
	@RequestMapping(value="/tftube_video_insert", method=RequestMethod.GET)
	public ModelAndView tftube_video_insertForm(HttpServletRequest arg0, 
								HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();		
		mv.setViewName("tftube/insertForm");
		return mv;		
	}
	
	@RequestMapping(value="/tftube_video_insert", method=RequestMethod.POST)
	public ModelAndView tftube_video_insertPro(HttpServletRequest arg0, 
								HttpServletResponse arg1)  throws Exception  {
		VideoDTO dto = new VideoDTO();
		ModelAndView mv=new ModelAndView();		
		

		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)arg0;
		MultipartFile mf = mr.getFile("filename");
		String filename = mf.getOriginalFilename();
		
		
		/*if(!(filename.substring(filename.length()-3, filename.length()).equals("mp4"))){			
			msg="only mp4 available";
			url="tftube_video_insert";
			return new ModelAndView("tftube/message");
		}*/
		HttpSession session=arg0.getSession();		
		
		
		File upPath_video_file=new File(upPath_video);
		File file = new File(upPath_video,filename);
		
		if(!upPath_video_file.isDirectory()){//해당경로가 존재하지 않는다면
			upPath_video_file.mkdirs();			
		}
		
		if(filename.trim().equals("")){}
		else{
		mf.transferTo(file);		
		}		

		Sha3 sha3=new Sha3();
		String video_hash=sha3.Digest_Sha3(file);
		
		MultipartFile mf2 = mr.getFile("image");
		String image = mf2.getOriginalFilename(); 			
		
		File file2 = new File(upPath_image,image);
		File upPath_image_file=new File(upPath_image);
		if(!upPath_image_file.isDirectory()){//해당경로가 존재하지 않는다면
			upPath_image_file.mkdirs();			
		}
		
			
		if(image.trim().equals("")){}
		else{
		mf2.transferTo(file2);
		}
		
		String image_hash=sha3.Digest_Sha3(file2);
		MemberDTO memberdto=(MemberDTO)session.getAttribute("memberDTO");
		dto.setDescription(ServletRequestUtils.getStringParameter(arg0, "description"));
		dto.setMember_no(memberdto.getNo());
		//when !login but insert
		dto.setVideo_name(filename);
		dto.setOpen(ServletRequestUtils.getStringParameter(arg0, "open"));
		dto.setTitle(ServletRequestUtils.getStringParameter(arg0, "title"));
		dto.setVideo_size((int)mf.getSize());	
		dto.setImage(image);
		dto.setVideo_hash(video_hash);
		dto.setImage_hash(image_hash);
		;
		dto.setChannel(mychannelDAO.getChannel(memberdto.getNo()));
		
		int res =videoDAO.insertVideo(dto);	
		if(res>0){			
			mv.setViewName("redirect:tftube_main");			
		}
		else{
			msg="file upload failed.";
			url="tftube_video_insert";
			mv.setViewName("message");
			mv.addObject("msg",msg);
			mv.addObject("url",url);				
		}		
		return mv;
	}	
	
	
	@RequestMapping(value="/tftube_videoView", method=RequestMethod.GET)
	public ModelAndView tftube_videoView(HttpServletRequest arg0, 
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
		/*like*/		
		//response
		int like_status=videoDAO.getVideo(no).getLike_status();
		int unlike_status=videoDAO.getVideo(no).getUnlike_status();
		/*System.out.println("response like:"+like_status);
		System.out.println("response unlike:"+unlike_status);*/
		mv.addObject("like_status",like_status);
		mv.addObject("unlike_status",unlike_status);		
		//end of response
		/*String like_video_no_raw=arg0.getParameter("like_video_no");
		int like_video_no=Integer.parseInt(like_video_no_raw);*/
		//request
		String like_req_raw=arg0.getParameter("likep");//0 not like
		String unlike_req_raw=arg0.getParameter("unlikep");
		//null->not likes method
		//not null->likes method
		/*0->실행 x  
		 *1->click_like 실행 
		 * 나간값 0 들어온값 0 실행x default 0 
		 * 나간값 0 들어온값 1 좋아요 누름 
		 * 나간값 1 들어온값 0 좋아요 취소
		 * 나간값 1 들어온값 1 실행 x
		 * */
		//어떤 목적으로 나눠놨던가? nullpointException을 잘 파악하기 위함 이었던가.		
		/*VideoDTO likedto=new VideoDTO();*/
		if(like_req_raw!=null){
			int like_req=Integer.parseInt(like_req_raw);			
				if(like_req>like_status){
					videoDAO.click_like(no);					
					//likep 1증가 like_status=1
				}else if(like_req<like_status){
					videoDAO.cancel_like(no);			
				}
				mv.addObject("like_status",like_req);
		}
		
		if(unlike_req_raw!=null){
			int unlike_req=Integer.parseInt(unlike_req_raw);			
			if(unlike_req>unlike_status){
			videoDAO.click_unlike(no);			
			}else if(unlike_req<unlike_status){
			videoDAO.cancel_unlike(no);			
			}
			mv.addObject("unlike_status",unlike_req);	
		}
		vdto=videoDAO.getVideo(no);
		/*mv.addObject("vdto",vdto);*///consider of like only
		/*end of like*/
		
		/*sub*/
		
		//response
		int cu_member_no=0;
		int subing_member=0;
		int saved_subing_member=0;
		saved_subing_member=subingDAO.get_subing_member(cu_member_no);
		
		if(saved_subing_member!=0){
			mv.addObject("subing_status",1);
		}else{
			mv.addObject("subing_status",0);
		}
		
		//end of response
		
		
		//request
		String subing_member_no_raw=arg0.getParameter("subing_member_no");
		MemberDTO cu_member=(MemberDTO)session.getAttribute("memberDTO");
		
		SubingDTO sidto=null;
		SubedDTO sddto=null;
		if(subing_member_no_raw!=null){
		sidto=new SubingDTO();		
		String cu_channel=mychannelDAO.getChannel(cu_member_no);		
		sidto.setChannel(cu_channel);
		sidto.setMember_no(cu_member.getNo());	
		sidto.setSubing_member_no(subing_member);
		
		
	
		sddto.setChannel(vdto.getChannel());
		sddto.setMember_no(vdto.getMember_no());
		sddto.setSubed_member_no(cu_member.getNo());
		}			
		
		String subing_status_raw=arg0.getParameter("subing_status");
		int subing_status=0;
		if(subing_status_raw!=null){
			subing_status=Integer.parseInt(subing_status_raw);
			if(subing_status==1){
			int res=subingDAO.insertSubing(sidto);
			subedDAO.insertSubed(sddto);
			mv.addObject("subing_status",res);
			}
		}
		
		
		//?
		session.setAttribute("video_no",no);//error and time lag
		
		Date today=new Date();//today				
		Long today_day=today.getTime()/1000/3600/24;
		
		/*Date date=map.get(vdto.getVideo_hash());//video's date clicked information		
*/
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
		mv.addObject("vdto",vdto);
		//size of reply
		mv.addObject("r_size",r_size);
		mv.addObject("no",no);
		
			
		mv.setViewName("tftube/videoView");			
		
		/*int pageSize = 5;
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
		*/
		/*List<ReplyDTO> list =replyDAO.listBoard(startRow, endRow);*/			
		/*
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
		mv.addObject("number",number);*/	
		return mv;
		
	}
	
	@RequestMapping(value="/tftube_video_delete", method=RequestMethod.GET)
	public ModelAndView tftube_video_delete(HttpServletRequest arg0, 
								HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();
		int no=Integer.parseInt(arg0.getParameter("no"));
		
		VideoDTO vdto=videoDAO.getVideo(no);
		String video_name=vdto.getVideo_name();
		//delete from tftube_video
		int res=videoDAO.deleteVideo(no);
		
		if(res>0){
			mv.setViewName("redirect:tftube_main");	
			//delete file
			File deletefile=new File(upPath_video,video_name);
			File deleteimage=new File(upPath_image,vdto.getImage());
			deletefile.delete();
			deleteimage.delete();
			//delete reply where video_name=video_name
			replyDAO.delete_reply_video_name(video_name);
		}
		else{
			msg="file delete failed.";
			url="tftube_videoView";
			mv.setViewName("message");
			mv.addObject("msg",msg);
			mv.addObject("url",url);				
		}		
		return mv;		
	}	
}
