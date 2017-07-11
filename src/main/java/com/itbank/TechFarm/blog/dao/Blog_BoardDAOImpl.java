package com.itbank.TechFarm.blog.dao;

import java.util.List;

import com.itbank.TechFarm.blog.dto.Blog_MakeBoardDTO;
import com.itbank.TechFarm.blog.mybatis.BlogMapper;

public class Blog_BoardDAOImpl implements Blog_BoardDAO {

	@Override
	public int makeBoard(Blog_MakeBoardDTO dto) {
		// TODO Auto-generated method stub
		return BlogMapper.makeBoard(dto);
	}

	@Override
	public List listBoardTitle(String id) {
		// TODO Auto-generated method stub
		return BlogMapper.listBoardTitle(id);
	}

}
