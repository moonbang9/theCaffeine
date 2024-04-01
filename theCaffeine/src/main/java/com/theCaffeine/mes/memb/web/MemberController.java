package com.theCaffeine.mes.memb.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MemberController {

	// 로그인 페이지이동
		@GetMapping("/memb/login")
		public ModelAndView login() { 
			ModelAndView mv = new ModelAndView("memb/login");
			return mv;
		}
	//회원가입 페이지 이동
		@GetMapping("/memb/register")
		public ModelAndView register() { 
			ModelAndView mv = new ModelAndView("memb/register");
			return mv;
		}
	//아이디 찾기 이동
		@GetMapping("/memb/findid")
		public ModelAndView findId() { 
			ModelAndView mv = new ModelAndView("memb/findid");
			return mv;
		}
	//아이디 변경 페이지
		@GetMapping("/memb/changeid")
		public ModelAndView changeId() { 
			ModelAndView mv = new ModelAndView("memb/changeid");
			return mv;
		}
		
	//비밀번호 찾기 이동
				@GetMapping("/memb/findpw")
				public ModelAndView findPw() { 
					ModelAndView mv = new ModelAndView("memb/findpw");
					return mv;
				}
	//비밀번호 변경 페이지
				@GetMapping("/memb/changepw")
				public ModelAndView changePw() { 
					ModelAndView mv = new ModelAndView("memb/changepw");
					return mv;
				}
	//내 정보 페이지
				@GetMapping("/memb/myinfo")
				public ModelAndView myInfo() { 
					ModelAndView mv = new ModelAndView("memb/myinfo");
					return mv;
				}
	
}
