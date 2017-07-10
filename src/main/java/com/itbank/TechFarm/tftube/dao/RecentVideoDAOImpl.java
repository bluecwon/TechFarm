package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.RecentVideoDTO;
import com.itbank.TechFarm.tftube.mybatis.RecentVideoMapper;

public class RecentVideoDAOImpl implements RecentVideoDAO{

	@Override
	public int insertRecent(RecentVideoDTO dto) {
		return RecentVideoMapper.insertRecent(dto);
	}	

	@Override
	public List<RecentVideoDTO> listRecent_member_no(int member_no) {
		return RecentVideoMapper.listRecent_member_no(member_no);
	}

	@Override
	public List<RecentVideoDTO> listRecent_ip(String ip) {
		return RecentVideoMapper.listRecent_ip(ip);
	}	

}
