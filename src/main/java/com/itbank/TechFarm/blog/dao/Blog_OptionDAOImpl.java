package com.itbank.TechFarm.blog.dao;

import com.itbank.TechFarm.blog.dto.Blog_OptionDTO;
import com.itbank.TechFarm.blog.mybatis.BlogMapper;

public class Blog_OptionDAOImpl implements Blog_OptionDAO {

	@Override
	public Blog_OptionDTO getOption(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int makeBlog(Blog_OptionDTO dto) {
		// TODO Auto-generated method stub
		return BlogMapper.makeBlog(dto);
	}

}
