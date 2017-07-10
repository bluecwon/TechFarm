package com.itbank.TechFarm.tfPlusController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.tfPlusDAO.NewsProfileDAO;
import com.itbank.TechFarm.tfPlusDTO.NewsFollowIdDTO;
import com.itbank.TechFarm.tfPlusDTO.NewsProfileAddCommentDTO;
import com.itbank.TechFarm.tfPlusDTO.NewsProfileBoardDTO;
import com.itbank.TechFarm.tfPlusDTO.NewsProfileDTO;

@Controller
public class tfPlusNewsProfileController {

	@Autowired
	private NewsProfileDAO newsProfileDAO; 
	
	// ************************************** //
	protected NewsProfileDTO makeNewsProfile(HttpServletRequest req) throws Exception {
		MultipartFile mf= null;
		String filename = null;
		String photo = req.getParameter("photo");
		if(photo != null){
			filename = photo;
		} else {
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
			mf = mr.getFile("photo");
			filename = mf.getOriginalFilename();
			HttpSession session = req.getSession();
			String upPath = session.getServletContext().getRealPath("/resources/tfPlus/images/contents/profile");
			File file = new File(upPath,filename);
			if(file.exists()){
				for(int k=0; true; k++){
					file = new File(upPath,"("+k+")"+filename);
					if(!file.exists()){
						filename = "("+k+")"+filename; break;
					}
				}
			}
			mf.transferTo(file);
		}
		NewsProfileDTO dto = new NewsProfileDTO();
		dto.setProfileName(req.getParameter("profileName"));
		dto.setCheckOption(req.getParameter("checkOption"));
		dto.setPhoto(filename);
		dto.setProfileContents(req.getParameter("profileContents"));
		dto.setProfileId(req.getParameter("profileId"));
		return dto;
	}
	
	protected NewsProfileBoardDTO makeNewsProfileBoard(HttpServletRequest req) throws Exception {
		MultipartFile mf= null;
		String filename = null;
		String photo = req.getParameter("photo");
		if(photo != null){
			filename = photo;
		} else {
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
			mf = mr.getFile("photo");
			filename = mf.getOriginalFilename();
			HttpSession session = req.getSession();
			String upPath = session.getServletContext().getRealPath("/resources/tfPlus/images/contents/profileBoard");
			File file = new File(upPath,filename);
			if(file.exists()){
				for(int k=0; true; k++){
					file = new File(upPath,"("+k+")"+filename);
					if(!file.exists()){
						filename = "("+k+")"+filename; break;
					}
				}
			}
			mf.transferTo(file);
		}
		NewsProfileBoardDTO dto = new NewsProfileBoardDTO();
		dto.setProfileBoardPhoto(filename);
		dto.setProfileBoardTitle(req.getParameter("profileBoardTitle"));
		dto.setProfileBoardContents(req.getParameter("profileBoardContents"));
		dto.setProfileBoardName(req.getParameter("profileBoardName"));
		dto.setProfileBoardId(req.getParameter("profileBoardId"));
		return dto;
	}
	
	protected NewsProfileAddCommentDTO makeNewsProfileAdd(HttpServletRequest req) throws Exception{
		NewsProfileAddCommentDTO dto = new NewsProfileAddCommentDTO();
		dto.setProfileAddContents(req.getParameter("profileAddContents"));
		dto.setProfileAddId(req.getParameter("profileAddId"));
		dto.setProfileBoardFK(Integer.parseInt(req.getParameter("profileBoardFK")));
		dto.setProfileAddName(req.getParameter("profileBoardName"));
		return dto;
	}
	// ************************************** //
	
	
	
	
	
	
	@RequestMapping(value="/tfPlusIndex")
	public ModelAndView googlePlusIndex(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		List newsProfileList = newsProfileDAO.newsProfileTOP(6);
		mav.setViewName("tfPlus/index");
		mav.addObject("newsProfileList",newsProfileList);
		return mav;
	}

	@RequestMapping(value="/tfPlusNewsProfileList")
	public ModelAndView googlePlusNewsProfileList(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		List result = null,followList = null;
		
		followList = newsProfileDAO.newsFollowAllLiat();
		
		int pageSize = 9; 
		int countRow = newsProfileDAO.newsProfileCount();
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum); 
		int startRow = currentPage * pageSize - (pageSize - 1); 
		int endRow = startRow + pageSize - 1; 
		if(endRow>countRow) endRow = countRow;
		int pageCount = countRow/pageSize + (countRow%pageSize==0 ? 0 : 1);
		int pageBlock = 3; 
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage + pageBlock - 1;
		
