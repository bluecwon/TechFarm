package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.VideoDTO;
import com.itbank.TechFarm.tftube.mybatis.ReplyMapper;
import com.itbank.TechFarm.tftube.mybatis.VideoMapper;




public class VideoDAOImpl implements VideoDAO {
	@Override
	public int insertVideo(VideoDTO dto) {		
		return VideoMapper.insertVideo(dto);
	}
	

	@Override
	public List<VideoDTO> listVideo() {			
		return VideoMapper.listVideo();
	}


	@Override
	public VideoDTO getVideo(int no) {
		return VideoMapper.getVideo(no);
	}


	@Override
	public int deleteVideo(int no) {
		return VideoMapper.deleteVideo(no);
	}
	
	
	@Override
	public int hitUp(int no) {
		return VideoMapper.hitUp(no);
	}
	
}
