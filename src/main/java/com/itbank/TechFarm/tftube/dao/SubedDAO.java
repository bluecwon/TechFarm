package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.SubedDTO;

public interface SubedDAO {

	public int insertSubed(SubedDTO sddto);
	public List<SubedDTO> get_subed(int member_no);
}
