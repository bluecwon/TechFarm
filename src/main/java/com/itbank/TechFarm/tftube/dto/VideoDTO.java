package com.itbank.TechFarm.tftube.dto;

public class VideoDTO {
	private int ind;
	private String id;
	private String title;
	private String description;
	private String open;
	private String filename;
	private int filesize;
	private int readcount;
	private String image;
	private int likep;//default 0
	private int unlikep; //default 0
	private String uploaddate;//sysdate
	
	
	public int getInd() {
		return ind;
	}
	public void setInd(int ind) {
		this.ind = ind;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
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
	
	
	


}
