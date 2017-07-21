package com.itbank.TechFarm.blog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.blog.dao.Blog_BoardDAO;
import com.itbank.TechFarm.blog.dao.Blog_OptionDAO;
import com.itbank.TechFarm.blog.dto.Blog_MakeBoardDTO;
import com.itbank.TechFarm.blog.dto.Blog_OptionDTO;


@Controller
public class MyBlogController {

	private static final Logger logger = LoggerFactory.getLogger(MyBlogController.class);
	
	@Autowired 
	private Blog_OptionDAO optionDAO;
	@Autowired
	private Blog_BoardDAO boardDAO;
	
	@RequestMapping(value="/myBlog")
	public ModelAndView blogMake(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		mav.setViewName("blog/myBlog");
		String id = request.getParameter("id");
		Blog_OptionDTO dto = optionDAO.getBlog(id);
		List<Blog_MakeBoardDTO> list = boardDAO.listBoardTitle(id);
		session.setAttribute("list", list);
		session.setAttribute("optionDTO", dto);
		return mav;
	}
	
	@RequestMapping(value="/editBlog", method=RequestMethod.GET)
	public ModelAndView blogEdit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/editBlogMain");
		String mode = request.getParameter("mode");
		
		mav.addObject("mode",mode);
		return mav;
	}
	
	@RequestMapping(value="/editBlog", method=RequestMethod.POST)
	public ModelAndView blogEditPro(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/editBlogMain");
		String mode = request.getParameter("mode");
		HttpSession session = request.getSession();
		/*String id = request.getParameter("id");
		Blog_OptionDTO dto = optionDAO.getBlog(id);*/
		Blog_OptionDTO dto = (Blog_OptionDTO) session.getAttribute("optionDTO");
		
		if(mode.equals("profile")){//profile , introduce
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
			
			MultipartFile mf = mr.getFile("profile");
			String profile = mf.getOriginalFilename();
			String introduce = mr.getParameter("introduce");
			System.out.println(introduce);
			String pfupPath = session.getServletContext().getRealPath("/resources/upload/"+dto.getId());
			File file = new File(pfupPath,profile);
			if(profile.trim().equals("")){
				String originpf = dto.getProfile();
				dto.setProfile(originpf);
			}else{
				mf.transferTo(file);
				dto.setProfile(profile);
			}
			dto.setIntroduce(introduce);
			int res = optionDAO.editBlog_pf_int(dto);
			
		}else if(mode.equals("layout")){//layout
			int layout = ServletRequestUtils.getIntParameter(request, "layout");
			dto.setLayout(layout);
			int res = optionDAO.editBlog_layout(dto);
			
		}else if(mode.equals("skin")){//skin, background, header
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
			String originpf = dto.getProfile();
			String originhd = dto.getHeader();
			String skin = mr.getParameter("skin");
			int skinnum = Integer.parseInt(skin.substring(4));
			String header="hd_skin"+skinnum+".jpg";
			String profile="pf_skin"+skinnum+".jpg";
			
			dto.setProfile(profile);
			dto.setHeader(header);
			
			int res = optionDAO.editBlog_skin(dto);
			
			if(res>0){
			String delpfPath = session.getServletContext().getRealPath("/resources/upload/"+dto.getId()+originpf);
			String delhdPath = session.getServletContext().getRealPath("/resources/upload/"+dto.getId()+originhd);
			File delpffile = new File(delpfPath);
			File delhdfile = new File(delpfPath);
			
			delpffile.delete();
			delhdfile.delete();
			
			String pfinFile = session.getServletContext().getRealPath("/resources/images/skin/"+dto.getProfile());
			String pfoutFile = session.getServletContext().getRealPath("/resources/upload/"+dto.getId()+"/"+dto.getProfile());
			String hdinFile =  session.getServletContext().getRealPath("/resources/images/skin/"+dto.getHeader());
			String hdoutFile =  session.getServletContext().getRealPath("/resources/upload/"+dto.getId()+"/"+dto.getHeader());
			
			FileInputStream pforiginFile = new FileInputStream(pfinFile);
			FileOutputStream pfcopyFile = new FileOutputStream(pfoutFile);
			FileInputStream hdoriginFile = new FileInputStream(hdinFile);
			FileOutputStream hdcopyFile = new FileOutputStream(hdoutFile);
			FileCopyUtils.copy(pforiginFile, pfcopyFile);
			FileCopyUtils.copy(hdoriginFile, hdcopyFile);
			pfcopyFile.close();
			pforiginFile.close();
			hdcopyFile.close();
			hdoriginFile.close();
			}
		}else if(mode.equals("neighbor")){//neighbor
			
		}else if(mode.equals("blog")){//headerword
			String headerword = request.getParameter("headerword");
			if(headerword.trim().equals("")){
				headerword="Welcome To "+dto.getId()+" BLOG";
			}
			System.out.println(headerword);
			dto.setHeaderword(headerword);
			int res = optionDAO.editBlog_headerword(dto);
		}
		
		mav.addObject("mode",mode);
		return mav;
	}
	
