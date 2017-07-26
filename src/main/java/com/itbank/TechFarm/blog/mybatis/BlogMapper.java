package com.itbank.TechFarm.blog.mybatis;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itbank.TechFarm.blog.dto.Blog_BoardDTO;
import com.itbank.TechFarm.blog.dto.Blog_BoardReplyDTO;
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
  
  public static Blog_BoardDTO getBoard(int no){
	  SqlSession session = sqlMapper.openSession();
	  Blog_BoardDTO dto = session.selectOne("getBoard", no);
	  session.close();
	  return dto;
  }
  
  public static int updateBoard(Blog_BoardDTO dto){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.update("updateBoard",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static int deleteBoard(int no){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.delete("deleteBoard",no);
	  session.commit();
	  session.close();
	return res;
	  
  }
  
  public static int insertReply(Blog_BoardReplyDTO dto){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.insert("insertReply",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static int updateRestep(){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.update("updateRestep");
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static int updateRerestep(int re_step){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.update("updateRerestep",re_step);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static int updateReplyNumber(int no){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.update("updateReplyNumber",no);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static int minusReplyNumber(int no){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.update("minusReplyNumber",no);
	  session.commit();
	  session.close();
	  return res;
  }
  
  /*public static List<Blog_BoardReplyDTO> listReply(int no){
	  SqlSession session = sqlMapper.openSession();
	  List<Blog_BoardReplyDTO> list = (List)session.selectList("listReply",no);
	  session.close();
	  return list;
  }*/
  
  public static List<Blog_BoardReplyDTO> listReply(int no,int startRow,int endRow){
	  SqlSession session = sqlMapper.openSession();
	  Map<String, Object> parameters = new HashMap<String, Object>();
	  parameters.put("no", no);
	  parameters.put("startRow", startRow);
	  parameters.put("endRow", endRow);
	  List<Blog_BoardReplyDTO> list = (List)session.selectList("listReply",parameters);
	  session.close();
	  return list;
  }
  
  public static int updateReadcount(int no){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.update("updateReadcount",no);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static int deleteReply(int replyno){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.delete("deleteReply",replyno);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static int replyNumber(int no){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.selectOne("replyNumber", no);
	  session.close();
	  return res;
  }
   
  public static List<Blog_BoardDTO> listNewBoard(){
	  SqlSession session = sqlMapper.openSession();
	  List<Blog_BoardDTO> list = (List)session.selectList("listNewBoard");
	  session.close();
	  return list;
  }
  
  public static List<Blog_BoardDTO> listHotBoard(){
	  SqlSession session = sqlMapper.openSession();
	  List<Blog_BoardDTO> list = (List)session.selectList("listHotBoard");
	  session.close();
	  return list;
  }
  
  public static List<String> listHotProfile(){
	  SqlSession session = sqlMapper.openSession();
	  List<String> list = (List)session.selectList("listHotProfile");
	  session.close();
	  return list;
  }
  
  public static List<String> listNewProfile(){
	  SqlSession session = sqlMapper.openSession();
	  List<String> list = (List)session.selectList("listNewProfile");
	  session.close();
	  return list;
  }
  
  public static List<Blog_OptionDTO> listHotBlog(){
	  SqlSession session = sqlMapper.openSession();
	  List<Blog_OptionDTO> list = (List)session.selectList("listHotBlog");
	  session.close();
	  return list;
  }
  
  public static List<Blog_BoardDTO> listAreaBoard(int area){
	  SqlSession session = sqlMapper.openSession();
	  List<Blog_BoardDTO> list = (List)session.selectList("listAreaBoard",area);
	  session.close();
	  return list;
  }
  
  public static List<String> listAreaProfile(int area){
	  SqlSession session = sqlMapper.openSession();
	  List<String> list = (List)session.selectList("listAreaProfile",area);
	  session.close();
	  return list;
  }
  
}