		result = newsProfileDAO.newsGoodList(startRow, endRow);
		mav.setViewName("tfPlus/newsProfile/newsProfileList");
		mav.addObject("newsGoodList",result);
		mav.addObject("followList",followList);

		mav.addObject("currentPage",currentPage); 
		mav.addObject("countRow",countRow);
		mav.addObject("pageCount",pageCount);
		mav.addObject("pageBlock",pageBlock); 
		mav.addObject("startPage",startPage);
		mav.addObject("endPage",endPage);
		return mav;
	}
	
	@RequestMapping(value="/tfPlusNewsProfileWriting")
	public ModelAndView googlePlusNewsProfileWriting(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		List result = null;
		
		int pageSize = 9; 
		int countRow = newsProfileDAO.newsProfileCount(); 
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum); 
		int startRow = currentPage * pageSize - (pageSize - 1); 
		int endRow = startRow + pageSize - 1; 
		if(endRow>countRow) endRow = countRow;
		int pageCount = countRow/pageSize + (countRow%pageSize==0 ? 0 : 1);
		int pageBlock = 3; 
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage + pageBlock - 1;
		
		result = newsProfileDAO.newsMyList(startRow, endRow, id);
		mav.setViewName("tfPlus/newsProfile/newsProfileWriting");
		mav.addObject("newsMyList",result);
		
		mav.addObject("currentPage",currentPage);
		mav.addObject("countRow",countRow); 
		mav.addObject("pageCount",pageCount);
		mav.addObject("pageBlock",pageBlock); 
		mav.addObject("startPage",startPage);
		mav.addObject("endPage",endPage);
		return mav;
	} 
	
	@RequestMapping(value="/tfPlusNewsFollowList")
	public ModelAndView googlePlusNewsFollowList(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		int num;
		List<NewsProfileDTO> list = new ArrayList();
		List<NewsFollowIdDTO> result = newsProfileDAO.newsFollowMyList(id);
		for(NewsFollowIdDTO dto : result){
			NewsProfileDTO newsProfileDTO = new NewsProfileDTO();
			num = dto.getNewsfollowNum();
			newsProfileDTO = newsProfileDAO.newsNumList(num);
			list.add(newsProfileDTO);
		}
		mav.setViewName("tfPlus/newsProfile/newsFollowList");
		mav.addObject("newsMyFollowList",list);
		return mav;
	} 
	
	@RequestMapping(value="/tfPlusNewsFollowInsert")
	public ModelAndView googlePlusNewsFollowInsert(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		int profileNum = Integer.parseInt(request.getParameter("profileNum"));
		String id = request.getParameter("id");
		int res = newsProfileDAO.newsFollowInsert(profileNum, id); 
		newsProfileDAO.newsProfileFollow(profileNum); 
		mav.setViewName("redirect:tfPlusNewsProfileList");
		return mav;
	} 
	
	@RequestMapping(value="/tfPlusNewsFollowDelect")
	public ModelAndView googlePlusNewsFollowDelect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		int newsfollowPK = Integer.parseInt(request.getParameter("newsfollowPK"));
		int profileNum = Integer.parseInt(request.getParameter("profileNum"));
		int res = newsProfileDAO.newsFollowDelete(newsfollowPK);
		mav.setViewName("redirect:tfPlusNewsProfileList");
		newsProfileDAO.newsProfileUnFollow(profileNum); 
		return mav;
	} 
	
	@RequestMapping(value="/tfPlusNewsProfileWritingPro")
	public ModelAndView googlePlusNewsProfileWritingPro(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		NewsProfileDTO newsProfileDTO = makeNewsProfile(request);
		String msg=null;
		String url=null;
		NewsProfileDTO dto = new NewsProfileDTO();
		String profileName = newsProfileDTO.getProfileName();
		String profileId = newsProfileDTO.getProfileId();
		dto = newsProfileDAO.newsProfileCheck(profileName, profileId);
		if(dto == null) {
			int res = newsProfileDAO.newsProfileInsert(newsProfileDTO);
			dto = newsProfileDAO.newsProfileCheck(profileName, profileId);
			int proFileNum = dto.getProfileNum();
			mav.setViewName("redirect:tfPlusNewsProfileWriting?id="+profileId);
		} else {
			msg = "This is a duplicate content";
			url = "tfPlusNewsProfileWriting?id="+profileId;
			mav.setViewName("tfPlus/message");
			mav.addObject("msg",msg);
			mav.addObject("url",url);
		}
		return mav;
	} 
	
	@RequestMapping(value="/tfPlusNewsProfileBoardWritingPro") 
	public ModelAndView tfPlusNewsProfileBoardWritingPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		NewsProfileBoardDTO newsProfileBoardDTO = makeNewsProfileBoard(request);
		String name = newsProfileBoardDTO.getProfileBoardName();
		int res = newsProfileDAO.newsProfileBoardInsert(newsProfileBoardDTO);
		mav.setViewName("redirect:tfPlusNewsProfileBoardWriting?name="+name);
		return mav;
	}
	
	@RequestMapping(value="/newsProfileDelete")
	public ModelAndView googlePlusNewsProfileDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String msg=null;
		String url=null;
		int profileNum = Integer.parseInt(request.getParameter("profileNum"));
		int res = newsProfileDAO.newsProfileDelete(profileNum);
		if(res>0) {
			msg = "You deleted it";
			url = "tfPlusNewsProfileList";
		}
		mav.setViewName("tfPlus/message");
		mav.addObject("msg",msg);
		mav.addObject("url",url);
		return mav;
	} 
	
	@RequestMapping(value="/tfPlusNewsProfileBoardList")
	public ModelAndView googlePlusNewsProfileBoardList(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		String msg=null,url=null;
		String profileName = request.getParameter("profileName");
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		String my = request.getParameter("my");
		List listAdd = newsProfileDAO.newsAddList(Integer.parseInt(num));
		if(my.equals("true")){
			List list = newsProfileDAO.newsProfileBoard(profileName, id);
			mav.setViewName("tfPlus/newsProfile/newsProfileBoardList");
			mav.addObject("newsBoardList",list);
			mav.addObject("newsBoardName",profileName);
			mav.addObject("newsprofileId",id);
			mav.addObject("newsAddList",listAdd);
			mav.addObject("num",num);
			mav.addObject("my",my);
		} else if(my.equals("false")){
			String myId = request.getParameter("myId");
			boolean bool = newsProfileDAO.newsFollowIdCheck(Integer.parseInt(num), myId);
			if(bool == true){
				List list = newsProfileDAO.newsProfileBoard(profileName, id);
				mav.setViewName("tfPlus/newsProfile/newsProfileBoardList");
				mav.addObject("newsBoardList",list);
				mav.addObject("newsBoardName",profileName);
				mav.addObject("newsprofileId",id);
				mav.addObject("newsAddList",listAdd);
				mav.addObject("num",num);
				mav.addObject("my",my);
			} else {
				msg = "Please follow me.";
				url = "tfPlusNewsProfileList";
				mav.setViewName("tfPlus/message");
				mav.addObject("msg",msg);
				mav.addObject("url",url);
			}
		}
		return mav;
	}
	
	@RequestMapping(value="/tfPlusNewsProfileBoardWriting")
	public ModelAndView tfPlusNewsProfileBoardWriting(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String name = request.getParameter("name");
		mav.setViewName("tfPlus/newsProfile/newsProfileBoardWriting");
		mav.addObject("name",name);
		return mav;
	}
	
	@RequestMapping(value="/tfPlusNewsProfileAddPro")
	public ModelAndView tfPlusNewsProfileAddPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		NewsProfileAddCommentDTO newsProfileAddCommentDTO = makeNewsProfileAdd(request);
		int res = newsProfileDAO.newsAddListInsert(newsProfileAddCommentDTO);
		String profileName = request.getParameter("profileName");
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		String my = request.getParameter("my");
		String myId = request.getParameter("profileAddId");
		mav.setViewName("redirect:tfPlusNewsProfileBoardList?profileName="+profileName+"&id="+id+"&num="+num+"&my="+my+"&myId="+myId);
		return mav;
	}
	
}














