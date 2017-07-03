package com.itbank.TechFarm.login.member;

public class MemberDAOImpl implements MemberDAO{
	@Override
	public int insertMember(MemberDTO dto) {
		int res=MemberMapper.insertMember(dto);
		return res;
	}

	@Override
	public MemberDTO getLogin(String id) {
		MemberDTO dto=new MemberDTO();
		dto=MemberMapper.getLogin(id);
		return dto;
	}

	@Override
	public MemberDTO getMember(String id) {
		MemberDTO dto=new MemberDTO();
		dto=MemberMapper.getMember(id);
		return dto;
	}
}
