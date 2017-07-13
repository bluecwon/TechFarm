package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.ReplyDTO;





public interface ReplyDAO {
	public List<ReplyDTO> replyList();		
	public int insertReply(ReplyDTO dto);
	public List<ReplyDTO> replyList_by_video(String video_name);
	public String getName();
	public int update_re_step();
	public int update_re_step_reply(int re_step);
	public int delete_reply(int no);
	public String getName_by_video(String video_name);
	
	

	
}
