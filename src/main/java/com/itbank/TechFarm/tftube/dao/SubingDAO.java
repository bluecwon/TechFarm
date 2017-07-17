package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.SubingDTO;

public interface SubingDAO {
	
	public int insertSubing(SubingDTO sidto);
	public List<SubingDTO> get_subing_member(int member_no);
	public int deleteSubing(int subing_member_no);
	
	
}
