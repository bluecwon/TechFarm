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

import com.itbank.TechFarm.tfPlusDAO.MemberProfileDAO;
import com.itbank.TechFarm.tfPlusDAO.NewsProfileDAO;
import com.itbank.TechFarm.tfPlusDTO.MemberJoinIdDTO;
import com.itbank.TechFarm.tfPlusDTO.MemberProfileAddCommentDTO;
import com.itbank.TechFarm.tfPlusDTO.MemberProfileBoardDTO;
import com.itbank.TechFarm.tfPlusDTO.MemberProfileDTO;
import com.itbank.TechFarm.tfPlusDTO.NewsFollowIdDTO;
import com.itbank.TechFarm.tfPlusDTO.NewsProfileAddCommentDTO;
import com.itbank.TechFarm.tfPlusDTO.NewsProfileBoardDTO;
import com.itbank.TechFarm.tfPlusDTO.NewsProfileDTO;

@Controller
public class tfPlusNewsProfileController {

	@Autowired
	private NewsProfileDAO newsProfileDAO; 
	@Autowired
	private MemberProfileDAO memberProfileDAO;
	
	// ************************************** //
	/* start News */
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
	/* end News */
	
	/* start Member */
	protected MemberProfileDTO makeMemberProfile(HttpServletRequest req) throws Exception {
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
			String upPath = session.getServletContext().getRealPath("/resources/tfPlus/images/contents/memberProfile");
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
		MemberProfileDTO dto = new MemberProfileDTO();
		dto.setmProfileName(req.getParameter("profileName"));
		dto.setmCheckOption(req.getParameter("checkOption"));
		dto.setmPhoto(filename);
		dto.setmProfileContents(req.getParameter("profileContents"));
		dto.setmProfileId(req.getParameter("profileId"));
		return dto;
	}
	
	protected MemberProfileBoardDTO makeMemberProfileBoard(HttpServletRequest req) throws Exception {
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
			String upPath = session.getServletContext().getRealPath("/resources/tfPlus/images/contents/memberBoard");
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
		MemberProfileBoardDTO dto = new MemberProfileBoardDTO();
		dto.setmProfileBoardPhoto(filename);
		dto.setmProfileBoardTitle(req.getParameter("profileBoardTitle"));
		dto.setmProfileBoardContents(req.getParameter("profileBoardContents"));
		dto.setmProfileBoardName(req.getParameter("profileBoardName"));
		dto.setmProfileBoardId(req.getParameter("profileBoardId"));
		return dto;
	}
	
	protected MemberProfileAddCommentDTO makeMemberProfileAdd(HttpServletRequest req) throws Exception{
		MemberProfileAddCommentDTO dto = new MemberProfileAddCommentDTO();
		dto.setmProfileAddContents(req.getParameter("profileAddContents"));
		dto.setmProfileAddId(req.getParameter("profileAddId"));
		dto.setmProfileBoardFK(Integer.parseInt(req.getParameter("profileBoardFK")));
		dto.setmProfileAddName(req.getParameter("profileBoardName"));
		return dto;
	}
	/* end Member */
	// ************************************** //
	
	
	/* main index*/
	@RequestMapping(value="/tfPlusIndex")
	public ModelAndView tfPlusIndex(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		List newsProfileList = newsProfileDAO.newsProfileTOP(6);
		mav.setViewName("tfPlus/index");
		mav.addObject("newsProfileList",newsProfileList);
		return mav;
	}
	
