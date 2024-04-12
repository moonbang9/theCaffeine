package com.theCaffeine.mes.sale.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/sales")
@RestController
public class SendOrderController {

	//출고 관리 페이지 이동
	@GetMapping("/sendOrder")
	public ModelAndView orderList() { 
		ModelAndView mv = new ModelAndView("sale/sendOrder");
		return mv;
	}
}
