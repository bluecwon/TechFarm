package com.itbank.TechFarm.tftube;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.tftube.dto.ReplyDTO;


@Controller
public class MyChannelController {
	
	
	
	@RequestMapping(value="/tftube_mychannel", method=RequestMethod.GET)
	public ModelAndView tftube_mychannel(HttpServletRequest arg0, 
								HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();
		/*session=arg0.getSession();
		String id=(String)session.getAttribute("tube_id");
		ReplyDTO dto=new ReplyDTO();		
		dto.setContent(arg0.getParameter("content").trim());
		dto.setId(id);		
		int res=replyDAO.insertReply(dto);*/
		
	mv.setViewName("tftube/mychannel");	
	return mv;		
	}

}
