package com.theCaffeine.mes.sale.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.sale.model.OrderDetailVO;
import com.theCaffeine.mes.sale.model.OrderMngVO;
import com.theCaffeine.mes.sale.service.SendOrderService;

@RequestMapping("/sales")
@RestController
public class SendOrderController {
	
	@Autowired SendOrderService sendOrderService;

	//출고 관리 페이지 이동
	@GetMapping("/sendOrder")
	public ModelAndView orderList() { 
		ModelAndView mv = new ModelAndView("sale/sendOrder");
		return mv;
	}	
	// 다중 조건 주문 검색
//	@PostMapping("/ajax/sendSearch")
//	public String getOrderList(@RequestBody OrderMngVO vo) {
//		System.out.println("브이오다"+ vo);
//		return "ok";
//	}
	// 미출고 목록 조회
	@PostMapping("/ajax/notSendList")
	public List<OrderMngVO> notSendList(@RequestBody OrderMngVO vo){
		System.out.println("미출고 목록 조건" + vo);
		return sendOrderService.notSendList(vo);
	}
	// 출고된 목록 조회
	@PostMapping("/ajax/sentList")
	public List<OrderMngVO> sentList(@RequestBody OrderMngVO vo){
		System.out.println("출고 처리된 목록 조건" + vo);
		return sendOrderService.sentList(vo);
	}
	@PostMapping("/ajax/sendOrder")
	public int sendOrder(@RequestBody OrderDetailVO vo) {
		System.out.println("출고 처리");
		return sendOrderService.sendOrder(vo);
	}
}
