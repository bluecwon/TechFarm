package com.itbank.TechFarm.james;

import javax.mail.Message;

public class JamesDAOImpl implements JamesDAO{

	@Override
	public Message[] listJames(String host, String storeType, String user, String password) {
		MailJames mailJames = new MailJames();
		return mailJames.check(host, storeType, user, password);
	}

	@Override
	public void getJames() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendJames() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteJames() {
		// TODO Auto-generated method stub
		
	}

}
