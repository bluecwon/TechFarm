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

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;
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
	
	@RequestMapping(value="/tftube_reply_insert", method=RequestMethod.GET)
	public ModelAndView tftube_reply_insert(HttpServletRequest arg0, 
								HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();
		
		session=arg0.getSession();
		MemberDTO member=(MemberDTO)session.getAttribute("memberDTO");
		
		ReplyDTO dto=new ReplyDTO();		
		
		dto.setContent(arg0.getParameter("content").trim());
		dto.setMember_no(member.getNo());//null
		dto.setVideo_name(arg0.getParameter("video_name"));
		int res=replyDAO.insertReply(dto);
		
		if(res>0){
			mv.setViewName("redirect:tftube_videoView");			
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
	
	
	
	
	 


}
