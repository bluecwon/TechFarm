package com.itbank.TechFarm.tftube.dto;

public class Video_RecentVideoDTO {
	private int no;
	private int member_no;	
	private String title;
	private String description;
	private String open;
	private String video_name;//tmp save
	private int video_size;//tmp save
	private int readcount;
	private String image;
	private int likep;//default 0
	private int unlikep; //default 0	
	private String uploaddate;//sysdate
	private String video_hash;
	private String image_hash;
	private int like_status;
	private int unlike_status;	
	private String channel;	
	private int recent_no;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}
	public int getVideo_size() {
		return video_size;
	}
	public void setVideo_size(int video_size) {
		this.video_size = video_size;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getLikep() {
		return likep;
	}
	public void setLikep(int likep) {
		this.likep = likep;
	}
	public int getUnlikep() {
		return unlikep;
	}
	public void setUnlikep(int unlikep) {
		this.unlikep = unlikep;
	}
	public String getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}
	public String getVideo_hash() {
		return video_hash;
	}
	public void setVideo_hash(String video_hash) {
		this.video_hash = video_hash;
	}
	public String getImage_hash() {
		return image_hash;
	}
	public void setImage_hash(String image_hash) {
		this.image_hash = image_hash;
	}
	public int getLike_status() {
		return like_status;
	}
	public void setLike_status(int like_status) {
		this.like_status = like_status;
	}
	public int getUnlike_status() {
		return unlike_status;
	}
	public void setUnlike_status(int unlike_status) {
		this.unlike_status = unlike_status;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public int getRecent_no() {
		return recent_no;
	}
	public void setRecent_no(int recent_no) {
		this.recent_no = recent_no;
	}
	
	
}
