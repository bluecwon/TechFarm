package com.itbank.TechFarm.contacts;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.itbank.TechFarm.login.member.MemberDTO;

@Controller
public class ContactsController {
	@Autowired
	private ContactsDAO contactsDAO;
	
	@RequestMapping(value = "/listContacts", method = RequestMethod.GET)
	public String listContacts(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session){
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("memberDTO"); 
		String id = memberDTO.getId();
		List<ContactsDTO> listContacts = contactsDAO.listContacts(id);
		String upPath = session.getServletContext().getRealPath("/resources/contacts/upload");
		model.addAttribute("listContacts", listContacts);
		return "contacts/listContacts";
	}
	
	@RequestMapping(value = "/addContact", method = RequestMethod.GET)
	public String addContact(Locale locale, Model model) {
		return "contacts/addContact";
	}
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContactPro(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("memberDTO"); 
		ContactsDTO dto = new ContactsDTO();
		dto.setId(memberDTO.getId());
		
		dto.setName(request.getParameter("name"));
		dto.setCompany(request.getParameter("company"));
		dto.setJobtitle(request.getParameter("jobtitle"));
		dto.setEmail(request.getParameter("email"));
		dto.setPhone(request.getParameter("phone"));
		dto.setNotes(request.getParameter("notes"));
		//파일받기
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
		MultipartFile mf = mr.getFile("photo");
		String filename = mf.getOriginalFilename();
				
		//파일 경로 지정하기
		String upPath = session.getServletContext().getRealPath("/resources/contacts/upload");
		
		//서버에 파일 쓰기
		if(!filename.isEmpty()){
			File file = new File(upPath, filename);
			try {
				mf.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			filename="account.png";
		}
		dto.setPhoto(filename);	
		
		int res = contactsDAO.addContact(dto);
		return "redirect:listContacts";
	}
	@RequestMapping(value="/getContact", method = RequestMethod.GET)
	public String getContact(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session){
		int no = Integer.parseInt(request.getParameter("no"));
		ContactsDTO dto = contactsDAO.getContact(no);
		//String upPath = session.getServletContext().getRealPath("/resources/contacts/upload");
		model.addAttribute("dto", dto);
		return "contacts/getContact";
	}
	@RequestMapping(value="/editContact", method = RequestMethod.GET)
	public String editContact(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session){
		int no = Integer.parseInt(request.getParameter("no"));
		ContactsDTO dto = contactsDAO.getContact(no);
		String upPath = session.getServletContext().getRealPath("/resources/contacts/upload");
		model.addAttribute("dto", dto);
		return "contacts/editContact";
	}
	@RequestMapping(value="/editContact", method = RequestMethod.POST)
	public String editContactPro(ContactsDTO dto, HttpServletRequest request, HttpServletResponse response, HttpSession session){
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		//파일받기
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
			MultipartFile mf = mr.getFile("photo");
			String filename = mf.getOriginalFilename();
					
			//파일 경로 지정하기
			String upPath = session.getServletContext().getRealPath("/resources/contacts/upload");
			System.out.println(upPath);		
			//서버에 파일 쓰기
			if(!filename.isEmpty()){
				File file = new File(upPath, filename);
				try {
					mf.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				filename=request.getParameter("photo2");
			}
			dto.setPhoto(filename);	
		int res = contactsDAO.editContact(dto);
		return "redirect:listContacts";
	}
	
	@RequestMapping(value="/deleteContact", method = RequestMethod.GET)
	public String deleteContact(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		int no = Integer.parseInt(request.getParameter("no"));
		int res = contactsDAO.deleteContact(no);
		/*if (res>0){
			String upPath = session.getServletContext().getRealPath("/resources/contacts/upload");
			File file = new File(upPath, filename);
			file.delete();
		}*/
		return "redirect:listContacts";
	}
	
}
