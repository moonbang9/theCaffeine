package com.theCaffeine.mes.sale.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping("/sales")
@RestController
public class DiscPdMngController {

	
	
	// 제품 폐기 페이지이동
		@GetMapping("/discardProduct")
		public ModelAndView clientList() { 
			ModelAndView mv = new ModelAndView("sale/discPdMng");
			return mv;
		}
}
