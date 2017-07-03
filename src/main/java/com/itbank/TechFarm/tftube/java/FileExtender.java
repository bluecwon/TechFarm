package com.itbank.TechFarm.tftube.java;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileExtender extends File{
	
	public FileExtender(File arg0, String arg1) {
		super(arg0, arg1);
		
	}


	/*public static FileExtender(String file, String string) {
		super(file, string);
		// TODO Auto-generated constructor stub
	}*/

	public static String encryptData(String file) {
		  
		  StringBuilder sb = new StringBuilder();
		  
		  try{
		   
		   MessageDigest md5 = MessageDigest.getInstance("MD5");
		   
		   md5.update(file.getBytes());
		   byte[] md5encrypt = md5.digest(); 
		   
		   
		   for(int i = 0 ; i < md5encrypt.length ; i++){
		    
		    sb.append(Integer.toHexString((int)md5encrypt[i] & 0xFF));
		    
		   }
		   
		  } catch (Exception e) {
		   
		   e.printStackTrace();
		   
		  }
		      
		  return sb.toString();
		  
		 }
	

public static String md5(File file) throws IOException, NoSuchAlgorithmException { 


     BufferedInputStream bis = null; 

     try { 
         bis = new BufferedInputStream(new FileInputStream(file)); 
         MessageDigest md = MessageDigest.getInstance("MD5"); 
         int read = -1; 
         byte[] buffer = new byte[1024]; 
         while ((read = bis.read(buffer)) != -1) { 
             md.update(buffer, 0, read); 
             
         } 
         return String.valueOf(md.digest()); 


     } finally { 
        if (bis != null) try { bis.close(); } catch(IOException e) {e.printStackTrace();} 


     } //end of finally


 } 




}
