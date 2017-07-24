package com.itbank.TechFarm.tftube.java;

import java.util.HashMap;

public class test_hash {
	
	public static void main(String[] args) {
		HashMap<String,String> map=new HashMap();
		map.put("하하", "게이득");
		System.out.println(map.get("하하"));
		map.put("하하", "좋냐?");
		System.out.println(map.get("하하"));
		
		String original_video_name="헤헤헤얼굴도못생긴게.mp4";
		
		System.out.println(original_video_name.substring(original_video_name.length()-4,original_video_name.length()));
	}
}
