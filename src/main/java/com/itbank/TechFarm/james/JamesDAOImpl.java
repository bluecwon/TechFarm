package com.itbank.TechFarm.james;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class JamesDAOImpl implements JamesDAO{
	//@Autowired
	private JavaMailSender mailSender;
	String host="52.79.140.54";
	String mailStoreType ="imap";
	
	@Override
	public List<JamesDTO> listJames(String user, String password) {
		List<JamesDTO> listJames = new ArrayList<JamesDTO>();
		
		return listJames;
	}

	@Override
	public void getJames() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int sendJames(JamesDTO dto) {
		mailSender=MailConfig.mailSender(dto.getId()+"@"+host, dto.getPassword());
		try{
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom(dto.getId()+"@"+host);
			messageHelper.setTo(dto.getTo());
			messageHelper.setSubject(dto.getSubject());
			messageHelper.setText(dto.getText());
			
			mailSender.send(message);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
		
	}

	@Override
	public void deleteJames() {
		// TODO Auto-generated method stub
		
	}

}
