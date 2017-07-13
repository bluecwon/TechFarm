package com.itbank.TechFarm.james;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

public class MailJames {
	public Message[] check(String host, String storeType, String user, String password){
		try{
			Properties properties = new Properties();
			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", 143);
			Session emailSession = Session.getDefaultInstance(properties);
			
			Store store = emailSession.getStore("imap");
			store.connect(host, user+"@"+host, password);
			
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			for (int i = 0, n = messages.length; i < n; i++) {
				Message message = messages[i];
		        System.out.println("---------------------------------");
	            writePart(message);
		        /*
	            System.out.println("Email Number " + (i + 1));
		        System.out.println("Subject: " + message.getSubject());
		        System.out.println("From: " + message.getFrom()[0]);
		        System.out.println("Text: " + message.getContent().toString());
		        System.out.println("Text: " + message.getContent());
		        */
		    }
		    emailFolder.close(false);
		    store.close();
		    return messages;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static void writePart(Part part) throws Exception {
	      if (part instanceof Message)
	         //Call methos writeEnvelope
	      writeEnvelope((Message) part);

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
	         for (int i = 0; i < count; i++)
	            writePart(mp.getBodyPart(i));
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
	         FileOutputStream f2 = new FileOutputStream("/tmp/image.jpg");
	         f2.write(bArray);
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
	      }

	   }
	   /*
	   * This method would print FROM,TO and SUBJECT of the message
	   */
	   public static void writeEnvelope(Message message) throws Exception {
	      System.out.println("This is the message envelope");
	      System.out.println("---------------------------");
	      Address[] address;

	      // FROM
	      if ((address = message.getFrom()) != null) {
	         for (int j = 0; j < address.length; j++)
	         System.out.println("FROM: " + address[j].toString());
	      }

	      // TO
	      if ((address = message.getRecipients(Message.RecipientType.TO)) != null) {
	         for (int j = 0; j < address.length; j++)
	         System.out.println("TO: " + address[j].toString());
	      }

	      // SUBJECT
	      if (message.getSubject() != null)
	         System.out.println("SUBJECT: " + message.getSubject());
	      
	      // SentDate
	      if (message.getSentDate() != null)
	    	  System.out.println("SentDate: " + message.getSentDate());
	   }
}