	/* start News */
	@RequestMapping(value="/tfPlusNewsProfileList")
	public ModelAndView tfPlusNewsProfileList(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		List result = null,followList = null;
		
		followList = newsProfileDAO.newsFollowAllList();
		
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
	
	@RequestMapping(value="/tfPlusNewsProfileBoardList")
	public ModelAndView tfPlusNewsProfileBoardList(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		String msg=null,url=null;

		String profileName = request.getParameter("profileName");
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		String my = request.getParameter("my");
		
		List listAdd = newsProfileDAO.newsAddList(Integer.parseInt(num));
		List list = newsProfileDAO.newsProfileBoard(profileName, id);
		
		if(my.equals("true")){
			mav.setViewName("tfPlus/newsProfile/newsProfileBoardList");
		} else if(my.equals("false")){
			String myId = request.getParameter("myId");
			boolean bool = newsProfileDAO.newsFollowIdCheck(Integer.parseInt(num), myId);
			if(bool == true){
				mav.setViewName("tfPlus/newsProfile/newsProfileBoardList");
			} else {
				msg = "Please follow me.";
				url = "tfPlusNewsProfileList";
				mav.setViewName("tfPlus/message");
				mav.addObject("msg",msg);
				mav.addObject("url",url);
			}
		}
		mav.addObject("newsBoardList",list);
		mav.addObject("newsBoardName",profileName);
		mav.addObject("newsprofileId",id);
		mav.addObject("newsAddList",listAdd);
		mav.addObject("num",num);
		mav.addObject("my",my);
		return mav;
	}
	
	@RequestMapping(value="/tfPlusNewsProfileWriting")
	public ModelAndView tfPlusNewsProfileWriting(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
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
	public ModelAndView tfPlusNewsFollowList(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		int num;
		List<NewsProfileDTO> list = new ArrayList();
		List<NewsFollowIdDTO> result = newsProfileDAO.newsFollowMyList(id);
		List followList = newsProfileDAO.newsFollowAllList();
		
		for(NewsFollowIdDTO dto : result){
			NewsProfileDTO newsProfileDTO = new NewsProfileDTO();
			num = dto.getNewsfollowNum();
			newsProfileDTO = newsProfileDAO.newsNumList(num);
			list.add(newsProfileDTO);
		}
		mav.setViewName("tfPlus/newsProfile/newsFollowList");
		mav.addObject("newsMyFollowList",list);
		mav.addObject("followList",followList);
		return mav;
	} 
	
	@RequestMapping(value="/tfPlusNewsFollowInsert")
	public ModelAndView tfPlusNewsFollowInsert(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		int profileNum = Integer.parseInt(request.getParameter("profileNum"));
		String id = request.getParameter("id");
		int res = newsProfileDAO.newsFollowInsert(profileNum, id); 
		newsProfileDAO.newsProfileFollow(profileNum); 
		mav.setViewName("redirect:tfPlusNewsProfileList");
		return mav;
	} 
	
	@RequestMapping(value="/tfPlusNewsFollowDelect")
	public ModelAndView tfPlusNewsFollowDelect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		int newsfollowPK = Integer.parseInt(request.getParameter("newsfollowPK"));
		int profileNum = Integer.parseInt(request.getParameter("profileNum"));
		int res = newsProfileDAO.newsFollowDelete(newsfollowPK);
		mav.setViewName("redirect:tfPlusNewsProfileList");
		newsProfileDAO.newsProfileUnFollow(profileNum); 
		return mav;
	} 
	
	@RequestMapping(value="/tfPlusNewsProfileWritingPro")
	public ModelAndView tfPlusNewsProfileWritingPro(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
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
	public ModelAndView tfPlusNewsProfileDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	/* end News */
	
	
	
	/* start Member */
	@RequestMapping(value="/tfPlusMemberProfileList")
	public ModelAndView tfPlusMemberProfileList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		List result = null,joinList = null;
		
		joinList = memberProfileDAO.memberJoinAllList();
		
		int pageSize = 9; 
		int countRow = memberProfileDAO.memberProfileCount();
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
		
		result = memberProfileDAO.memberGoodList(startRow, endRow);
		mav.setViewName("tfPlus/memberProfile/memberProfileList");
		mav.addObject("newsGoodList",result);
		mav.addObject("joinList",joinList);

		mav.addObject("currentPage",currentPage); 
		mav.addObject("countRow",countRow);
		mav.addObject("pageCount",pageCount);
		mav.addObject("pageBlock",pageBlock); 
		mav.addObject("startPage",startPage);
		mav.addObject("endPage",endPage);
		return mav;
	}
	
	@RequestMapping(value="/tfPlusMemberProfileWriting")
	public ModelAndView tfPlusMemberProfileWriting(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		List result = null;
		
		int pageSize = 9; 
		int countRow = memberProfileDAO.memberProfileCount(); 
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
		
		result = memberProfileDAO.memberMyList(startRow, endRow, id);
		mav.setViewName("tfPlus/memberProfile/memberProfileWriting");
		mav.addObject("newsMyList",result);
		
		mav.addObject("currentPage",currentPage);
		mav.addObject("countRow",countRow); 
		mav.addObject("pageCount",pageCount);
		mav.addObject("pageBlock",pageBlock); 
		mav.addObject("startPage",startPage);
		mav.addObject("endPage",endPage);
		return mav;
	}
	
	@RequestMapping(value="/tfPlusMemberJoinList")
	public ModelAndView tfPlusMemberJoinList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		int num;
		List<MemberProfileDTO> list = new ArrayList();
		List<MemberJoinIdDTO> result = memberProfileDAO.memberJoinMyList(id);
		List joinList = memberProfileDAO.memberJoinAllList();
		
		for(MemberJoinIdDTO dto : result){
			MemberProfileDTO memberProfileDTO = new MemberProfileDTO();
			num = dto.getMemberJoinNum();
			memberProfileDTO = memberProfileDAO.memberNumList(num);
			list.add(memberProfileDTO);
		}
		mav.setViewName("tfPlus/memberProfile/memberJoinList");
		mav.addObject("memberMyJoinList",list);
		mav.addObject("joinList",joinList);
		return mav;
	}
	
	@RequestMapping(value="/tfPlusMemberProfileBoardWriting")
	public ModelAndView tfPlusMemberProfileBoardWriting(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String name = request.getParameter("name");
		mav.setViewName("tfPlus/memberProfile/memberProfileBoardWriting");
		mav.addObject("name",name);
		return mav;
	}
	
	@RequestMapping(value="/tfPlusMemberProfileBoardList")
	public ModelAndView tfPlusMemberProfileBoardList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String msg=null,url=null;
		
