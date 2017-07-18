package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.SubedDTO;

public interface SubedDAO {

	public int insertSubed(SubedDTO sddto);
	public List<SubedDTO> get_subed_member(int member_no);
	public int deleteSubed(int subbed_member_no);
}
