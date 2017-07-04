package com.itbank.TechFarm.contacts;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ContactsMapper {
	private static SqlSessionFactory sqlMapper;

	  static {
	    try {
	    	String resource="com/itbank/TechFarm/SqlMapConfig_tfcontacts.xml";
	    	Reader reader = Resources.getResourceAsReader(resource); 
			sqlMapper = new SqlSessionFactoryBuilder().build(reader); 
	    } catch (IOException e) {
	      throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
	    }
	  }
	  
	  public static List<ContactsDTO> liseContacts(){
		  SqlSession session=sqlMapper.openSession();
		  session.close();
		  return null;
	  }
	  
	  
}
