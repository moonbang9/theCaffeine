package com.theCaffeine.mes.qlty.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.qlty.model.QltyVO;
import com.theCaffeine.mes.qlty.service.QltyService;

@RestController
public class QltyController {
	
	@Autowired QltyService qltyService;

	// 자재검사 페이지이동
	@GetMapping("/quality/material")
	public ModelAndView material() {
		ModelAndView mv = new ModelAndView("qlty/material");
		return mv;
	}
	
	// 자재검사대기 목록 
	@GetMapping("/ajax/mtrlCheckList")
	public List<QltyVO> qltyList(QltyVO vo){
		return qltyService.getMtrlCheckList(vo);
	}

	// 공정검사 페이지이동
	@GetMapping("/quality/process")
	public ModelAndView process() {
		ModelAndView mv = new ModelAndView("qlty/process");
		return mv;
	}

	// 포장검사 페이지이동
	@GetMapping("/quality/packaging")
	public ModelAndView packaging() {
		ModelAndView mv = new ModelAndView("qlty/packaging");
		return mv;
	}

	// 검사조회 페이지이동
	@GetMapping("/quality/lookup")
	public ModelAndView lookup() {
		ModelAndView mv = new ModelAndView("qlty/lookup");
		return mv;
	}

	// 검사기준관리 페이지이동
	@GetMapping("/quality/standard")
	public ModelAndView standard() {
		ModelAndView mv = new ModelAndView("qlty/standard");
		return mv;
	}

}
