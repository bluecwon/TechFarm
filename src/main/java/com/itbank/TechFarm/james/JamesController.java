package com.itbank.TechFarm.james;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itbank.TechFarm.login.member.MemberDTO;

@Controller
public class JamesController {
	String host="52.79.140.54";
	String mailStoreType ="imap";
	
	@RequestMapping(value="/listJames", method = RequestMethod.GET)
	public String listJames(Model model, HttpServletRequest request, HttpSession session){
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("memberDTO");
		String id = memberDTO.getId();
		String passwd = memberDTO.getPasswd();
		
		return "james/listJames";
	}
	@RequestMapping(value="/composeJames", method = RequestMethod.GET)
	public String composeJames(Model model, HttpServletRequest request){
		
		return "james/composeJames";
	}
}
