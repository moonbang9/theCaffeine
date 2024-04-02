package com.theCaffeine.mes.sale.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class InsertOrderController {
	
	// 거래처 조회 페이지이동
	@GetMapping("/sales/clientList")
	public ModelAndView clientList() { 
		ModelAndView mv = new ModelAndView("sale/clientList");
		return mv;
	}
	
	
	// 주문 조회 페이지이동
	@GetMapping("/sales/orderList")
	public ModelAndView orderList() { 
		ModelAndView mv = new ModelAndView("sale/orderList");
		return mv;
	}
	
	// 주문 등록 페이지이동
	@GetMapping("/sales/insertOrder")
	public ModelAndView insertOrder() { 
		ModelAndView mv = new ModelAndView("sale/insertOrder");
		return mv;
	}
	
	// 주문 등록 페이지에서 거래처 목록 불러오기
//	@GetMapping("/ajax/clientList")
//	public Map<String, Object> clientList(ClientVO vo, SearchVO svo, Paging pvo) {
//		svo.setStart(pvo.getFirst());
//		svo.setEnd(pvo.getLast());
//		Map<String, Object> map = service.getEmpList(vo, svo);
//		pvo.setTotalRecord((Long)map.get("count"));
//		map.put("paging", pvo);
//		
//		return map;
//	}
}
