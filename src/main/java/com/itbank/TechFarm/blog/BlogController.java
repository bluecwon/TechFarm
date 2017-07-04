package com.itbank.TechFarm.blog;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.blog.dto.Blog_OptionDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BlogController {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/blogmain.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "blogmain";
	}
	
	@RequestMapping(value="/login.do")
	public ModelAndView adminHome(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return new ModelAndView("WEB-INF/blog/main.jsp");
	}
	
	@RequestMapping(value="/blogStart.blog")
	public ModelAndView blogStart(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/index");
		String id = "admin";
		mav.addObject("id", id);
		return mav;
	}
		
	@RequestMapping(value="/blogMake.blog")
	public ModelAndView blogMake(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/makeBlog");
		String id = request.getParameter("id");
		mav.addObject("id", id);
		return mav;
	}
	
	@RequestMapping(value="/blogMake2.blog")
	public ModelAndView blogMake2(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/makeBlog2");
			
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
		String id = mr.getParameter("id");
		String blogname = mr.getParameter("blogname");
		String nickname = mr.getParameter("nickname");
		String introduce = mr.getParameter("introduce");
		
		System.out.println("id : "+id);
		System.out.println("blogname : "+blogname);
		System.out.println("nickname : "+nickname);
		System.out.println("introduce : "+introduce);
		
		MultipartFile mf = mr.getFile("profile");
		String profile = mf.getOriginalFilename();
	
		HttpSession session = request.getSession();
		String upPath = session.getServletContext().getRealPath("/resources/upload/profile");
		File file = new File(upPath,profile);
		if(profile.trim().equals("")){}
		else{
		mf.transferTo(file);
		}
		mav.addObject("id", id);
		mav.addObject("blogname", blogname);
		mav.addObject("nickname", nickname);
		mav.addObject("introduce",introduce);
		mav.addObject("profile",profile);
		
		return mav;
	}
	
	@RequestMapping(value="/blogMake3.blog")
	public ModelAndView blogMake3(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/makeBlog3");
		String id = request.getParameter("id");
		String blogname = request.getParameter("blogname");
		String nickname = request.getParameter("nickname");
		String introduce = request.getParameter("introduce");
		String profile = request.getParameter("profile");
		int layout = ServletRequestUtils.getIntParameter(request, "layout");
		
		System.out.println("id : "+id);
		System.out.println("blogname : "+blogname);
		System.out.println("nickname : "+nickname);
		System.out.println("introduce : "+introduce);
		System.out.println("profile : "+profile);
		System.out.println("layout : "+layout);
		
		mav.addObject("id",id);
		mav.addObject("blogname", blogname);
		mav.addObject("nickname", nickname);
		mav.addObject("introduce",introduce);
		mav.addObject("profile",profile);
		mav.addObject("layout",layout);
		
		return mav;
	}
	
	@RequestMapping(value="/blogMakePro.blog")
	public ModelAndView blogMakePro(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		Blog_OptionDTO dto = getBlogOption(request);
		
		//int res = boardDAO.insertBoard(dto,num2,re_step,re_level);
	
		
		return new ModelAndView("redirect:board_list.do");
	}
	
	private Blog_OptionDTO getBlogOption(HttpServletRequest arg0) throws Exception{
		
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)arg0;
		MultipartFile mf = mr.getFile("background");
		MultipartFile mf2 = mr.getFile("header");
		String background = mf.getOriginalFilename();
		String header = mf2.getOriginalFilename();
		
		HttpSession session = arg0.getSession();
		String bgupPath = session.getServletContext().getRealPath("/resources/upload/background");
		String hdupPath = session.getServletContext().getRealPath("/resources/upload/header");
		
		File file = new File(bgupPath,background);
		File file2 = new File(hdupPath,header);
		
		if(background.trim().equals("")){}
		else if(header.trim().equals("")){}
		else{
			mf.transferTo(file);
			mf.transferTo(file2);
		}
		Blog_OptionDTO dto = new Blog_OptionDTO();
	
			dto.setId(arg0.getParameter("id"));
			dto.setBlogname(arg0.getParameter("blogname"));
			dto.setLayout(Integer.parseInt(arg0.getParameter("layout")));
			dto.setProfile(arg0.getParameter("profile"));
			dto.setBackground(background);
			dto.setHeader(header);
			dto.setNickname(arg0.getParameter("nickname"));
			dto.setIntroduce(arg0.getParameter("introduce"));
			
		return dto;
	}
	
}
