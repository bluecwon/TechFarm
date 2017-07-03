package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.VideoDTO;
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
	public VideoDTO getVideo(int ind) {
		return VideoMapper.getVideo(ind);
	}
	
}
