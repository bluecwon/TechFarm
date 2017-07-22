package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.dto.LikeVideoDTO;
import com.itbank.TechFarm.tftube.dto.VideoDTO;
import com.itbank.TechFarm.tftube.dto.Video_RecentVideoDTO;
import com.itbank.TechFarm.tftube.mybatis.LikeVideoMapper;
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


	/*@Override
	public int click_like(int no) {
		return VideoMapper.click_like(no);
	}


	@Override
	public int cancel_like(int no) {
		return VideoMapper.cancel_like(no);
	}


	@Override
	public int click_unlike(int no) {
		return VideoMapper.click_unlike(no);
	}


	@Override

	public int cancel_unlike(int no) {
		return VideoMapper.cancel_unlike(no);
	}
*/

	@Override
	public List<Video_RecentVideoDTO> listRecent_inf(int member_no) {
		return VideoMapper.listRecent_inf(member_no);
	}


	@Override
	public List<VideoDTO> listVideo_member_no(int member_no) {
		return VideoMapper.listVideo_member_no(member_no);
	}
	
	@Override
	public List<VideoDTO> listLike(int member_no) {
		return VideoMapper.listLike(member_no);
		
	}

	@Override
	public int updateLike(VideoDTO dto) {
		return VideoMapper.updateLike(dto);
	}

	

	
	
	
	
	
	
	
	
	

}
