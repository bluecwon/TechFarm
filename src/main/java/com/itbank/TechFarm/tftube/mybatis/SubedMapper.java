package com.itbank.TechFarm.tftube.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itbank.TechFarm.tftube.dto.SubedDTO;
import com.itbank.TechFarm.tftube.dto.SubingDTO;

public class SubedMapper {
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
	    public static int insertSubed(SubedDTO sddto){
		SqlSession session=sqlMapper.openSession();
		int res=session.insert("insertSubed",sddto);	
		session.commit();
		session.close();
		return res;		
	}
	    
	    public static List<SubedDTO> get_subed(int member_no){
	    	SqlSession session=sqlMapper.openSession();
			List<SubedDTO> subedlist=session.selectList("get_subed",member_no);			
			session.close();
			return subedlist;	
	    	
	    	
	    };
	    
	    public static int deleteSubed(int subbed_member_no){
	    	SqlSession session=sqlMapper.openSession();
			int res=session.delete("deleteSubed",subbed_member_no);
			session.commit();
			session.close();
			return res;	    	
	    }
	    
}
