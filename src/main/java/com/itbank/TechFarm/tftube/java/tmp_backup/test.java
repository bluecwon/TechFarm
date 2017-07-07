package com.itbank.TechFarm.tftube.java.tmp_backup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		//멀티 쓰레드  
		Calendar cal = Calendar.getInstance();
		System.out.println("현재 시간은 " + cal.get(Calendar.HOUR) + "시 " + cal.get(Calendar.MINUTE) + "분 입니다.");
		  
		cal.set(Calendar.HOUR , cal.get(Calendar.HOUR) + 1);
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 25);
		
		
		  
		System.out.println("1시간 25분 이후 시간은  " + cal.get(Calendar.HOUR) + "시 " + cal.get(Calendar.MINUTE) + "분 입니다.");

		 }
}
