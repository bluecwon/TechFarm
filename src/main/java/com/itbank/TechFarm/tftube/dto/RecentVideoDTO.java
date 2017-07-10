package com.itbank.TechFarm.tftube.dto;

public class RecentVideoDTO {
	private int no;
	private int member_no;
	private String video_name;
	private String ip; //when not login
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}		
	
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
