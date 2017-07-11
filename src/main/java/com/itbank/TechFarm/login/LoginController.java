package com.itbank.TechFarm.login;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.login.member.MemberDAO;
import com.itbank.TechFarm.login.member.MemberDTO;

@Controller
public class LoginController {
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView("login/login");
		String id=request.getParameter("id");
		MemberDTO dto=memberDAO.getLogin(id);
		request.getSession().setAttribute("loginDTO", dto);
		if(dto==null){
			mav.addObject("cid", 2);
		}else{
			mav.addObject("cid", 1);
		}
		return mav;
	}
	
	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public ModelAndView login2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mav=new ModelAndView();
		String passwd=request.getParameter("passwd");
		MemberDTO dto=(MemberDTO)request.getSession().getAttribute("loginDTO");
		if(dto.getPasswd().equals(passwd)){
			MemberDTO info=memberDAO.getMember(dto.getId());
			request.getSession().invalidate();
			request.getSession().setAttribute("memberDTO", info);
			mav.setViewName("redirect:/");				
			return mav;
		}else{
			mav.addObject("cidd", 3);
			mav.addObject("cid", 1);
			mav.setViewName("login/login");
			return mav;
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView("home");
		request.getSession().invalidate();
		return mav;
	}
	
	@RequestMapping(value = "/createAccount", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login/createAccount";
	}
	
	@RequestMapping(value = "/inputmember", method = RequestMethod.POST)
	public String inputMember(@ModelAttribute("inputInfo") @Valid MemberDTO dto, Errors errors) {
		if(errors.hasErrors()){
			return "login/createAccount";
		}
		int res=memberDAO.insertMember(dto);
		if(res==1){
			return "redirect:login";
		}else{
			return "redirect:createAccount";
		}
	}
	
}
