package com.itbank.TechFarm.tftube.dao;

import com.itbank.TechFarm.login.member.MemberDTO;
import com.itbank.TechFarm.tftube.dto.MyChannelDTO;
import com.itbank.TechFarm.tftube.mybatis.MyChannelMapper;

public class MyChannelDAOImpl implements MyChannelDAO{

	@Override
	public int insertChannel(MemberDTO dto) {
		return MyChannelMapper.insertChannel(dto);
	}

	@Override
	public String getChannel(int member_no) {
		return MyChannelMapper.getChannel(member_no);		
	}
	
	

	
}
