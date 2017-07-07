package com.itbank.TechFarm.login.member;

public class MemberDTO {
	private int no;
	private String id;
	private String passwd;
	private String name;
	private String email;
	private int birthday_year;
	private int birthday_month;
	private int birthday_day;
	private int sex;
	private String joindate;	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthday_year() {
		return birthday_year;
	}
	public void setBirthday_year(int birthday_year) {
		this.birthday_year = birthday_year;
	}
	public int getBirthday_month() {
		return birthday_month;
	}
	public void setBirthday_month(int birthday_month) {
		this.birthday_month = birthday_month;
	}
	public int getBirthday_day() {
		return birthday_day;
	}
	public void setBirthday_day(int birthday_day) {
		this.birthday_day = birthday_day;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
}
