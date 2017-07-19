package com.itbank.TechFarm;


import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.search.SearchNaver;

@Controller
public class HomeController {
	
	@Autowired
	private SearchNaver sn;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login/login";
	}
	

	@RequestMapping(value = "/search.naver", method = RequestMethod.POST)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		String query=request.getParameter("search");
		System.out.println(query);
		int pageNum=ServletRequestUtils.getIntParameter(request, "pagenum",0);
		System.out.println(pageNum);
		pageNum=pageNum*10+1;
		System.out.println(pageNum);
		List<Object> list=sn.search("webkr", query, String.valueOf(pageNum));
		Object total=(Object)list.get(0);
		Object time=(Object)list.get(1);
		ModelAndView mav=new ModelAndView("search/searchresult","result",list.subList(2, list.size()));
		mav.addObject("time", time);
		mav.addObject("total", total);
		mav.addObject("search",query);
		return mav;
	}

}
