package com.itbank.TechFarm.blog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.blog.dao.Blog_BoardDAO;
import com.itbank.TechFarm.blog.dao.Blog_OptionDAO;
import com.itbank.TechFarm.blog.dto.Blog_BoardDTO;
import com.itbank.TechFarm.blog.dto.Blog_MakeBoardDTO;
import com.itbank.TechFarm.blog.dto.Blog_OptionDTO;


@Controller
public class BlogBoardController {

	private static final Logger logger = LoggerFactory.getLogger(BlogBoardController.class);
	private ServletContext context;
	
	@Autowired
	private Blog_BoardDAO boardDAO;
	@Autowired 
	private Blog_OptionDAO optionDAO;
	
	@RequestMapping(value="/listBoard")
	public ModelAndView listBoard(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/listBoardMain");
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		int boardno = ServletRequestUtils.getIntParameter(request, "boardno");
		List<Blog_BoardDTO> listBoard = boardDAO.listBoard(boardno);
		session.setAttribute("listBoard", listBoard);
		
		mav.addObject("title",title);
		mav.addObject("boardno",boardno);
		return mav;
	}
	
	@RequestMapping(value="/insertBoard")
	public ModelAndView insertBoardForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		int boardno = ServletRequestUtils.getIntParameter(request, "boardno");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		mav.setViewName("blog/insertBoard");
		mav.addObject("boardno",boardno);
		mav.addObject("id",id);
		mav.addObject("title",title);
		return mav;
	}
	
	// 다중파일업로드
	  @RequestMapping(value = "/file_uploader_html5",
	                  method = RequestMethod.POST)
	  @ResponseBody
	  public String multiplePhotoUpload(HttpServletRequest request) {
	    // 파일정보
	    StringBuffer sb = new StringBuffer();
	    try {
	      // 파일명을 받는다 - 일반 원본파일명
	      String oldName = request.getHeader("file-name");
	      // 파일 기본경로 _ 상세경로
	      HttpSession session = request.getSession();
	      String filePath = session.getServletContext().getRealPath("/")+"resources"+File.separator+"upload"+File.separator;
	      String saveName = sb.append(new SimpleDateFormat("yyyyMMddHHmmss")
	                          .format(System.currentTimeMillis()))
	                          .append(UUID.randomUUID().toString())
	                          .append(oldName.substring(oldName.lastIndexOf("."))).toString();
	      InputStream is = request.getInputStream();
	      OutputStream os = new FileOutputStream(filePath + saveName);
	      int numRead;
	      byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
	      while ((numRead = is.read(b, 0, b.length)) != -1) {
	        os.write(b, 0, numRead);
	      }
	      os.flush();
	      os.close();
	      // 정보 출력
	      sb = new StringBuffer();
	      sb.append("&bNewLine=true")
	        .append("&sFileName=").append(oldName)
	        .append("&sFileURL=").append("http://localhost:8081/TechFarm/resources/upload/")
	       // .append("&sFileURL=").append(filePath)
	        .append(saveName);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return sb.toString();
	  }
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)

	public ModelAndView write(HttpServletRequest request) throws Exception {
	  ModelAndView mav = new ModelAndView("redirect:listBoard");
	  
	  Blog_BoardDTO dto = getBoardOption(request);
	
	  int res = boardDAO.insertboard(dto);
	  
	  mav.addObject("title",dto.getTitle());
	  mav.addObject("boardno",dto.getBoardno());
	 
	  return mav;
	}
	
		private Blog_BoardDTO getBoardOption(HttpServletRequest arg0) throws Exception{
		
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)arg0;
		MultipartFile mf = mr.getFile("file");	
		String file1 = mf.getOriginalFilename();
		
		HttpSession session = arg0.getSession();
		String upPath = session.getServletContext().getRealPath("/resources/upload/");
		File file = new File(upPath,file1);
		
		if(file1.trim().equals("")){}
		else{
			mf.transferTo(file);
		}
		Blog_BoardDTO dto = new Blog_BoardDTO();
			
			dto.setId(arg0.getParameter("id"));
			dto.setArea(Integer.parseInt(arg0.getParameter("area")));
			dto.setSubject(arg0.getParameter("subject"));
			dto.setContent(arg0.getParameter("content"));
			dto.setFile1(file1);
			dto.setOpen(Integer.parseInt(arg0.getParameter("open")));
			dto.setBoardno(Integer.parseInt(arg0.getParameter("boardno")));
			dto.setTitle(arg0.getParameter("title"));
			
		return dto;
	}
		
	@RequestMapping(value="/viewBoard")
	public ModelAndView blogMake(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		String mode = "view";
		int no = ServletRequestUtils.getIntParameter(request, "no");
		mav.setViewName("blog/listBoardMain");
		HttpSession session = request.getSession();
		String upPath = session.getServletContext().getRealPath("/resources/upload/");
		Blog_BoardDTO dto = boardDAO.getBoard(no);
		
		mav.addObject("boardDTO",dto);
		mav.addObject("title",dto.getTitle());
		mav.addObject("mode",mode);
		mav.addObject("upPath",upPath);
		return mav;
		}	
	
	@RequestMapping(value="/updateBoard" , method = RequestMethod.GET)
	public ModelAndView updateBoard(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		int no = ServletRequestUtils.getIntParameter(request, "no");
		String title = request.getParameter("title");
		mav.setViewName("blog/updateBoard");
		Blog_BoardDTO dto = boardDAO.getBoard(no);
		
		mav.addObject("boardDTO",dto);
		mav.addObject("title",dto.getTitle());
		return mav;
		}
	
	@RequestMapping(value="/updateBoard" , method = RequestMethod.POST)
	public ModelAndView updateBoardPro(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView("redirect:listBoard");
		Blog_BoardDTO dto = getBoardOption(request);
		int res = boardDAO.updateBoard(dto);
		
		mav.addObject("boardno",dto.getBoardno());
		mav.addObject("title",dto.getTitle());
		return mav;
		}
	
	@RequestMapping(value="/deleteBoard")
	public ModelAndView blogDelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView("redirect:listBoard");
		int no = ServletRequestUtils.getIntParameter(request, "no");
		Blog_BoardDTO dto = boardDAO.getBoard(no);
		String file1 = dto.getFile1();
		int res = boardDAO.deleteBoard(no);	
		
		if(res>0){
			HttpSession session = request.getSession();
			String delpfPath = session.getServletContext().getRealPath("/resources/upload/"+file1);
			File delfile = new File(delpfPath);
			delfile.delete();
		}
		
		mav.addObject("title",dto.getTitle());
		mav.addObject("boardno",dto.getBoardno());
		return mav;
	}

}
