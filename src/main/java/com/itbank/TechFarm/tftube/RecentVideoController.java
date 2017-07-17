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
import com.itbank.TechFarm.tftube.dao.VideoDAO;
import com.itbank.TechFarm.tftube.dto.RecentVideoDTO;
import com.itbank.TechFarm.tftube.dto.VideoDTO;


@Controller
public class RecentVideoController {
	@Autowired
	private RecentVideoDAO recentvideoDAO;
	
	@Autowired
	private VideoDAO videoDAO;
	
	private HttpSession session=null;
	String msg=null, url=null;	
	
	@RequestMapping(value="/tftube_recentvideo_listRecent_member_no", method=RequestMethod.GET)
	public ModelAndView tftube_recentvideo_listRecent_member_no(HttpServletRequest arg0, 
								HttpServletResponse arg1) throws Exception {		
		ModelAndView mv=new ModelAndView();
		session=arg0.getSession();
		MemberDTO memberDTO=null;
		
		Object memberDTO_raw=session.getAttribute("memberDTO");
		if(memberDTO_raw==null){		 
		msg="로그인이 필요한 서비스입니다. 로그인 해주세요.";
		url="login";
		mv.setViewName("tftube/message");
		return mv;
		}else{
			memberDTO=(MemberDTO)memberDTO_raw;
		}
		
		String ip=arg0.getRemoteAddr();		
		int member_no=memberDTO.getNo();
		
		List<VideoDTO> recent_list=videoDAO.listRecent_inf(member_no);
		mv.addObject("recent_list",recent_list);		
		mv.setViewName("tftube/recentVideo");		
		return mv;
	}
}
