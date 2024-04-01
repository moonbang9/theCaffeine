package com.theCaffeine.mes.mtrl.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MaterialsManagementController {

	// 자재관리 페이지이동
	@GetMapping("/material/management")
	public ModelAndView list() { 
		ModelAndView mv = new ModelAndView("material/management");
		return mv;
	}
	
}
