package com.itbank.TechFarm.tftube;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.tftube.dao.ReplyDAO;
import com.itbank.TechFarm.tftube.dao.VideoDAO;
import com.itbank.TechFarm.tftube.dto.VideoDTO;


@Controller
public class VideoController {
	@Autowired
	private VideoDAO videoDAO;
	
	@Autowired
	private ReplyDAO replyDAO;
	
	private String upPath_file=null;
	private String upPath_img=null;
	private HttpSession session=null;
	String msg=null, url=null;	
	
	@RequestMapping(value="/tftube_video_insert", method=RequestMethod.GET)
	public ModelAndView insertFormBoard(HttpServletRequest arg0, 
								HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("tftube/insertForm");
		return mv;		
	}
	
	@RequestMapping(value="/tftube_video_insert", method=RequestMethod.POST)
	public ModelAndView insertProBoard (HttpServletRequest arg0, 
								HttpServletResponse arg1)  throws Exception  {
		VideoDTO dto = new VideoDTO();
		ModelAndView mv=new ModelAndView();		
		String dir=this.getClass().getResource("").getPath();
		File video_dir = new File(dir,"uploadVideo");
		File image_dir = new File(dir,"uploadImage");			

		if(!video_dir.mkdirs()){	   
			video_dir.mkdirs();	//상위 디렉토리까지 생성		
		}   		
		if(!image_dir.mkdirs()){
			image_dir.mkdirs();
		}
		mv.setViewName("redirect:tftube_main");
		
		System.out.println("업로드경로:"+this.getClass().getResource("").getPath());
		
        



		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)arg0;
		MultipartFile mf = mr.getFile("filename");
		String filename = mf.getOriginalFilename();
		if(!(filename.substring(filename.length()-3, filename.length()).equals("mp4"))){			
			msg="only mp4 available";
			url="tftube_video_insert";
			return new ModelAndView("tftube/message");
		}
		HttpSession session=arg0.getSession();		
			
		
		File file = new File(video_dir,filename);
		//String md5_video=md5(file);
		//System.out.println(md5_video);
		
		
		
		if(filename.trim().equals("")){}
		else{
		mf.transferTo(file);
		}
		
		MultipartFile mf2 = mr.getFile("image");
		String image = mf2.getOriginalFilename(); 		
						
		File file2 = new File(image_dir,image);
		//String md5_image=md5(file2);
		//System.out.println(md5_image);
		if(image.trim().equals("")){}
		else{
		mf2.transferTo(file2);
		}
		
		dto.setDescription(ServletRequestUtils.getStringParameter(arg0, "description"));
		dto.setId("pkrngd");
		dto.setFilename(filename);
		dto.setOpen(ServletRequestUtils.getStringParameter(arg0, "open"));
		dto.setTitle(ServletRequestUtils.getStringParameter(arg0, "title"));
		dto.setFilesize((int)mf.getSize());	
		dto.setImage(image);		
		
		int res =videoDAO.insertVideo(dto);	
		if(res>0){
			mv.setViewName("redirect:tftube_main");			
		}
		else{
			msg="file upload failed.";
			url="tftube_video_insert";
			mv.setViewName("message.jsp");
			mv.addObject("msg",msg);
			mv.addObject("url",url);				
		}
		
		
		return mv;
	}	
	
	/*@RequestMapping(value = "/file/upload", method = RequestMethod.POST)
	@ResponseBody
	public List upload(
	    @RequestParam(value = "files[]", required = false) MultipartFile[] files) throws IllegalStateException, IOException {

	  List fileMetas = new ArrayList();
	  for (MultipartFile file : files) {
	    File uploadFile = new File("/", file.getOriginalFilename());
	    file.transferTo(uploadFile);
	    FileMeta fileMeta = new FileMeta(uploadFile.getAbsolutePath(), file.getSize(), "");
	    fileMetas.add(fileMeta);
	  }

	  return fileMetas;
	}*/
	
	@RequestMapping(value="/tftube_videoView", method=RequestMethod.GET)
	public ModelAndView videoView(HttpServletRequest arg0, 
								HttpServletResponse arg1) throws Exception {
		int ind=ServletRequestUtils.getIntParameter(arg0, "ind");
		
		ModelAndView mv=new ModelAndView();	
		
		VideoDTO vdto=videoDAO.getVideo(ind);
		mv.addObject("vdto",vdto);
		
		List r_list=replyDAO.replyList();
		mv.addObject("r_list",r_list);
		
		
		/*BoardDTO bdto=new BoardDTO();
		bdto.setContent(arg0.getParameter("content"));
		bdto.setContent((String)session.getAttribute("tube_id"));
		int res=boardDAO.insertBoard(bdto);*/
		
		mv.setViewName("tftube/videoView");			
		
		/*int pageSize = 5;
		String pageNum = arg0.getParameter("pageNum");
		if (pageNum == null){
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = currentPage * pageSize - (pageSize - 1);
		int endRow = startRow + pageSize - 1;
		int countRow = boardDAO.getCount();  
		
		if (endRow>countRow) endRow = countRow;
		int number = countRow - (currentPage-1) * pageSize;
		
		List<BoardDBBean> list = boardDAO.listBoard(startRow, endRow);			
		
		if (countRow>0) {
			int pageCount = countRow/pageSize + (countRow%pageSize==0 ? 0 : 1);
			int pageBlock = 3;
			int startPage = (currentPage-1)/pageBlock * pageBlock + 1;
			int endPage = startPage + pageBlock - 1;
			if (endPage>pageCount) endPage = pageCount;			
			mv.addObject("startPage", startPage);
			mv.addObject("endPage", endPage);
			mv.addObject("pageBlock", pageBlock);
			mv.addObject("pageCount", pageCount);			
		}				
		mv.addObject("boardList", list);
		mv.addObject("number",number);*/	
		return mv;
		
	}

}
