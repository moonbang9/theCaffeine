package com.theCaffeine.mes.qlty.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class QltyController {

	// 자재검사 페이지이동
	@GetMapping("/quality/material")
	public ModelAndView material() {
		ModelAndView mv = new ModelAndView("qlty/material");
		return mv;
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
