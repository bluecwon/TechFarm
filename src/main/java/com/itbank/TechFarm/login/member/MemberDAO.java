package com.itbank.TechFarm.login.member;

public interface MemberDAO {
	public int insertMember(MemberDTO dto);
	public MemberDTO getLogin(String id);
	public MemberDTO getMember(String id);
}
