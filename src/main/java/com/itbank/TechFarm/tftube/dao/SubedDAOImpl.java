package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.SubedDTO;
import com.itbank.TechFarm.tftube.mybatis.SubedMapper;

public class SubedDAOImpl implements SubedDAO{

	@Override
	public int insertSubed(SubedDTO sddto) {
		return SubedMapper.insertSubed(sddto);
	}

	@Override
	public List<SubedDTO> get_subed_member(int member_no) {
		return SubedMapper.get_subed_member(member_no);
	}

	@Override
	public int deleteSubed(int subbed_member_no) {
		return SubedMapper.deleteSubed(subbed_member_no);
	}
	
	

}
