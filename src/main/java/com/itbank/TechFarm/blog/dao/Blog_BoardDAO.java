package com.itbank.TechFarm.blog.dao;

import java.util.List;

import com.itbank.TechFarm.blog.dto.Blog_BoardDTO;
import com.itbank.TechFarm.blog.dto.Blog_MakeBoardDTO;
import com.itbank.TechFarm.blog.dto.Blog_OptionDTO;

public interface Blog_BoardDAO {

	public int makeBoard(Blog_MakeBoardDTO dto);
	public List listBoardTitle(String id);
	public Blog_MakeBoardDTO getBoardTitle(int boardno);
	public int editBoardTitle(Blog_MakeBoardDTO dto);
	public List listBoard(int boardno);
	public int insertboard(Blog_BoardDTO dto);
	/*
	public int deleteFile(int num);*/
}