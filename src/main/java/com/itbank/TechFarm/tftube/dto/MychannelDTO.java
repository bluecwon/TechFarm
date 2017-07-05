package com.itbank.TechFarm.tftube.dto;

public class MychannelDTO {
	
	private int member_no;
	private String nickname;
	
	private String subing_channel;//배열 형태
	private String subed_channel;	
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getChannel_name() {
		return channel_name;
	}
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
	public String getSubing_channel() {
		return subing_channel;
	}
	public void setSubing_channel(String subing_channel) {
		this.subing_channel = subing_channel;
	}
	public String getSubed_channel() {
		return subed_channel;
	}
	public void setSubed_channel(String subed_channel) {
		this.subed_channel = subed_channel;
	}
	
	

}
