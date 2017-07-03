package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.ReplyDTO;
import com.itbank.TechFarm.tftube.mybatis.ReplyMapper;





public class ReplyDAOImpl implements ReplyDAO {
	@Override
	public List replyList() {
		return ReplyMapper.listReply();
	}
	
	@Override
	public int insertReply(ReplyDTO dto) {
		return ReplyMapper.insertReply(dto);
	}

	
	
	
	
	
	
}















