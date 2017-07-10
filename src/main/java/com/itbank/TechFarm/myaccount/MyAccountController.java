package com.itbank.TechFarm.myaccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.login.member.MemberDAO;
import com.itbank.TechFarm.login.member.MemberDTO;

@Controller
public class MyAccountController {
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(value = "/myAccount", method = RequestMethod.GET)
	public ModelAndView myAccount(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView("myaccount/myaccountmain");
		return mav;
	}
	
	@RequestMapping(value = "/editMyInfo", method = RequestMethod.GET)
	public ModelAndView editInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView("myaccount/editInfo");
		return mav;
	}
	
	@RequestMapping(value = "/editMyInfo", method = RequestMethod.POST)
	public ModelAndView editInfo2(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		MemberDTO dto=new MemberDTO();
		dto.setId(request.getParameter("id"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setBirthday_year(Integer.parseInt(request.getParameter("birthday_year")));
		dto.setBirthday_month(Integer.parseInt(request.getParameter("birthday_month")));
		dto.setBirthday_day(Integer.parseInt(request.getParameter("birthday_day")));
		dto.setSex(ServletRequestUtils.getIntParameter(request, "sex", 0));
		int res=memberDAO.editMember(dto);
		if(res==1){
			mav.setViewName("redirect:myAccount");
			MemberDTO info=memberDAO.getMember(dto.getId());
			request.getSession().invalidate();
			request.getSession().setAttribute("memberDTO", info);
		}else{
			mav.setViewName("redirect:editMyInfo");
		}
		return mav;
	}
}
