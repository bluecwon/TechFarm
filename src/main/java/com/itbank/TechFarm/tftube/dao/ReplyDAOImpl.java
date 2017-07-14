package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.ReplyDTO;
import com.itbank.TechFarm.tftube.dto.ReplyFormat;
import com.itbank.TechFarm.tftube.mybatis.ReplyMapper;

public class ReplyDAOImpl implements ReplyDAO {	
	
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

	@Override
	public int update_re_step() {		
		return ReplyMapper.update_re_step();
	}

	@Override
	public int update_re_step_reply(int re_step) {
		return ReplyMapper.update_re_step_reply();
	}

	@Override
	public int delete_reply(int no) {
		return ReplyMapper.delete_reply(no);
	}

	
	@Override

	public List<ReplyFormat> getName_by_video(String video_name) {
		return ReplyMapper.getName_by_video(video_name);
	}

	@Override
	public int reply_number(String video_name) {
		return ReplyMapper.reply_number(video_name);
	}
	
	

	
	
	
	

	
	
	
	
	
	
	

	
	
	
	
	
	
}















