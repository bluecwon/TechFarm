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

	@Override
	public List<ReplyDTO> replyList_by_video(String video_name) {
		return ReplyMapper.replyList_by_video(video_name);
	}

	@Override
	public String getName() {
		return ReplyMapper.getName();
	}

	
	
	
	
	
	
	

	
	
	
	
	
	
}















