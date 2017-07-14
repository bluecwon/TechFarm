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
import com.itbank.TechFarm.tftube.dao.RecentVideoDAO;
import com.itbank.TechFarm.tftube.dto.RecentVideoDTO;


@Controller
public class RecentVideoController {
	@Autowired
	private RecentVideoDAO recentvideoDAO;
	
	private HttpSession session=null;
	String msg=null, url=null;	
	
	@RequestMapping(value="/tftube_recentvideo_listRecent_member_no", method=RequestMethod.GET)
	public ModelAndView tftube_recentvideo_listRecent_member_no(HttpServletRequest arg0, 
								HttpServletResponse arg1) throws Exception {		
		ModelAndView mv=new ModelAndView();
		session=arg0.getSession();
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("memberDTO");
		String ip=arg0.getRemoteAddr();
		List<RecentVideoDTO> recent_list=null;
		
		
		int member_no=memberDTO.getNo();
		recent_list=recentvideoDAO.listRecent_member_no(member_no);		


		
		
		mv.addObject("recent_list",recent_list);		
		mv.setViewName("tftube/recentVideo");		
		return mv;
	}
}
