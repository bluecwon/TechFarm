package com.itbank.TechFarm.tftube.java;

import java.io.File;

public class FilePath {
	
	public void filepath(){
		File dir = new File(this.getClass().getResource("").getPath());	
		File video_dir2 = new File(dir,"uploadVideo");	
		File image_dir2 = new File(dir,"uploadImage");
		video_dir2.mkdir();
		System.out.println("비디오2"+video_dir2);
		
	}
	
	
	
	
	
}
