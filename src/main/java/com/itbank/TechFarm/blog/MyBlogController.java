package com.itbank.TechFarm.blog;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.blog.dao.Blog_OptionDAO;
import com.itbank.TechFarm.blog.dto.Blog_OptionDTO;


@Controller
public class MyBlogController {

	private static final Logger logger = LoggerFactory.getLogger(MyBlogController.class);
	
	@Autowired 
	private Blog_OptionDAO optionDAO;
	
	@RequestMapping(value="/myBloggg", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:myBlogHome");
		return mav;
	}
	
	@RequestMapping(value="/myBlog")
	public ModelAndView blogMake(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/myBlog2");
		String id = request.getParameter("id");
		Blog_OptionDTO dto = optionDAO.getBlog(id);
		mav.addObject("optionDTO",dto);
		return mav;
	}
	
	
}
