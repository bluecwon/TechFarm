package com.itbank.TechFarm.tfPlusDAO;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyProfileMapper {
	
	private static SqlSessionFactory sqlMapper;
	static {
	    try {
	    	String resource = "com/itbank/TechFarm/SqlMapConfig_tfplus.xml"; 
	    	Reader reader = Resources.getResourceAsReader(resource);
	    	sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	    } catch (IOException e) {
	    	// Fail fast.
	    	throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
	    }
	}
	
}
