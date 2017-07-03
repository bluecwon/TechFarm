package com.itbank.TechFarm.blog.mybatis;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BlogMapper {

  private static SqlSessionFactory sqlMapper;

  static {
    try {
    	String resource = "com/itbank/TechFarm/blog/SqlMapConfig.xml";
    	Reader reader = Resources.getResourceAsReader(resource);
    	sqlMapper = new SqlSessionFactoryBuilder().build(reader); 
    } catch (IOException e) {
   
      throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
    }
  }
}