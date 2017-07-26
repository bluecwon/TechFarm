package com.itbank.TechFarm.blog.dao;

import java.util.List;

import com.itbank.TechFarm.blog.dto.Blog_OptionDTO;
import com.itbank.TechFarm.blog.mybatis.BlogMapper;

public class Blog_OptionDAOImpl implements Blog_OptionDAO {

	@Override
	public Blog_OptionDTO getBlog(String id) {
		// TODO Auto-generated method stub
		return BlogMapper.getBlog(id);
	}

	@Override
	public int makeBlog(Blog_OptionDTO dto) {
		// TODO Auto-generated method stub
		return BlogMapper.makeBlog(dto);
	}

	@Override
	public int deleteBlog(String id) {
		// TODO Auto-generated method stub
		return BlogMapper.deleteBlog(id);
	}

	@Override
	public int editBlog_pf_int(Blog_OptionDTO dto) {
		// TODO Auto-generated method stub
		return BlogMapper.editBlog_pf_int(dto);
	}

	@Override
	public int editBlog_layout(Blog_OptionDTO dto) {
		// TODO Auto-generated method stub
		return BlogMapper.editBlog_layout(dto);
	}

	@Override
	public int editBlog_skin(Blog_OptionDTO dto) {
		// TODO Auto-generated method stub
		return BlogMapper.editBlog_skin(dto);
	}

	@Override
	public int editBlog_headerword(Blog_OptionDTO dto) {
		// TODO Auto-generated method stub
		return BlogMapper.editBlog_headerword(dto);
	}
	
	@Override
	public List listNewBoard() {
		// TODO Auto-generated method stub
		return BlogMapper.listNewBoard();
	}

	@Override
	public List listHotBoard() {
		// TODO Auto-generated method stub
		return BlogMapper.listHotBoard();
	}

	@Override
	public List listHotProfile() {
		// TODO Auto-generated method stub
		return BlogMapper.listHotProfile();
	}

	@Override
	public List listNewProfile() {
		// TODO Auto-generated method stub
		return BlogMapper.listNewProfile();
	}

	@Override
	public List listHotBlog() {
		// TODO Auto-generated method stub
		return BlogMapper.listHotBlog();
	}

	@Override
	public List listAreaBoard(int area) {
		// TODO Auto-generated method stub
		return BlogMapper.listAreaBoard(area);
	}

	@Override
	public List listAreaProfile(int area) {
		// TODO Auto-generated method stub
		return BlogMapper.listAreaProfile(area);
	}

}
