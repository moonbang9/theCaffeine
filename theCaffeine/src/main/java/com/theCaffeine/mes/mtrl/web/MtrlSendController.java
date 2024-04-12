package com.theCaffeine.mes.mtrl.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MtrlSendController {

	// 자재출고 페이지이동
	@GetMapping("/material/send")
	public ModelAndView moveSend() { 
		ModelAndView mv = new ModelAndView("mtrl/send");
		return mv;
	}
	
}
