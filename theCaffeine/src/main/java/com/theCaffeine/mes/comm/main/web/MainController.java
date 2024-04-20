package com.theCaffeine.mes.comm.main.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.comm.main.model.CodeDetailVO;
import com.theCaffeine.mes.comm.main.service.MainService;


@RestController
public class MainController {

	@Autowired MainService mainService;
	
	// 메인 페이지이동
	@GetMapping("/")
	public ModelAndView moveOrder() { 
		ModelAndView mv = new ModelAndView("layout/index");
		return mv;
	}
	
	// 메인 페이지이동
		@GetMapping("/main")
		public ModelAndView mainpage() { 
			ModelAndView mv = new ModelAndView("layout/mainpage");
			return mv;
		}
	
	// 공통코드 상세목록 데이터
	@GetMapping("/ajax/codeDetailList/{wkCdNo}")
	public List<CodeDetailVO> getCodeDetailList(@PathVariable String wkCdNo) {
		return mainService.getCodeDetailList(wkCdNo);
	}
	
}
