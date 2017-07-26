package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.login.member.MemberDTO;
import com.itbank.TechFarm.tftube.dto.MyChannelDTO;

public interface MyChannelDAO {
	public int createChannel(MyChannelDTO dto);	
	public MyChannelDTO getChannel(int member_no);
	
	
}
