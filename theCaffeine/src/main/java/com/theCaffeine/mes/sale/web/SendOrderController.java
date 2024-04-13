package com.theCaffeine.mes.sale.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.sale.model.OrderMngVO;

@RequestMapping("/sales")
@RestController
public class SendOrderController {

	//출고 관리 페이지 이동
	@GetMapping("/sendOrder")
	public ModelAndView orderList() { 
		ModelAndView mv = new ModelAndView("sale/sendOrder");
		return mv;
	}
	
	// 다중 조건 주문 검색
	@PostMapping("/ajax/sendSearch")
	public String getOrderList(@RequestBody OrderMngVO vo) {
		System.out.println("브이오다"+ vo);
		return "ok";
	}
}
