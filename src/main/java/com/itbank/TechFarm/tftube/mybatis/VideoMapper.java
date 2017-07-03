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
			String resource = "com/itbank/TechFarm/tftube/SqlMapConfig.xml"; 
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
		session.commit();
		session.close();
		return list;
	}
	
	public static VideoDTO getVideo(int ind){
		SqlSession session=sqlMapper.openSession();
		VideoDTO dto=(VideoDTO)session.selectOne("getVideo",ind);
		session.commit();
		session.close();
		return dto;
		
	}
	
	
	

}
