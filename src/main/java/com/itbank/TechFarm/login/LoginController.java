package com.itbank.TechFarm.login;

import java.io.IOException;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.TechFarm.james.JamesUser;
import com.itbank.TechFarm.james.SendIdentify;
import com.itbank.TechFarm.login.member.MemberDAO;
import com.itbank.TechFarm.login.member.MemberDTO;
import com.itbank.TechFarm.tftube.dao.MyChannelDAO;



@Controller
public class LoginController {
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private JamesUser jamesUser;
	
	@Autowired
	private SendIdentify sendIdentify;
	
	/*@Autowired
	private MyChannelDAO mychannelDAO;*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session, Model model) {
		String id=request.getParameter("id");
		MemberDTO dto=memberDAO.getLogin(id);
		session.setAttribute("loginDTO", dto);
		if(dto==null){
			model.addAttribute("cid", 2);
		}else{
			model.addAttribute("cid", 1);
		}
		return "login/login";
	}
	
	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public String login2(Model model,HttpServletRequest request, HttpSession session) throws IOException {
		String passwd=request.getParameter("passwd");
		MemberDTO dto=(MemberDTO)session.getAttribute("loginDTO");
		if(dto.getPasswd().equals(passwd)){
			MemberDTO info=memberDAO.getMember(dto.getId());
			session.removeAttribute("loginDTO");
			session.setAttribute("memberDTO", info);			
			return "redirect:/";
		}else{
			model.addAttribute("cidd", 3);
			model.addAttribute("cid", 1);
			return "login/login";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpSession session) {
		session.invalidate();
		return "home";
	}
	
	@RequestMapping(value = "/createAccount", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login/createAccount";
	}
	
	@RequestMapping(value = "/inputmember", method = RequestMethod.POST)
	public String inputMember(@Valid @ModelAttribute("inputInfo") MemberDTO dto, Errors errors, Model model) {
		if(errors.hasErrors()){
			return "login/createAccount";
		}
		int res=memberDAO.insertMember(dto);
		if(res==1){
			jamesUser.addUser(dto.getId(), dto.getPasswd());
			MemberDTO getdto=memberDAO.getMember(dto.getId());
			dto.setNo(getdto.getNo());
			model.addAttribute("msg", "회원가입을 축하합니다.");
			model.addAttribute("url", "login");
			
		}else{
			model.addAttribute("msg", "회원가입에 실패했습니다.");
			model.addAttribute("url", "createAccount");
		}
		return "login/message";
	}
	
	@RequestMapping(value = "/searchPw", method = RequestMethod.GET)
	public String searchPw(HttpServletRequest request) {
		return "login/searchPw";
	}
	
	@RequestMapping(value = "/searchPw", method = RequestMethod.POST)
	public String searchPw2(HttpServletRequest request, Model model) {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String email1=request.getParameter("email1");
		String email2=request.getParameter("email2");
		String email=email1+"@"+email2;
		MemberDTO res=memberDAO.getMember(id);
		if(res!=null){
			if(res.getName().equals(name)){
				if(res.getEmail().equals(email)){
					UUID uuid=UUID.randomUUID();
					String tmp_pw=uuid.toString().substring(24);
					res.setPasswd(tmp_pw);
					int pwres=memberDAO.editPw(res);
					if(pwres==1){
						sendIdentify.sendPasswd(name, id, email, tmp_pw);
						model.addAttribute("msg","등록하신 email로 임시비밀번호를 보냈습니다.");
					}
				}else{
					model.addAttribute("msg","회원님이 등록하신 email 주소와 다릅니다.");
				}
			}else{
				model.addAttribute("msg","해당 정보와 일치하는 회원이 존재하지 않습니다.");
			}
		}else{
			model.addAttribute("msg","해당 정보와 일치하는 회원이 존재하지 않습니다.");
		}
		model.addAttribute("url", "login");
		return "login/message";
	}
	
	@RequestMapping(value = "/searchId", method = RequestMethod.GET)
	public String searchId(HttpServletRequest request) {
		return "login/searchId";
	}
	
	@RequestMapping(value = "/searchId", method = RequestMethod.POST)
	public String searchId2(HttpServletRequest request, Model model) {
		String name=request.getParameter("name");
		String email1=request.getParameter("email1");
		String email2=request.getParameter("email2");
		String email=email1+"@"+email2;
		MemberDTO res=memberDAO.searchId(email);
		if(res!=null){
			if(res.getName().equals(name)){
				sendIdentify.sendId(name, res.getId(), email);
				model.addAttribute("msg","입력하신 이메일로 아이디가 전송되었습니다.");
			}else{
				model.addAttribute("msg","email과 이름이 일치하지 않습니다.");
			}
		}else{
			model.addAttribute("msg","해당 정보와 일치하는 회원이 존재하지 않습니다.");
		}
		model.addAttribute("url", "login");
		return "login/message";
	}
	
}