private Blog_OptionDTO getBlogOption(HttpServletRequest arg0) throws Exception{
		
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)arg0;
		
		String skin = mr.getParameter("skin");
		int skinnum = Integer.parseInt(skin.substring(4));
		System.out.println(skinnum);
		
		String header="hd_skin"+skinnum+".jpg";
		String profile="pf_skin"+skinnum+".jpg";
		String background = "bg_skin.jpg";
		if(skinnum>28){
			background = "bg_skin"+skinnum+".jpg";
		}
		
		Blog_OptionDTO dto = new Blog_OptionDTO();
			
			String id = arg0.getParameter("id");
			dto.setId(id);
			dto.setBlogname(arg0.getParameter("blogname"));
			dto.setLayout(Integer.parseInt(arg0.getParameter("layout")));
			String headerword=arg0.getParameter("headerword");
			if(headerword.trim()=="" || headerword.equals("")){
				headerword = "Welcome To "+id+" BLOG";
			}
			dto.setHeaderword(headerword);
			dto.setNickname(arg0.getParameter("nickname"));
			dto.setIntroduce(arg0.getParameter("introduce"));
			dto.setProfile(profile);
			dto.setBackground(background);
			dto.setHeader(header);
			
		return dto;
	}
	
	@RequestMapping(value="/deleteBlog")
	public ModelAndView blogDelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
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
	
	@RequestMapping(value="/makeBoardTitle", method=RequestMethod.GET)
	public ModelAndView makeBoardform(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/makeBoardTform");
		String mode = "board";
		mav.addObject("mode",mode);
		
		return mav;
	}
	
	@RequestMapping(value="/makeBoardTitle", method=RequestMethod.POST)
	public ModelAndView makeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:editBlog");
		int sideno = ServletRequestUtils.getIntParameter(request, "sideno");
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String mode = request.getParameter("mode");
		
		Blog_MakeBoardDTO mbdto = new Blog_MakeBoardDTO();
		mbdto.setId(id);
		mbdto.setTitle(title);
		mbdto.setSideno(sideno);
		int res = boardDAO.makeBoard(mbdto);
		mav.addObject("mode",mode);
		
		return mav;
	}
	
	@RequestMapping(value="/editBoardTitle", method=RequestMethod.GET)
	public ModelAndView editBoardTform(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/editBoardTform");
		int boardno = ServletRequestUtils.getIntParameter(request, "boardno");
		Blog_MakeBoardDTO makeBoardDTO = boardDAO.getBoardTitle(boardno);
		mav.addObject("makeBoardDTO",makeBoardDTO);
		
		return mav;
	}
	
	@RequestMapping(value="/editBoardTitle", method=RequestMethod.POST)
	public ModelAndView editBoardT(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:editBlog");
		String mode = "board";
		String title = request.getParameter("title");
		int sideno = ServletRequestUtils.getIntParameter(request, "sideno");
		int boardno = ServletRequestUtils.getIntParameter(request, "boardno");
		Blog_MakeBoardDTO makeBoardDTO = boardDAO.getBoardTitle(boardno);
		makeBoardDTO.setSideno(sideno);
		makeBoardDTO.setTitle(title);
		int res = boardDAO.editBoardTitle(makeBoardDTO);
		mav.addObject("mode",mode);
		return mav;
	}
	
	
}
