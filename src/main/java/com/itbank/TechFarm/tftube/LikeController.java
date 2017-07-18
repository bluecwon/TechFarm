package com.itbank.TechFarm.tftube;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.tftube.dao.VideoDAO;
import com.itbank.TechFarm.tftube.dto.VideoDTO;

@Controller
public class LikeController {
	
	@Autowired
	private VideoDAO videoDAO;
	
	@RequestMapping(value="/likeVideo", method=RequestMethod.GET)
	public ModelAndView likeVideo(HttpServletRequest arg0, 
			HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();
		//common
		String no_raw=arg0.getParameter("no");//no of video
		int no=0;		
		if(no_raw!=null){
		no=Integer.parseInt(no_raw);}
		
		VideoDTO vdto=videoDAO.getVideo(no);
		//common
				
		
		/*like*/		
		//response
		int like_status=videoDAO.getVideo(no).getLike_status();
		int unlike_status=videoDAO.getVideo(no).getUnlike_status();
		/*System.out.println("response like:"+like_status);
		System.out.println("response unlike:"+unlike_status);*/
		mv.addObject("like_status",like_status);
		mv.addObject("unlike_status",unlike_status);		
		//end of response
		/*String like_video_no_raw=arg0.getParameter("like_video_no");
		int like_video_no=Integer.parseInt(like_video_no_raw);*/
		
		//request
		String like_req_raw=arg0.getParameter("likep");//0 not like
		String unlike_req_raw=arg0.getParameter("unlikep");
		
		
		
		//null->not likes method
		//not null->likes method
		/*0->실행 x  
		 *1->click_like 실행 
		 * 나간값 0 들어온값 0 실행x default 0 
		 * 나간값 0 들어온값 1 좋아요 누름 
		 * 나간값 1 들어온값 0 좋아요 취소
		 * 나간값 1 들어온값 1 실행 x
		 * */
		//어떤 목적으로 나눠놨던가? nullpointException을 잘 파악하기 위함 이었던가.		
		/*VideoDTO likedto=new VideoDTO();*/
		if(like_req_raw!=null){
			int like_req=Integer.parseInt(like_req_raw);			
				if(like_req>like_status){
					videoDAO.click_like(no);					
					//likep 1증가 like_status=1
				}else if(like_req<like_status){
					videoDAO.cancel_like(no);			
				}
				mv.addObject("like_status",like_req);
		}
		
		if(unlike_req_raw!=null){
			int unlike_req=Integer.parseInt(unlike_req_raw);			
			if(unlike_req>unlike_status){
			videoDAO.click_unlike(no);			
			}else if(unlike_req<unlike_status){
			videoDAO.cancel_unlike(no);			
			}
			mv.addObject("unlike_status",unlike_req);	
		}
		vdto=videoDAO.getVideo(no);
		
		/*end of like*/
		mv.setViewName("tftube/videoView_like");
		mv.addObject("vdto",vdto);
		
	return mv;
	}

}
