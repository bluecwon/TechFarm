package com.itbank.TechFarm.tftube.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itbank.TechFarm.tftube.dto.LikeVideoDTO;
import com.itbank.TechFarm.tftube.dto.VideoDTO;

public class LikeVideoMapper {
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			String resource = "com/itbank/TechFarm/SqlMapConfig_tftube.xml"; 
			Reader reader = Resources.getResourceAsReader(resource); 
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}	
	
	public static LikeVideoDTO likevideo_list(int member_no,int no){
		SqlSession session=sqlMapper.openSession();			
  		java.util.HashMap map = new java.util.HashMap();
  		map.put("member_no",member_no);
		map.put("video_no",no);  		
		LikeVideoDTO ldto=session.selectOne("likevideo_list",map);
		session.close();
		return ldto;
	}
	
	public static int like_insert(LikeVideoDTO dto){
		SqlSession session=sqlMapper.openSession();
		int res=session.insert("like_insert",dto);
		session.commit();
		session.close();
		return res;		
	}
	
	public static int like_delete(int member,int no){
		SqlSession session=sqlMapper.openSession();
		java.util.HashMap map = new java.util.HashMap();
		map.put("member_no",member);
		map.put("video_no",no); 
		int res=session.delete("like_delete",map);
		session.commit();
		session.close();
		return res;
	}
	
	public static int likecount_member(int member_no){
		SqlSession session=sqlMapper.openSession();
		int count=session.selectOne("likecount_member",member_no);		
		session.close();
		return count;
		
	}
}
