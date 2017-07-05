package com.itbank.TechFarm.login.member;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberMapper {
	private static SqlSessionFactory sqlMapper;

	  static {
	    try {
	    	String resource="SqlMapConfig_tfmember.xml";
	    	Reader reader = Resources.getResourceAsReader(resource); 
			sqlMapper = new SqlSessionFactoryBuilder().build(reader); 
	    } catch (IOException e) {
	      throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
	    }
	  }
	  
	  public static MemberDTO getLogin(String id){
		  MemberDTO res=null;
		  SqlSession session=sqlMapper.openSession();
		  res=session.selectOne("getLogin", id);
		  session.close();
		  return res;
	  }
	  
	  public static int insertMember(MemberDTO dto){
		  SqlSession session = sqlMapper.openSession();
			int res=session.insert("insertMember", dto);
			session.commit();
			session.close();
			return res;
	  }
	  
	  public static MemberDTO getMember(String id){
		  MemberDTO res=null;
		  SqlSession session=sqlMapper.openSession();
		  res=session.selectOne("getMember", id);
		  session.close();
		  return res;
	  }
}
