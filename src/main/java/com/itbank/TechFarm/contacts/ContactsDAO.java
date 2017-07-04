package com.itbank.TechFarm.contacts;

import java.util.List;

public interface ContactsDAO {
	public List<ContactsDTO> listContacts();
	public ContactsDTO getContact();
	public int addContact();
	public int editContact();
	public int deleteContact();
}
