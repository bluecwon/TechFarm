package com.itbank.TechFarm.tftube.dao;

import java.util.HashMap;
import java.util.List;

import com.itbank.TechFarm.tftube.dto.LikeVideoDTO;
import com.itbank.TechFarm.tftube.dto.VideoDTO;

public interface LikeVideoDAO {	
	public int like_insert(LikeVideoDTO dto);
	public int like_delete(int member,int no);
	public int likecount_member(int member_no);
	public LikeVideoDTO likevideo_list(int member_no,int no);
}
