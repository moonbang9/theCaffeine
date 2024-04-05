package com.theCaffeine.mes.sale.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/sales")
@RestController
public class OrderMngController {

	// 주문 조회 페이지이동
		@GetMapping("/orderMng")
		public ModelAndView orderList() { 
			ModelAndView mv = new ModelAndView("sale/orderMng");
			return mv;
		}
}
