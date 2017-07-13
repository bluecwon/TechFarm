package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.VideoDTO;

public interface VideoDAO {
	
	public int insertVideo(VideoDTO dto);
	public List<VideoDTO> listVideo();
	public VideoDTO getVideo(int no);
	public int deleteVideo(int no);
	public int hitUp(int no);
	public int click_like(int like_status);
	public int cancel_like(int like_status);
	public int click_unlike(int unlike_status);
	public int cancel_unlike(int unlike_status);
}
