package com.theCaffeine.mes.comm.user.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.comm.user.model.EnterpriseVO;
import com.theCaffeine.mes.comm.user.service.EnterpriseService;






@RestController
public class EnterpriseController {
	
	@Autowired EnterpriseService enterService;

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
			
			// 회원 목록 데이터
			@PostMapping("/memb/getenterprise")
			public List<EnterpriseVO> enterList(@RequestBody EnterpriseVO vo) {
				return enterService.getEnterpriseList(vo);
			}
		//회원가입 등록 처리 
			@PostMapping("/memb/insert") 
			public EnterpriseVO insert(@RequestBody EnterpriseVO vo) {
				enterService.insertEnter(vo);
				return vo;
			}
			// 아이디조회
			@GetMapping("/memb/idchk/{id}")
			public String idCheck(@PathVariable String id) {
				System.out.println(enterService.idChk(id));
				return enterService.idChk(id);
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
		//구독 결제 페이지
					@GetMapping("/memb/pricing")
					public ModelAndView pricing() { 
						ModelAndView mv = new ModelAndView("memb/pricing");
						return mv;
					}
					
		//사원 관리 페이지
					@GetMapping("/memb/addmembers")
					public ModelAndView myMembers() { 
						ModelAndView mv = new ModelAndView("memb/addmembers");
						return mv;
					}
					//정기구독 페이지
					@GetMapping("/memb/monthly")
					public ModelAndView monthlypay() { 
						ModelAndView mv = new ModelAndView("memb/pricing");
						return mv;
					}
		 
}
