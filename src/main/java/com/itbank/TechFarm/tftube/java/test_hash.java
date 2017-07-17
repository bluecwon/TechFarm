package com.itbank.TechFarm.tftube.java;

import java.util.HashMap;

public class test_hash {
	
	public static void main(String[] args) {
		HashMap<String,String> map=new HashMap();
		map.put("하하", "게이득");
		System.out.println(map.get("하하"));
		map.put("하하", "좋냐?");
		System.out.println(map.get("하하"));
		
	}
}
