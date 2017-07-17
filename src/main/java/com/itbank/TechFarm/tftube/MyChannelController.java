package com.itbank.TechFarm.tftube;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.tftube.dao.SubedDAO;
import com.itbank.TechFarm.tftube.dao.SubingDAO;
import com.itbank.TechFarm.tftube.dao.VideoDAO;
import com.itbank.TechFarm.tftube.dto.SubedDTO;
import com.itbank.TechFarm.tftube.dto.SubingDTO;
import com.itbank.TechFarm.tftube.dto.VideoDTO;



@Controller
public class MyChannelController {
	
	@Autowired
	private VideoDAO videoDAO;
	@Autowired
	private SubingDAO subingDAO;
	@Autowired
	private SubedDAO subedDAO;
	
	
	String msg=null,url=null;
	
	
	@RequestMapping(value="/tftube_mychannel", method=RequestMethod.GET)
	public ModelAndView tftube_mychannel(HttpServletRequest arg0, 
			HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();
		int member_no=0;
		String member_no_raw=arg0.getParameter("member_no");
		System.out.println(member_no);
		//접근 가능 루트 버튼
		if(member_no_raw!=null){
			msg="로그인이 필요한 서비스 입니다. 로그인을 해주세요.";
			url="login";
			mv.setViewName("tftube/message");
			return mv;
		}
		if(member_no_raw!=null){
			member_no=Integer.parseInt(member_no_raw);
		}		
		
		List<VideoDTO> Video_member_no=videoDAO.listVideo_member_no(member_no);
		
		
		
		mv.addObject("Video_member_no",Video_member_no);
		
		//좋아요 표시한 동영상
		List<VideoDTO> like_list=videoDAO.listLike(member_no);
		
		//구덕정보
		List<SubingDTO> subling_list=subingDAO.get_subing(member_no);
		
		//구독자
		List<SubedDTO> subed_list=subedDAO.get_subed(member_no);
		mv.setViewName("tftube/mychannel");	
		return mv;		
	}

}
