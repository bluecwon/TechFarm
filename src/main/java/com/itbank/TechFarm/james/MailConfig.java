package com.itbank.TechFarm.james;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailConfig {
	public static JavaMailSender mailSender(String username, String password){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("52.79.140.54");
		mailSender.setDefaultEncoding("utf-8");
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		return mailSender;
	}
}
