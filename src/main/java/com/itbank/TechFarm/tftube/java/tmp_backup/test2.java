package com.itbank.TechFarm.tftube.java.tmp_backup;

import java.util.Date;

public class test2 {
	
public static void main(String[] args) {
	Date today=new Date();
	
	System.out.println(today);
	Long unit=(long)(3600*24*365);
	System.out.println(today.getTime()/1000/unit);
	
}

}
