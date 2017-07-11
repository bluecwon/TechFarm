package com.itbank.TechFarm.blog.dao;

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

}
