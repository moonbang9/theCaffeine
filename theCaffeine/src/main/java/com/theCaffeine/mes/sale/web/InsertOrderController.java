package com.theCaffeine.mes.sale.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.comm.clnt.model.ClientVO;
import com.theCaffeine.mes.sale.model.ProductVO;
import com.theCaffeine.mes.sale.service.InsertOrderService;


@RestController
public class InsertOrderController {
	
	@Autowired InsertOrderService insertOrderService;
	
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
	
	@GetMapping("/sales/searchCliList")
	public List<ClientVO> searchCliList(String searchCli){
		return insertOrderService.getClientList(searchCli);
	}
	
	@GetMapping("/sales/productList")
	public List<ProductVO> productList(){
		return insertOrderService.productList();
	}
}
