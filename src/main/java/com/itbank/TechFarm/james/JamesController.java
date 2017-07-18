package com.itbank.TechFarm.james;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itbank.TechFarm.login.member.MemberDTO;

@Controller
public class JamesController {
	@Autowired
	private JamesDAO jamesDAO;
	
	@RequestMapping(value="/listJames", method = RequestMethod.GET)
	public String listJames(Model model, HttpServletRequest request, HttpSession session){
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("memberDTO");
		JamesDTO dto = new JamesDTO();
		dto.setId(memberDTO.getId());
		dto.setPassword(memberDTO.getPasswd());
		dto.setFolder("INBOX");
		List<JamesDTO> listJames = jamesDAO.listJames(dto);
		model.addAttribute("listJames", listJames);
		return "james/listJames";
	}
	@RequestMapping(value="/sendJames", method = RequestMethod.GET)
	public String sendJames(Model model, HttpServletRequest request){
		String to = request.getParameter("to");
		if(to!=null){
			model.addAttribute("to", to);
		}
		return "james/sendJames";
	}
	
	@RequestMapping(value="/sendJames", method = RequestMethod.POST)
	public String sendJamesPro(Model model, JamesDTO dto, HttpServletRequest request, HttpSession session){
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("memberDTO");
		dto.setId(memberDTO.getId());
		dto.setPassword(memberDTO.getPasswd());
		int res = jamesDAO.sendJames(dto);
		return "james/listJames";
	}
	@RequestMapping(value="/getJames", method = RequestMethod.GET)
	public String getJames(Model model, JamesDTO dto, HttpServletRequest request, HttpSession session){
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("memberDTO");
		dto.setId(memberDTO.getId());
		dto.setPassword(memberDTO.getPasswd());
		dto.setFolder("INBOX");
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		JamesDTO jameDTO = jamesDAO.getJames(dto);
		return "james/getJames"; 
	}
}