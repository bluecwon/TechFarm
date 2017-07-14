package com.itbank.TechFarm.tftube.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itbank.TechFarm.tftube.dto.VideoDTO;

public class VideoMapper {
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
	
	public static int insertVideo(VideoDTO dto) {
		SqlSession session=sqlMapper.openSession();
		int res=session.insert("insertVideo",dto);
		session.commit();
		session.close();
		return res;
	}
	
	public static void readCount(String sql){
  		SqlSession session = sqlMapper.openSession();
  		java.util.HashMap map = new java.util.HashMap();
  		map.put("sql", sql);
  		session.update("readCount", map);
  		session.commit();
  		session.close();
  	}
	
	public static List<VideoDTO> listVideo() {
		SqlSession session=sqlMapper.openSession();
		List<VideoDTO> list=session.selectList("listVideo");		
		session.close();
		return list;
	}
	
	public static VideoDTO getVideo(int no){
		SqlSession session=sqlMapper.openSession();
		VideoDTO dto=(VideoDTO)session.selectOne("getVideo",no);		
		session.close();
		return dto;		
	}
	
	public static int deleteVideo(int ind){
		SqlSession session=sqlMapper.openSession();		
		int res=session.delete("deleteVideo",ind);
		session.commit();
		session.close();
		return res;
	}
	
	public static List<VideoDTO> getVideo_member_no(int member_no){
		SqlSession session=sqlMapper.openSession();
		List<VideoDTO> list=session.selectList("getVideo",member_no);
		session.close();
		return list;
	}
	
	public static int hitUp(int no){
  		SqlSession session=sqlMapper.openSession();
  		int res=session.update("hitUp",no); 
  		session.commit();
  		session.close();
  		return res;
  	}
	
	public static int click_like(int no){
		SqlSession session=sqlMapper.openSession();
  		int res=session.update("click_like",no); 
  		session.commit();
  		session.close();
		return res;
	}
	
	public static int click_unlike(int no){
		SqlSession session=sqlMapper.openSession();
  		int res=session.update("click_unlike",no); 
  		session.commit();
  		session.close();
		return res;
	}
	
	public static int cancel_like(int no){
		SqlSession session=sqlMapper.openSession();
  		int res=session.update("cancel_like",no); 
  		session.commit();
  		session.close();
		return res;
	}
	
	public static int cancel_unlike(int no){
		SqlSession session=sqlMapper.openSession();
  		int res=session.update("cancel_unlike",no); 
  		session.commit();
  		session.close();
		return res;
	}
	
	
}
