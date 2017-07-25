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
	public List<JamesDTO> listJames(JamesDTO dto) {
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
			System.out.println("messages.length---" + messages.length);
			
			for (int i = messages.length-1, n = 0; i >= n; i--) {
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
            jamesDTO = writePart(message);
			
		    emailFolder.close(false);
		    store.close();
		    return jamesDTO;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public JamesDTO writePart(Part part) throws Exception {
	    	  
	      System.out.println("----------------------------");
	      System.out.println("CONTENT-TYPE: " + part.getContentType());

	      //check if the content is plain text
	      if (part.isMimeType("text/plain")) {
	         System.out.println("This is plain text");
	         System.out.println("---------------------------");
	         System.out.println((String) part.getContent());
	      } 
	      //check if the content has attachment
	      else if (part.isMimeType("multipart/*")) {
	         System.out.println("This is a Multipart");
	         System.out.println("---------------------------");
	         Multipart mp = (Multipart) part.getContent();
	         int count = mp.getCount();
	         for (int i = 0; i < count; i++){
	            jamesDTO = writePart(mp.getBodyPart(i));
	         }
	         return jamesDTO;
	      } 
	      //check if the content is a nested message
	      else if (part.isMimeType("message/rfc822")) {
	         System.out.println("This is a Nested Message");
	         System.out.println("---------------------------");
	         writePart((Part) part.getContent());
	      } 
	      //check if the content is an inline image
	      else if (part.isMimeType("image/jpeg")) {
	         System.out.println("--------> image/jpeg");
	         Object object = part.getContent();

	         InputStream x = (InputStream) object;
	         // Construct the required byte array
	         System.out.println("x.length = " + x.available());
	         int i = 0;
	         byte[] bArray = new byte[x.available()];
	         while ((i = (int) ((InputStream) x).available()) > 0) {
	            int result = (int) (((InputStream) x).read(bArray));
	            if (result == -1)
	            	break;
	         }
	         x.close();
	         FileOutputStream f2 = new FileOutputStream("/tmp/image.jpg");
	         f2.write(bArray);
	         f2.close();
	      } 
	      else if (part.getContentType().contains("image/")) {
	         System.out.println("content type" + part.getContentType());
	         File f = new File("image" + new Date().getTime() + ".jpg");
	         DataOutputStream output = new DataOutputStream(
	            new BufferedOutputStream(new FileOutputStream(f)));
	            com.sun.mail.util.BASE64DecoderStream test = 
	                 (com.sun.mail.util.BASE64DecoderStream) part.getContent();
	         byte[] buffer = new byte[1024];
	         int bytesRead;
	         while ((bytesRead = test.read(buffer)) != -1) {
	            output.write(buffer, 0, bytesRead);
	         }
	         output.close();
	      } 
	      else {
	         Object object = part.getContent();
	         if (object instanceof String) {
	            System.out.println("This is a string");
	            System.out.println("---------------------------");
	            System.out.println((String) object);
	         } 
	         else if (object instanceof InputStream) {
	            System.out.println("This is just an input stream");
	            System.out.println("---------------------------");
	            InputStream is = (InputStream) object;
	            is = (InputStream) object;
	            int c;
	            while ((c = is.read()) != -1)
	               System.out.write(c);
	         } 
	         else {
	            System.out.println("This is an unknown type");
	            System.out.println("---------------------------");
	            System.out.println(object.toString());
	         }
	         jamesDTO.setContent((String)object);
	         return jamesDTO;
	      }
	      jamesDTO.setContent(part.getContent().toString());
	      return jamesDTO;

	   }

}
