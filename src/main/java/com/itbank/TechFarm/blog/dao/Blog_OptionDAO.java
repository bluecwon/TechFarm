package com.itbank.TechFarm.blog.dao;

import java.util.List;

import com.itbank.TechFarm.blog.dto.Blog_OptionDTO;

public interface Blog_OptionDAO {
	public int makeBlog(Blog_OptionDTO dto);
	public Blog_OptionDTO getBlog(String id);
	public int deleteBlog(String id);
	public int editBlog_pf_int(Blog_OptionDTO dto);
	public int editBlog_layout(Blog_OptionDTO dto);
	public int editBlog_skin(Blog_OptionDTO dto);
	public int editBlog_headerword(Blog_OptionDTO dto);
	public List listNewBoard();
	public List listNewProfile();
	public List listHotBoard();
	public List listHotProfile();
	public List listHotBlog();
	public List listAreaBoard(int area);
	public List listAreaProfile(int area);
}
