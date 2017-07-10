package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.RecentVideoDTO;

public interface RecentVideoDAO {
	
	public int insertRecent(RecentVideoDTO dto);
	
	public List<RecentVideoDTO> listRecent_member_no(int member_no);
	
	public List<RecentVideoDTO> listRecent_ip(String ip);

}
