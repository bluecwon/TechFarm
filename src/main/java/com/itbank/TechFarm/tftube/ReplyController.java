package com.itbank.TechFarm.tftube;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.login.member.MemberDTO;
import com.itbank.TechFarm.tftube.dao.ReplyDAO;
import com.itbank.TechFarm.tftube.dto.ReplyDTO;
@Controller
public class ReplyController {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	private String upPath_file=null;
	private String upPath_img=null;
	private HttpSession session=null;
	String msg=null, url=null;	
	
	@RequestMapping(value="/tftube_reply_insert.do", method=RequestMethod.GET)
	public ModelAndView tftube_reply_insert(HttpServletRequest arg0, 
								HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();
		session=arg0.getSession();
		String id=(String)session.getAttribute("tube_id");
		ReplyDTO dto=new ReplyDTO();		
		dto.setContent(arg0.getParameter("content").trim());
		dto.setMember_no(((MemberDTO)session.getAttribute("memberDTO")).getNo());	
		int res=replyDAO.insertReply(dto);
		
		if(res>0){
			mv.setViewName("redirect:tftube_main");			
		}
		else{
			msg="fail to reply";
			url="tftube_main.do";
			mv.setViewName("tftube/message");
			mv.addObject("msg",msg);
			mv.addObject("url",url);				
		}			
		return mv;		
	}
	
	public static String md5(File file) throws IOException, NoSuchAlgorithmException { 


	     BufferedInputStream bis = null; 

	     try { 
	         bis = new BufferedInputStream(new FileInputStream(file)); 
	         MessageDigest md = MessageDigest.getInstance("MD5"); 
	         int read = -1; 
	         byte[] buffer = new byte[1024]; 
	         while ((read = bis.read(buffer)) != -1) { 
	             md.update(buffer, 0, read); 
	             
	         } 
	         return String.valueOf(md.digest()); 


	     } finally { 
	        if (bis != null) try { bis.close(); } catch(IOException e) {e.printStackTrace();} 


	     } //end of finally


	 } 

}
