package com.itbank.TechFarm.blog;

import java.io.File;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value="/myBlog")
	public ModelAndView blogMake(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/myBlog");
		String id = request.getParameter("id");
		Blog_OptionDTO dto = optionDAO.getBlog(id);
		mav.addObject("optionDTO",dto);
		return mav;
	}
	
	@RequestMapping(value="/editBlog", method=RequestMethod.GET)
	public ModelAndView blogEdit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/editBlogMain");
		String mode = request.getParameter("mode");
		String id = request.getParameter("id");
		Blog_OptionDTO dto = optionDAO.getBlog(id);
		mav.addObject("mode",mode);
		mav.addObject("optionDTO",dto);
		return mav;
	}
	
	@RequestMapping(value="/editBlog", method=RequestMethod.POST)
	public ModelAndView blogEditPro(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/editBlogMain");
		String mode = request.getParameter("mode");
		String id = request.getParameter("id");
		Blog_OptionDTO dto = optionDAO.getBlog(id);
		mav.addObject("mode",mode);
		mav.addObject("optionDTO",dto);
		return mav;
	}
	
	@RequestMapping(value="/deleteBlog")
	public ModelAndView blogDelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		String header = request.getParameter("header");
		String profile = request.getParameter("profile");
		int res = optionDAO.deleteBlog(id);	
		if(res>0){
			HttpSession session = request.getSession();
			String delpfPath = session.getServletContext().getRealPath("/resources/upload/"+id);
			File delfile = new File(delpfPath);
			File[] innerFilelist = delfile.listFiles();
			
			for(File innerFile : innerFilelist){
				innerFile.delete();
			}
			delfile.delete();
		}
		return new ModelAndView("redirect:blogStart.blog");
	}
	
	
	
	
}
