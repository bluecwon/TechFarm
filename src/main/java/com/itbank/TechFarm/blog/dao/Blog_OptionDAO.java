package com.itbank.TechFarm.blog.dao;

import com.itbank.TechFarm.blog.dto.Blog_OptionDTO;

public interface Blog_OptionDAO {
	public int makeBlog(Blog_OptionDTO dto);
	public Blog_OptionDTO getBlog(String id);
	public int deleteBlog(String id);
	
	
}
