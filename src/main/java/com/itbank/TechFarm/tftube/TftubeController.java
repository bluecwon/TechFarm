package com.itbank.TechFarm.tftube;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.tftube.dao.VideoDAO;
import com.itbank.TechFarm.tftube.dto.VideoDTO;






/**
 * Handles requests for the application home page.
 */
@Controller
public class TftubeController {
	
	@Autowired
	private VideoDAO videoDAO;
	


	
	private String upPath_file=null;
	private String upPath_img=null;
	private HttpSession session=null;
	String msg=null, url=null;	
	
	
	private String id;
	
	/*private static final Logger logger = LoggerFactory.getLogger(HomeController.class);*/
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listBoard(HttpServletRequest arg0, 
			HttpServletResponse arg1) throws Exception {
		
		return "index";
	}*/
	
	@RequestMapping(value = "/tftube_main", method = RequestMethod.GET)
	public ModelAndView tftube_main(HttpServletRequest arg0, 
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("tftube/main");
		List<VideoDTO> list=videoDAO.listVideo();
		mav.addObject("list",list);
		session=arg0.getSession();		
		/*String upPath_file2=session.getServletContext().getRealPath("/uploadVideo");
		String upPath_img2=session.getServletContext().getRealPath("/uploadImage");*/

		upPath_img="D:\\workspace_tftube\\tftube\\src\\main\\webapp\\resources\\tftube\\uploadImage";
		upPath_file="D:\\workspace_tftube\\tftube\\src\\main\\webapp\\resources\\tftube\\uploadVideo";	
		
		/*upPath_file=session.getServletContext().getContextPath()+"/uploadVideo";				
		upPath_img=session.getServletContext().getRealPath("uploadImage");*/
		
		id="pkrngd";
		
		session.setAttribute
		("upPath_img",upPath_img);		
		session.setAttribute
		("upPath_file", upPath_file);	
		session.setAttribute
		("listing",list);
		session.setAttribute("tube_id", id);
		
		return mav;
	}		
}
