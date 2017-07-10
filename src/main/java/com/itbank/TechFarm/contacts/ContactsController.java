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
	public ModelAndView listContacts(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("memberDTO"); 
		String id = memberDTO.getId();
		List<ContactsDTO> listContacts = contactsDAO.listContacts(id);
		mav.setViewName("contacts/listContacts");
		mav.addObject("listContacts", listContacts);
		return mav;
	}
	
	@RequestMapping(value = "/addContact", method = RequestMethod.GET)
	public String addContact(Locale locale, Model model) {
		return "contacts/addContact";
	}
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public ModelAndView addContactPro(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		ContactsDTO dto = new ContactsDTO();
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("memberDTO"); 
		dto.setId(memberDTO.getId());
		dto.setName(request.getParameter("name"));
		dto.setCompany(request.getParameter("company"));
		dto.setJobtitle(request.getParameter("jobtitle"));
		dto.setEmail(request.getParameter("email"));
		dto.setPhone(request.getParameter("phone"));
		dto.setNotes(request.getParameter("notes"));
		int res = contactsDAO.addContact(dto);
		mav.setViewName("redirect:listContacts");
		return mav;
	}
	
	
}
