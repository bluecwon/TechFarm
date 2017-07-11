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
		ContactsDTO dto = makeDTO(request);
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("memberDTO"); 
		dto.setId(memberDTO.getId());
		int res = contactsDAO.addContact(dto);
		mav.setViewName("redirect:listContacts");
		return mav;
	}
	@RequestMapping(value="/getContact", method = RequestMethod.GET)
	public ModelAndView getContact(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		int no = Integer.parseInt(request.getParameter("no"));
		ContactsDTO dto = contactsDAO.getContact(no);
		mav.setViewName("/contacts/getContact");
		mav.addObject("dto", dto);
		return mav;
	}
	@RequestMapping(value="/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		int no = Integer.parseInt(request.getParameter("no"));
		ContactsDTO dto = contactsDAO.getContact(no);
		mav.setViewName("/contacts/editContact");
		mav.addObject("dto", dto);
		return mav;
	}
	@RequestMapping(value="/editContact", method = RequestMethod.POST)
	public ModelAndView editContactPro(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		ContactsDTO dto = makeDTO(request);
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		int res = contactsDAO.editContact(dto);
		mav.setViewName("redirect:listContacts");
		return mav;
	}
	private ContactsDTO makeDTO(HttpServletRequest request){
		ContactsDTO dto = new ContactsDTO();
		dto.setName(request.getParameter("name"));
		dto.setCompany(request.getParameter("company"));
		dto.setJobtitle(request.getParameter("jobtitle"));
		dto.setEmail(request.getParameter("email"));
		dto.setPhone(request.getParameter("phone"));
		dto.setNotes(request.getParameter("notes"));
		return dto;
	}
	@RequestMapping(value="/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		int no = Integer.parseInt(request.getParameter("no"));
		int res = contactsDAO.deleteContact(no);
		mav.setViewName("redirect:listContacts");
		return mav;
	}
	
}
