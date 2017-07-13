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
import com.itbank.TechFarm.tftube.dao.RecentVideoDAO;
import com.itbank.TechFarm.tftube.dao.ReplyDAO;
import com.itbank.TechFarm.tftube.dao.VideoDAO;
import com.itbank.TechFarm.tftube.dto.RecentVideoDTO;
import com.itbank.TechFarm.tftube.dto.ReplyDTO;
import com.itbank.TechFarm.tftube.dto.VideoDTO;
import com.itbank.TechFarm.tftube.java.Sha3;


 
@Controller
public class TftubeController {
	
	@Autowired
	private VideoDAO videoDAO;
	@Autowired
	private ReplyDAO replyDAO;	
	@Autowired
	private RecentVideoDAO recentvideoDAO;
	
	
	private String upPath_video=null;
	private String upPath_image=null;
	/*private HttpSession session=null;*///re_check Is it necessity?
	private String msg=null, url=null;
	
	private static HashMap<String, Date> map=new HashMap<String,Date>();
	
	
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
		System.out.println("main_list:"+list);
		
		/*no가 뭐냐? 필요 없는 코드 같은데. 중복 방지를 위해서ㅈ거*/
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
		
		dto.setDescription(ServletRequestUtils.getStringParameter(arg0, "description"));
		dto.setMember_no(((MemberDTO)session.getAttribute("memberDTO")).getNo());
		//when !login but insert
		dto.setVideo_name(filename);
		dto.setOpen(ServletRequestUtils.getStringParameter(arg0, "open"));
		dto.setTitle(ServletRequestUtils.getStringParameter(arg0, "title"));
		dto.setVideo_size((int)mf.getSize());	
		dto.setImage(image);
		dto.setVideo_hash(video_hash);
		dto.setImage_hash(image_hash);
		
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
		
		String no_raw=arg0.getParameter("no");
		int no=0;
		if(no_raw!=null){
		no=Integer.parseInt(no_raw);}//tftube_video
		VideoDTO vdto=videoDAO.getVideo(no);//video's total information
		
		/*like*/		
		
		//request
		String like_stat_raw=arg0.getParameter("like");
		String unlike_stat_raw=arg0.getParameter("unlike");
				
		System.out.println("like_status_raw:"+like_stat_raw);
		System.out.println("unlike_status_raw:"+unlike_stat_raw);
		
		int res_like=0;
		int res_unlike=0;
		
		if(like_stat_raw!=null){
			int like_stat=Integer.parseInt(like_stat_raw);			 
				switch(like_stat){
				case 1:res_like=videoDAO.click_like(1);
				case 0:res_like=videoDAO.cancel_like(0);		
				}
		}
		
		if(unlike_stat_raw!=null){
			int unlike_stat=Integer.parseInt(unlike_stat_raw);			
			switch(unlike_stat){
			case 1:res_unlike=videoDAO.click_unlike(1);
			case 0:res_unlike=videoDAO.cancel_unlike(0);		
			}			
		}
		//end of response
		
		//response
		int like_status=videoDAO.getVideo(no).getLike_status();
		int unlike_status=videoDAO.getVideo(no).getUnlike_status();
		mv.addObject("like",like_status);
		mv.addObject("unlike",unlike_status);		
		//end of response		
		/*end of like*/
		
		session.setAttribute("video_no",no);//error and time lag
		Date today=new Date();//today			
		
			
		
		Date date=map.get(vdto.getVideo_hash());//video's date clicked information		

		String ip=arg0.getRemoteAddr();
		
		MemberDTO member=new MemberDTO();
		
		//start of hits' validity 
		HashSet<String> ipset=new HashSet();
		Iterator it=ipset.iterator();
		boolean p;
		while(it.hasNext()){
			if(it.next().equals(ip)){p=true; break;}
			else{p=false;}
		}		
		
		Long today_time=today.getTime()/1000/(3600*24);
		
		Long date_time=null;
		
		if(date!=null){
		date_time=date.getTime()/1000/(3600*24);}				
		
		if(p=false && (today_time-date_time>=1 ||date==null)){		
			ipset.add(ip);
			videoDAO.hitUp(no);
			map.put(vdto.getVideo_hash(), today);			
		}			
		// end of hits' validity
				
		//start of hits' format 
		DecimalFormat df=new DecimalFormat("#,##0");
		String readcount=df.format(vdto.getReadcount());
		//end of hits' format 
		
		//logined member information at present
		Object member_object=session.getAttribute("memberDTO");
		if(member_object!=null){
		member=(MemberDTO)member_object;
		}
		
		//start of RecentVideo insert 		
		RecentVideoDTO recent_dto=new RecentVideoDTO();
		
		if(member_object!=null){
		recent_dto.setMember_no(member.getNo());
		recent_dto.setVideo_name(vdto.getVideo_name());
		
		int res=recentvideoDAO.insertRecent(recent_dto);
		}else{
			recent_dto.setIp(ip);
			recent_dto.setVideo_name(vdto.getVideo_name());
			
			int res=recentvideoDAO.insertRecent(recent_dto);			
		}
		//end of RecentVideo insert 		
		
		//ReplyList where=video		
		List<ReplyDTO> r_list=replyDAO.replyList_by_video(vdto.getVideo_name());
		String r_size=df.format(r_list.size());
		//member_no
		
		//Reply writer
		//String r_name=replyDAO.getName(member_no);		
		
		//information of recent video
		mv.addObject("vdto",vdto);		
		//hits of reply
		mv.addObject("readcount",readcount);		
		//list of reply where video
		mv.addObject("r_list",r_list);
		//writer of reply
		//mv.addObject("r_name",r_name);
		//size of reply
		mv.addObject("r_size",r_size);
		
			
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
		//delete from tftube_video
		int res=videoDAO.deleteVideo(no);
		
		if(res>0){
			mv.setViewName("redirect:tftube_main");	
			//delete file
			File deletefile=new File(upPath_video,vdto.getVideo_name());
			File deleteimage=new File(upPath_image,vdto.getImage());
			//resources/tftube/uploadVideo/
			deletefile.delete();
			deleteimage.delete();
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
