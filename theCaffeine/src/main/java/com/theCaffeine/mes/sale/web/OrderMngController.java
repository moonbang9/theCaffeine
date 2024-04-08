package com.theCaffeine.mes.sale.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.sale.model.OrderMngVO;
import com.theCaffeine.mes.sale.service.OrderMngService;

@RequestMapping("/sales")
@RestController
public class OrderMngController {

	@Autowired OrderMngService orderMngService;
	
	// 주문 조회 페이지이동
		@GetMapping("/orderMng")
		public ModelAndView orderList() { 
			ModelAndView mv = new ModelAndView("sale/orderMng");
			return mv;
		}
		
	// 다중 조건 주문 검색
		@PostMapping("/ajax/orderMng")
		public List<OrderMngVO> getOrderList(@RequestBody OrderMngVO vo) {
			System.out.println("브이오다"+ vo);
			return orderMngService.getOrderList(vo);
		}
}
