package com.itbank.TechFarm.james;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class JamesDAOImpl implements JamesDAO{
	//@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private JamesPro jamesPro;
	@Autowired
	private MailConfig mailConfig;
	@Autowired
	private JamesContent jamesContent;
	@Value("${host}")
	private String host;
	
	String mailStoreType ="imap";
	
	private JamesDTO jamesDTO;
	private List<JamesDTO> listJames; 
	
	@Override
	public int sendJames(final JamesDTO dto) {
		mailSender=mailConfig.mailSender(dto.getId()+"@"+host, dto.getPassword());
		try{
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom(dto.getId()+"@"+host);
			messageHelper.setTo(dto.getTo());
			messageHelper.setSubject(dto.getSubject());
			messageHelper.setText(dto.getText());
			
			//첨부파일 보내기 
			String attachName = dto.getSendFile().getOriginalFilename();
			if (!dto.getSendFile().equals("")) {
				 
                messageHelper.addAttachment(attachName, new InputStreamSource() {
                     
                    @Override
                    public InputStream getInputStream() throws IOException {
                        return dto.getSendFile().getInputStream();
                    }
                });
            }
			
			mailSender.send(message);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
		
	}
	
	@Override
	public List<JamesDTO> listJames(JamesDTO dto, PageMaker pageMaker) {
		listJames = new ArrayList<JamesDTO>();

		try{
			Properties properties = new Properties();
			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", 143);
			Session emailSession = Session.getDefaultInstance(properties);
			
			Store store = emailSession.getStore("imap");
			store.connect(host, dto.getId()+"@"+host, dto.getPassword());
			
			Folder emailFolder = store.getFolder(dto.getFolder());
			emailFolder.open(Folder.READ_ONLY);
			
			Message[] messages = emailFolder.getMessages();
			
			int pageSize=10;
			int end = pageMaker.getCount()-(pageMaker.getPage()-1)*pageSize-1;
			int start = end-pageSize+1;
			if(start<0) start = 0; 
			
			for (int i = end, n = start; i >= n; i--) {
				Message message = messages[i];
		        jamesDTO = jamesPro.writeEnvelope(message);
		        jamesDTO.setNum(i);
	            listJames.add(jamesDTO);
		    }
			
		    emailFolder.close(false);
		    store.close();
		    return listJames;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void deleteJames(JamesDTO dto) {
		try{
			Properties properties = new Properties();
			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", 143);
			Session emailSession = Session.getDefaultInstance(properties);
			
			Store store = emailSession.getStore("imap");
			store.connect(host, dto.getId()+"@"+host, dto.getPassword());
			
			Folder emailFolder = store.getFolder(dto.getFolder());
			emailFolder.open(Folder.READ_WRITE);
			
			Message[] messages = emailFolder.getMessages();

			Message message = messages[dto.getNum()];
			message.setFlag(Flags.Flag.DELETED, true);
			
		    emailFolder.close(false);
		    store.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public JamesDTO getJames(JamesDTO dto) {
		try{
			Properties properties = new Properties();
			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", 143);
			Session emailSession = Session.getDefaultInstance(properties);
			
			Store store = emailSession.getStore("imap");
			store.connect(host, dto.getId()+"@"+host, dto.getPassword());
			
			Folder emailFolder = store.getFolder(dto.getFolder());
			emailFolder.open(Folder.READ_ONLY);
			
			Message[] messages = emailFolder.getMessages();

			Message message = messages[dto.getNum()];
            /*
			if(message.isMimeType("multipart/*")){
            	Multipart mp = (Multipart) message.getContent();
      	        int count = mp.getCount();
      	        for (int i = 0; i < count; i++){
      	           System.out.println(mp.getBodyPart(i).getContentType());
      	           if(mp.getBodyPart(i).isMimeType("text/html")){
      	        	 jamesDTO.setContent(String.valueOf((mp.getBodyPart(i).getContent())));
      	           }
      	        	if (mp.getContentType().contains("image/")) {
      	  	        System.out.println("content type" + mp.getContentType());
      	  	        File f = new File("image" + new Date().getTime() + ".jpg");
      	  	        DataOutputStream output = new DataOutputStream(
      	  	            new BufferedOutputStream(new FileOutputStream(f)));
      	  	            com.sun.mail.util.BASE64DecoderStream test = 
      	  	                 (com.sun.mail.util.BASE64DecoderStream) mp.getBodyPart(i).getContent();
      	  	         byte[] buffer = new byte[1024];
      	  	         int bytesRead;
      	  	         while ((bytesRead = test.read(buffer)) != -1) {
      	  	            output.write(buffer, 0, bytesRead);
      	  	         }
      	  	         output.close();
      	  	      }
      	        }
            }
			*/
			jamesDTO = jamesContent.writePart(message);
            
		    emailFolder.close(false);
		    store.close();
		    return jamesDTO;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int getCountJames(JamesDTO dto) {
		try{
			Properties properties = new Properties();
			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", 143);
			Session emailSession = Session.getDefaultInstance(properties);
			
			Store store = emailSession.getStore("imap");
			store.connect(host, dto.getId()+"@"+host, dto.getPassword());
			
			Folder emailFolder = store.getFolder(dto.getFolder());
			emailFolder.open(Folder.READ_ONLY);
			
			Message[] messages = emailFolder.getMessages();
			return messages.length;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

}
