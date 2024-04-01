package com.theCaffeine.mes.fclt.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FacilityController {

	// 리스트 페이지이동
		@GetMapping("/fclt/facilitylist")
		public ModelAndView facility() { 
			ModelAndView mv = new ModelAndView("fclt/facilitylist");
			return mv;
		}
	// 비가동 페이지이동
				@GetMapping("/fclt/nonop")
				public ModelAndView nonOpe() { 
					ModelAndView mv = new ModelAndView("fclt/nonop");
					return mv;
				}
	// 점검 페이지이동
				@GetMapping("/fclt/inspection")
				public ModelAndView inspection() { 
					ModelAndView mv = new ModelAndView("fclt/inspection");
					return mv;
				}
}
