package com.itbank.TechFarm.james;

import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendIdentify {
	private JavaMailSender mailSender;
	@Autowired
	private MailConfig mailConfig;
	
	public int sendId(String name, String id, String email){
		String sender="admin@52.79.140.54";
		String passwd="admin";
		String subject=name+"님, TechFarm ID를 요청한 결과입니다.";
		String text=name+"님이 요청하신 TechFarm ID는 "+id+" 입니다.";
		
		mailSender=mailConfig.mailSender(sender, passwd);
		try{
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom("admin@52.79.140.54");
			messageHelper.setTo(email);
			messageHelper.setSubject(subject);
			messageHelper.setText(text);
			
			mailSender.send(message);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	public int sendPasswd(String name, String id, String email, String tmp_pw){
		String sender="admin@52.79.140.54";
		String passwd="admin";
		String subject=name+"님, TechFarm Password를 요청한 결과입니다.";
		String text=name+"님이 요청하신 TechFarm 임시 비밀번호는 "+tmp_pw+" 입니다."
				+ "\n<<바로 비밀번호를 바꿔주시기 바랍니다.>>";
		
		mailSender=mailConfig.mailSender(sender, passwd);
		try{
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom("admin@52.79.140.54");
			messageHelper.setTo(email);
			messageHelper.setSubject(subject);
			messageHelper.setText(text);
			
			mailSender.send(message);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
}
