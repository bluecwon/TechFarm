package com.itbank.TechFarm.tfPlusDTO;

public class NewsProfileAddCommentDTO {
	private int profileAddPK;
	private int profileBoardFK;
	private String profileAddName;
	private String profileAddContents;
	private String profileAddDate;
	private String profileAddId;
	private int profileAddGood;
	
	public int getProfileAddPK() {
		return profileAddPK;
	}
	public void setProfileAddPK(int profileAddPK) {
		this.profileAddPK = profileAddPK;
	}
	public int getProfileBoardFK() {
		return profileBoardFK;
	}
	public void setProfileBoardFK(int profileBoardFK) {
		this.profileBoardFK = profileBoardFK;
	}
	public String getProfileAddName() {
		return profileAddName;
	}
	public void setProfileAddName(String profileAddName) {
		this.profileAddName = profileAddName;
	}
	public String getProfileAddContents() {
		return profileAddContents;
	}
	public void setProfileAddContents(String profileAddContents) {
		this.profileAddContents = profileAddContents;
	}
	public String getProfileAddDate() {
		return profileAddDate;
	}
	public void setProfileAddDate(String profileAddDate) {
		this.profileAddDate = profileAddDate;
	}
	public String getProfileAddId() {
		return profileAddId;
	}
	public void setProfileAddId(String profileAddId) {
		this.profileAddId = profileAddId;
	}
	public int getProfileAddGood() {
		return profileAddGood;
	}
	public void setProfileAddGood(int profileAddGood) {
		this.profileAddGood = profileAddGood;
	}
	
	
}