		String profileName = request.getParameter("profileName");
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		String my = request.getParameter("my");
		
		List listAdd = memberProfileDAO.memberAddList(Integer.parseInt(num));
		List list = memberProfileDAO.memberProfileBoard(profileName, id);
		
		if(my.equals("true")){
			mav.setViewName("tfPlus/memberProfile/memberProfileBoardList");
		} else if(my.equals("false")){
			String myId = request.getParameter("myId");
			boolean bool = memberProfileDAO.memberJoinIdCheck(Integer.parseInt(num), myId);
			if(bool == true){
				mav.setViewName("tfPlus/memberProfile/memberProfileBoardList");
			} else {
				msg = "Please follow me.";
				url = "tfPlusMemberProfileList";
				mav.setViewName("tfPlus/message");
				mav.addObject("msg",msg);
				mav.addObject("url",url);
			}
		}
		mav.addObject("memberBoardList",list);
		mav.addObject("memberBoardName",profileName);
		mav.addObject("memberprofileId",id);
		mav.addObject("memberAddList",listAdd);
		mav.addObject("num",num);
		mav.addObject("my",my);
		return mav;
	}
	
	@RequestMapping(value="/tfPlusMemberJoinInsert")
	public ModelAndView tfPlusMemberJoinInsert(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		int profileNum = Integer.parseInt(request.getParameter("profileNum"));
		String id = request.getParameter("id");
		int res = memberProfileDAO.memberJoinInsert(profileNum, id); 
		memberProfileDAO.memberProfileJoin(profileNum); 
		mav.setViewName("redirect:tfPlusMemberProfileList");
		return mav;
	} 
	
	@RequestMapping(value="/tfPlusMemberJoinDelect")
	public ModelAndView tfPlusMemberJoinDelect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		int memberJoinPK = Integer.parseInt(request.getParameter("memberJoinPK"));
		int profileNum = Integer.parseInt(request.getParameter("profileNum"));
		int res = memberProfileDAO.memberJoinDelete(memberJoinPK);
		mav.setViewName("redirect:tfPlusMemberProfileList");
		memberProfileDAO.memberProfileUnJoin(profileNum); 
		return mav;
	} 
	
	@RequestMapping(value="/tfPlusMemberProfileWritingPro")
	public ModelAndView tfPlusMemberProfileWritingPro(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		MemberProfileDTO memberProfileDTO = makeMemberProfile(request);
		String msg=null;
		String url=null;
		MemberProfileDTO dto = new MemberProfileDTO();
		String profileName = memberProfileDTO.getmProfileName();
		String profileId = memberProfileDTO.getmProfileId();
		dto = memberProfileDAO.memberProfileCheck(profileName, profileId);
		if(dto == null) {
			int res = memberProfileDAO.memberProfileInsert(memberProfileDTO);
			dto = memberProfileDAO.memberProfileCheck(profileName, profileId);
			int proFileNum = dto.getmProfileNum();
			mav.setViewName("redirect:tfPlusMemberProfileWriting?id="+profileId);
		} else {
			msg = "This is a duplicate content";
			url = "tfPlusMemberProfileWriting?id="+profileId;
			mav.setViewName("tfPlus/message");
			mav.addObject("msg",msg);
			mav.addObject("url",url);
		}
		return mav;
	} 
	
	@RequestMapping(value="/tfPlusMemberProfileBoardWritingPro") 
	public ModelAndView tfPlusMemberProfileBoardWritingPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		MemberProfileBoardDTO memberProfileBoardDTO = makeMemberProfileBoard(request);
		String name = memberProfileBoardDTO.getmProfileBoardName();
		int res = memberProfileDAO.memberProfileBoardInsert(memberProfileBoardDTO);
		mav.setViewName("redirect:tfPlusMemberProfileBoardWriting?name="+name);
		return mav;
	}
	
	@RequestMapping(value="/memberProfileDelete")
	public ModelAndView tfPlusMemberProfileDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String msg=null;
		String url=null;
		int profileNum = Integer.parseInt(request.getParameter("profileNum"));
		int res = memberProfileDAO.memberProfileDelete(profileNum);
		if(res>0) {
			msg = "You deleted it";
			url = "tfPlusMemberProfileList";
		}
		mav.setViewName("tfPlus/message");
		mav.addObject("msg",msg);
		mav.addObject("url",url);
		return mav;
	} 
	
	@RequestMapping(value="/tfPlusMemberProfileAddPro")
	public ModelAndView tfPlusMemberProfileAddPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		MemberProfileAddCommentDTO memberProfileAddCommentDTO = makeMemberProfileAdd(request);
		int res = memberProfileDAO.memberAddListInsert(memberProfileAddCommentDTO);
		String profileName = request.getParameter("profileName");
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		String my = request.getParameter("my");
		String myId = request.getParameter("profileAddId");
		mav.setViewName("redirect:tfPlusMemberProfileBoardList?profileName="+profileName+"&id="+id+"&num="+num+"&my="+my+"&myId="+myId);
		return mav;
	}		
	/* end Member */
}














