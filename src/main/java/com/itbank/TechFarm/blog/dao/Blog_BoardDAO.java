package com.itbank.TechFarm.blog.dao;

import java.util.List;

import com.itbank.TechFarm.blog.dto.Blog_MakeBoardDTO;
import com.itbank.TechFarm.blog.dto.Blog_OptionDTO;

public interface Blog_BoardDAO {

	public int makeBoard(Blog_MakeBoardDTO dto);
	public List listBoardTitle(String id);
	/*
	public List listDrive();
	public int deleteFile(int num);*/
}