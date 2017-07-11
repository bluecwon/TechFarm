package com.itbank.TechFarm.contacts;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.login.member.MemberDTO;

@Controller
public class ContactsController {
	@Autowired
	private ContactsDAO contactsDAO;
	
	@RequestMapping(value = "/listContacts", method = RequestMethod.GET)
	public String listContacts(Model model, HttpServletRequest request, HttpServletResponse response){
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("memberDTO"); 
		String id = memberDTO.getId();
		List<ContactsDTO> listContacts = contactsDAO.listContacts(id);
		model.addAttribute("listContacts", listContacts);
		return "contacts/listContacts";
	}
	
	@RequestMapping(value = "/addContact", method = RequestMethod.GET)
	public String addContact(Locale locale, Model model) {
		return "contacts/addContact";
	}
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContactPro(ContactsDTO dto, HttpServletRequest request, HttpServletResponse response){
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("memberDTO"); 
		dto.setId(memberDTO.getId());
		int res = contactsDAO.addContact(dto);
		return "redirect:listContacts";
	}
	@RequestMapping(value="/getContact", method = RequestMethod.GET)
	public String getContact(Model model, HttpServletRequest request, HttpServletResponse response){
		int no = Integer.parseInt(request.getParameter("no"));
		ContactsDTO dto = contactsDAO.getContact(no);
		model.addAttribute("dto", dto);
		return "contacts/getContact";
	}
	@RequestMapping(value="/editContact", method = RequestMethod.GET)
	public String editContact(Model model, HttpServletRequest request, HttpServletResponse response){
		int no = Integer.parseInt(request.getParameter("no"));
		ContactsDTO dto = contactsDAO.getContact(no);
		model.addAttribute("dto", dto);
		return "contacts/editContact";
	}
	@RequestMapping(value="/editContact", method = RequestMethod.POST)
	public String editContactPro(ContactsDTO dto, HttpServletRequest request, HttpServletResponse response){
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		int res = contactsDAO.editContact(dto);
		return "redirect:listContacts";
	}
	
	@RequestMapping(value="/deleteContact", method = RequestMethod.GET)
	public String deleteContact(HttpServletRequest request, HttpServletResponse response){
		int no = Integer.parseInt(request.getParameter("no"));
		int res = contactsDAO.deleteContact(no);
		return "redirect:listContacts";
	}
	
}
