package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.VideoDTO;





public interface VideoDAO {
	
	public int insertVideo(VideoDTO dto);
	public List<VideoDTO> listVideo();
	public VideoDTO getVideo(int no);
	public int deleteVideo(int no);

}
