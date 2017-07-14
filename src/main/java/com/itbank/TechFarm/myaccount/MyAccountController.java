package com.itbank.TechFarm.myaccount;

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

import com.itbank.TechFarm.login.member.MemberDAO;
import com.itbank.TechFarm.login.member.MemberDTO;

@Controller
public class MyAccountController {
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(value = "/myAccount", method = RequestMethod.GET)
	public String myAccount(HttpServletRequest request, HttpServletResponse response) {
		return "myaccount/myaccountmain";
	}
	
	@RequestMapping(value = "/editMyInfo", method = RequestMethod.GET)
	public String editInfo(HttpServletRequest request, HttpServletResponse response) {
		return "myaccount/editInfo";
	}
	
	@RequestMapping(value = "/editMyPw", method = RequestMethod.GET)
	public String editPw(HttpServletRequest request, HttpServletResponse response) {
		return "myaccount/editPw";
	}
	
	@RequestMapping(value = "/editMyPw", method = RequestMethod.POST)
	public String checkCurrentPw(HttpServletRequest request, HttpSession session, Model model) {
		String passwd=request.getParameter("currentpasswd");
		MemberDTO dto=(MemberDTO)session.getAttribute("memberDTO");
		if(dto.getPasswd().equals(passwd)){
			model.addAttribute("cid", 1);
		}else{
			model.addAttribute("cid", 2);
		}
		return "myaccount/editPw";
	}
	
	@RequestMapping(value = "/updateMyPw", method = RequestMethod.POST)
	public String updateCurrentPw(HttpServletRequest request, HttpSession session, Model model) {
		String passwd=request.getParameter("passwd");
		String checkpasswd=request.getParameter("checkpasswd");
		if(checkpasswd.equals(passwd)){
			MemberDTO dto=(MemberDTO)session.getAttribute("memberDTO");
			dto.setPasswd(passwd);
			int res=memberDAO.editPw(dto);
		}else{
			model.addAttribute("cid", 1);
			return "myaccount/editPw";
		}
		return "redirect:myAccount";
	}
	
	@RequestMapping(value = "/editMyInfo", method = RequestMethod.POST)
	public String editInfo2(@Valid @ModelAttribute("inputInfo") MemberDTO dto, Errors errors,HttpSession session) {
		int res=memberDAO.editMember(dto);
		if(res==1){
			MemberDTO info=memberDAO.getMember(dto.getId());
			session.removeAttribute("memberDTO");
			session.setAttribute("memberDTO", info);
			return "redirect:myAccount";
		}else{
			return "redirect:editMyInfo";
		}
	}
	
	@RequestMapping(value = "/deleteMember", method = RequestMethod.GET)
	public String deleteMember(HttpServletRequest request, HttpSession session, Model model) {
		return "myaccount/deleteAccount";
	}
	
	@RequestMapping(value = "/deleteMember", method = RequestMethod.POST)
	public String checkCurrentPwForDelete(HttpServletRequest request, HttpSession session, Model model) {
		String passwd=request.getParameter("currentpasswd");
		MemberDTO dto=(MemberDTO)session.getAttribute("memberDTO");
		if(dto.getPasswd().equals(passwd)){
			model.addAttribute("cid", 1);
			model.addAttribute("deletesentence", dto.getId()+"는 TechFarm을 탈퇴하겠습니다.");
		}else{
			model.addAttribute("cid", 2);
		}
		return "myaccount/deleteAccount";
	}
	
	@RequestMapping(value = "/deleteMyAccount", method = RequestMethod.POST)
	public String deleteMyAccount(HttpServletRequest request, HttpSession session, Model model) {
		MemberDTO dto=(MemberDTO)session.getAttribute("memberDTO");
		int res=memberDAO.deleteMember(dto.getNo());
		if(res==1){
			session.invalidate();
			return "home";
		}else{
			return "redirect:deleteMember";
		}
		
	}
}
