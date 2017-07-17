package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.SubingDTO;
import com.itbank.TechFarm.tftube.mybatis.SubingMapper;

public class SubingDAOImpl implements SubingDAO{

	@Override
	public int insertSubing(SubingDTO sidto) {
		return SubingMapper.insertSubing(sidto);
	}

	@Override
	public int get_subing_member(int member_no) {
		return SubingMapper.get_subing_member(member_no);
	}

	@Override
	public List<SubingDTO> get_subing(int member_no) {
		
		return SubingMapper.get_subing(member_no);		
	}
	
	
	
	
	
}