package com.itbank.TechFarm.tftube.dao;

import com.itbank.TechFarm.login.member.MemberDTO;
import com.itbank.TechFarm.tftube.dto.MyChannelDTO;

public interface MyChannelDAO {
	
	public int insertChannel(MemberDTO dto);
	public String getChannel(int member_no);

}
