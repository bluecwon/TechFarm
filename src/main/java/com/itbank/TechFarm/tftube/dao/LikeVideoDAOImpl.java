package com.itbank.TechFarm.tftube.dao;

import java.util.HashMap;
import java.util.List;


import com.itbank.TechFarm.tftube.dto.LikeVideoDTO;
import com.itbank.TechFarm.tftube.dto.VideoDTO;
import com.itbank.TechFarm.tftube.mybatis.LikeVideoMapper;

public class LikeVideoDAOImpl implements LikeVideoDAO{

	

	@Override
	public int like_insert(LikeVideoDTO dto) {
		return LikeVideoMapper.like_insert(dto);
	}

	@Override
	public int like_delete(int member,int no) {
		return LikeVideoMapper.like_delete(member,no);
	}

	@Override
	public int likecount_member(int member_no) {
		return LikeVideoMapper.likecount_member(member_no);
	}

	@Override
	public LikeVideoDTO likevideo_list(int member_no, int no) {
		return LikeVideoMapper.likevideo_list(member_no, no);
	}

	
	
	
	
	
	
	
	

	
	

	
	
}
