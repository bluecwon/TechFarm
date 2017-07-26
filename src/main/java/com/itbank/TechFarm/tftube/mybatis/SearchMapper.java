package com.itbank.TechFarm.tftube.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SearchMapper {
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
	
	
	public static List search_single(String search,String search_text){
		SqlSession session=sqlMapper.openSession();
		HashMap map=new HashMap();		
		map.put("sql","select * from tftube_video where "+search+" like "+"'%"+search_text.trim()+"%'");
		List list=session.selectList("search_single",map);
		session.commit();
		return list;		
	}
	
	
	
	/*public static List search_channel(String channel){
		SqlSession session=sqlMapper.openSession();
		List list=session.selectList("search_channel",channel);
		session.commit();
		return list;		
	}
	
	public static List search_content(String content){
		SqlSession session=sqlMapper.openSession();
		List list=session.selectList("search_content",content);
		session.commit();
		return list;			
	}*/
	
	public static List search_title_content(String title,String content){		
		SqlSession session=sqlMapper.openSession();
		HashMap map=new HashMap();
		map.put("title", "%"+title+"%");
		map.put("content", "%"+content+"%");
		List list=session.selectList("search_title_content",map);
		session.commit();
		return list;			
	}
	
	public static List search_all(String title,String content,String channel){		
		SqlSession session=sqlMapper.openSession();
		HashMap map=new HashMap();
		map.put("title", "%"+title+"%");
		map.put("content","%"+ content+"%");
		map.put("channel", "%"+channel+"%");
		List list=session.selectList("search_title_content",map);
		session.commit();
		return list;			
	}
	
	
}
