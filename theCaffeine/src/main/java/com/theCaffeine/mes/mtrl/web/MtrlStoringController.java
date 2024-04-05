package com.theCaffeine.mes.mtrl.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MtrlStoringController {

	// 자재입고관리 페이지이동
		@GetMapping("/material/storing")
		public ModelAndView list() { 
			ModelAndView mv = new ModelAndView("mtrl/storing");
			return mv;
		}
}
