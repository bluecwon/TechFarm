package com.itbank.TechFarm.contacts;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactsController {
	@RequestMapping(value = "/listContacts", method = RequestMethod.GET)
	public String listContacts(Locale locale, Model model) {
		return "contacts/listContacts";
	}
	
	@RequestMapping(value = "/addContacts", method = RequestMethod.GET)
	public String addContacts(Locale locale, Model model) {
		return "contacts/addContacts";
	}
}
