package com.itbank.TechFarm.james;

import java.util.Properties;

import javax.mail.Session;

public class MailJames {
	public static void check(String host, String storeType, String user, String password){
		try{
			Properties properties = new Properties();
			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", 143);
			Session emailSession = Session.getDefaultInstance(properties);
		}catch()
	}
}
