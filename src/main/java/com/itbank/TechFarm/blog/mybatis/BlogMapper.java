package com.itbank.TechFarm.blog.mybatis;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itbank.TechFarm.blog.dto.Blog_OptionDTO;

public class BlogMapper {

  private static SqlSessionFactory sqlMapper;

  static {
    try {
    	String resource = "SqlMapConfig_tfblog.xml";
    	Reader reader = Resources.getResourceAsReader(resource);
    	sqlMapper = new SqlSessionFactoryBuilder().build(reader); 
    } catch (IOException e) {
   
      throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
    }
  }
  
  public static int makeBlog(Blog_OptionDTO dto){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.insert("makeBlog",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static Blog_OptionDTO getBlog(String id){
	  SqlSession session = sqlMapper.openSession();
	  Blog_OptionDTO dto = session.selectOne("getBlog",id);
	  session.close();
	  return dto;
	  
  }
  
  public static int deleteBlog(String id){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.delete("deleteBlog",id);
	  session.commit();
	  session.close();
	return res;
	  
  }
  
}