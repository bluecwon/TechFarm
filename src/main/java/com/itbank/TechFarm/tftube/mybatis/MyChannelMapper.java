package com.itbank.TechFarm.tftube.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itbank.TechFarm.login.member.MemberDTO;
import com.itbank.TechFarm.tftube.dto.MyChannelDTO;

public class MyChannelMapper {
	
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
	
	
	
	public static int insertChannel(MemberDTO dto){
		SqlSession session=sqlMapper.openSession();
		int res=session.insert("insertChannel",dto);
		session.commit();
		session.close();
		return res;
		
	}
	
	public static List<MyChannelDTO> getChannel(int member_no){
		SqlSession session=sqlMapper.openSession();
		List<MyChannelDTO> list=session.selectList("getChannel",member_no);
		session.close();
		return list;
	}
	

}
