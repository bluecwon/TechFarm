package com.itbank.TechFarm.tftube.dao;

import java.util.List;

import com.itbank.TechFarm.tftube.mybatis.SearchMapper;

public class SearchDAOImpl implements SearchDAO{

	

	@Override
	public List search_single(String search, String search_text) {

		return SearchMapper.search_single(search, search_text);
	}	
	

}
