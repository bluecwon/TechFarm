package com.itbank.TechFarm.tftube;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.tftube.dao.LikeVideoDAO;
import com.itbank.TechFarm.tftube.dao.SubingDAO;
import com.itbank.TechFarm.tftube.dao.VideoDAO;
import com.itbank.TechFarm.tftube.dto.VideoDTO;

@Controller
public class CategoryController {
	@Autowired
	private LikeVideoDAO likevideoDAO;	
	@Autowired
	private VideoDAO videoDAO;
	@Autowired
	private SubingDAO subingDAO;	
	
	String msg=null,url=null;
	
	
	@RequestMapping(value="/tftube_category", method=RequestMethod.GET)
	public ModelAndView tftube_category(HttpServletRequest arg0, 
			HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();
		String category=arg0.getParameter("category");
	/*	String[] category_array={
		 "movie",
		 "animation",
		 "car",
		 "music",
		 "sport",
		 "sports",
		 "travel/event",
		 "game",
		 "blog/person",
		 "comedy",
		 "entertainment",
		 "news/politics",
		 "nohow/style",
		 "education",
		 "technology",
		 "none_profit/social_movement"				
		};*/
		List<VideoDTO> clist=null;
		switch(category){
		case "movie":clist=videoDAO.listVideo_category(category);break;
		case "animation":clist=videoDAO.listVideo_category(category);break;
		case "car":clist=videoDAO.listVideo_category(category);break;
		case "music":clist=videoDAO.listVideo_category(category);break;
		case "sport":clist=videoDAO.listVideo_category(category);break;
		case "sports":clist=videoDAO.listVideo_category(category);break;
		case "travel/event":clist=videoDAO.listVideo_category(category);break;
		case "game":clist=videoDAO.listVideo_category(category);break;
		case "blog/person":clist=videoDAO.listVideo_category(category);break;
		case "comedy":clist=videoDAO.listVideo_category(category);break;
		case "entertainment":clist=videoDAO.listVideo_category(category);break;
		case "news/politics":clist=videoDAO.listVideo_category(category);break;
		case "nohow/style":clist=videoDAO.listVideo_category(category);break;
		case "education":clist=videoDAO.listVideo_category(category);break;
		case "technology":clist=videoDAO.listVideo_category(category);break;
		case "none_profit/social_movement":clist=videoDAO.listVideo_category(category);break;		
		default:
			msg="존재하지 않는 카테고리 입니다.";
			url="tftube_main";
			mv.addObject("msg",msg);
			mv.addObject("url",url);
			mv.setViewName("tftube/message");	
			return mv;	
		}
		
		
		mv.addObject("category",category);
		mv.addObject("clist",clist);
		
		
		
		mv.setViewName("tftube/category");//다른 이유가 있을지도
		return mv;
	}
}