package com.itbank.TechFarm.blog.mybatis;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itbank.TechFarm.blog.dto.Blog_BoardDTO;
import com.itbank.TechFarm.blog.dto.Blog_MakeBoardDTO;
import com.itbank.TechFarm.blog.dto.Blog_OptionDTO;

public class BlogMapper {

  private static SqlSessionFactory sqlMapper;

  static {
    try {
    	String resource = "com/itbank/TechFarm/SqlMapConfig_tfblog.xml";
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
  
  public static int makeBoard(Blog_MakeBoardDTO dto){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.insert("makeBoard",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static List<Blog_MakeBoardDTO> listBoardTitle(String id){
	  SqlSession session = sqlMapper.openSession();
	  List<Blog_MakeBoardDTO> list = (List)session.selectList("listBoardTitle",id);
	  session.close();
	  return list;
  }
  
  public static int editBlog_pf_int(Blog_OptionDTO dto){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.update("editBlog_pf_int",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static int editBlog_layout(Blog_OptionDTO dto){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.update("editBlog_layout",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static int editBlog_skin(Blog_OptionDTO dto){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.update("editBlog_skin",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static int editBlog_headerword(Blog_OptionDTO dto){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.update("editBlog_headerword",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static Blog_MakeBoardDTO getBoardT(int boardno){
	  SqlSession session = sqlMapper.openSession();
	  Blog_MakeBoardDTO dto = session.selectOne("getBoardT", boardno);
	  session.close();
	  return dto;
  }
  
  public static int editBoardT(Blog_MakeBoardDTO dto){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.update("editBoardT",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static List<Blog_BoardDTO> listBoard(int boardno){
	  SqlSession session = sqlMapper.openSession();
	  List<Blog_BoardDTO> list = (List)session.selectList("listBoard",boardno);
	  session.close();
	  return list;
  }
  
  public static int insertBoard(Blog_BoardDTO dto){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.insert("insertBoard",dto);
	  session.commit();
	  session.close();
	  return res;
  }
}