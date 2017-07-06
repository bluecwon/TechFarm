package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.ReplyDTO;





public interface ReplyDAO {
	public List replyList();		
	public int insertReply(ReplyDTO dto);
	public List<ReplyDTO> replyList_by_video(String video_name);

	
}
