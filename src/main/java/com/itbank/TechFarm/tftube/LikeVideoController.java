package com.itbank.TechFarm.tftube;

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
import com.itbank.TechFarm.tftube.dao.VideoDAO;
import com.itbank.TechFarm.tftube.dto.VideoDTO;

@Controller
public class LikeVideoController {
	@Autowired
	private VideoDAO videoDAO;
	
	
	String msg=null,url=null;
	@RequestMapping(value="/likeVideo", method=RequestMethod.GET)
	public ModelAndView likeVideo(HttpServletRequest arg0, 
			HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();
		HttpSession session=arg0.getSession();
		MemberDTO member=(MemberDTO)session.getAttribute("memberDTO");
		int member_no=0;	
		if(member==null){
			msg="로그인이 필요한 서비스 입니다. 로그인을 해주세요.";
			url="login";
			mv.addObject("msg",msg);
			mv.addObject("url",url);
			mv.setViewName("tftube/message");			
		}else{	
		member_no=member.getNo();
		List<VideoDTO> like_list=videoDAO.listLike(member_no);		
		mv.addObject("like_list",like_list);
		mv.setViewName("tftube/carefullVideo");
		}
		return mv;
	}
	
}
