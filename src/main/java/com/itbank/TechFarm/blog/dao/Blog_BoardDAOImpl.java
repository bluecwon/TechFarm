package com.itbank.TechFarm.blog.dao;

import java.util.List;

import com.itbank.TechFarm.blog.dto.Blog_BoardDTO;
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

	@Override
	public Blog_MakeBoardDTO getBoardTitle(int boardno) {
		// TODO Auto-generated method stub
		return BlogMapper.getBoardT(boardno);
	}

	@Override
	public int editBoardTitle(Blog_MakeBoardDTO dto) {
		// TODO Auto-generated method stub
		return BlogMapper.editBoardT(dto);
	}

	@Override
	public int insertboard(Blog_BoardDTO dto) {
		// TODO Auto-generated method stub
		return BlogMapper.insertBoard(dto);
	}

	@Override
	public List listBoard(int boardno) {
		// TODO Auto-generated method stub
		return BlogMapper.listBoard(boardno);
	}

	@Override
	public Blog_BoardDTO getBoard(int no) {
		// TODO Auto-generated method stub
		return BlogMapper.getBoard(no);
	}

	@Override
	public int updateBoard(Blog_BoardDTO dto) {
		// TODO Auto-generated method stub
		return BlogMapper.updateBoard(dto);
	}

	@Override
	public int deleteBoard(int no) {
		// TODO Auto-generated method stub
		return BlogMapper.deleteBoard(no);
	}

}
