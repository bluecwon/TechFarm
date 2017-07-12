package com.itbank.TechFarm.login;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
	public String login(HttpServletRequest request, HttpSession session, Model model) {
		String id=request.getParameter("id");
		MemberDTO dto=memberDAO.getLogin(id);
		session.setAttribute("loginDTO", dto);
		if(dto==null){
			model.addAttribute("cid", 2);
		}else{
			model.addAttribute("cid", 1);
		}
		return "login/login";
	}
	
	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public String login2(Model model,HttpServletRequest request, HttpSession session) throws IOException {
		String passwd=request.getParameter("passwd");
		MemberDTO dto=(MemberDTO)session.getAttribute("loginDTO");
		if(dto.getPasswd().equals(passwd)){
			MemberDTO info=memberDAO.getMember(dto.getId());
			session.removeAttribute("loginDTO");
			session.setAttribute("memberDTO", info);			
			return "redirect:/";
		}else{
			model.addAttribute("cidd", 3);
			model.addAttribute("cid", 1);
			return "login/login";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpSession session) {
		session.invalidate();
		return "home";
	}
	
	@RequestMapping(value = "/createAccount", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login/createAccount";
	}
	
	@RequestMapping(value = "/inputmember", method = RequestMethod.POST)
	public String inputMember(@Valid @ModelAttribute("inputInfo") MemberDTO dto, Errors errors) {
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
