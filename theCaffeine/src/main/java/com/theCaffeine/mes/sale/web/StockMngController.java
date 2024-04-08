package com.theCaffeine.mes.sale.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/sales")
@RestController
public class StockMngController {

	// 재고 관리 페이지이동
	@GetMapping("/stockMng")
	public ModelAndView orderList() { 
		ModelAndView mv = new ModelAndView("sale/stockMng");
		return mv;
	}
}
