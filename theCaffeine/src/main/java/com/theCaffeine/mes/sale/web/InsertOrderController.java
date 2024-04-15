package com.theCaffeine.mes.sale.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.comm.clnt.model.ClientVO;
import com.theCaffeine.mes.sale.model.InsertOrderVO;
import com.theCaffeine.mes.sale.model.OrderDetailVO;
import com.theCaffeine.mes.sale.model.OrderVO;
import com.theCaffeine.mes.sale.model.ProductVO;
import com.theCaffeine.mes.sale.service.InsertOrderService;

/**
 * 주문 등록 페이지
 * @author 신혜원2
 *
 */
@RequestMapping("/sales")
@RestController
public class InsertOrderController {
	
	@Autowired InsertOrderService insertOrderService;
	
	// 거래처 조회 페이지이동
	@GetMapping("/clientList")
	public ModelAndView clientList() { 
		ModelAndView mv = new ModelAndView("sale/clientList");
		return mv;
	}
	
	
	
	
	// 주문 등록 페이지이동
	@GetMapping("/insertOrderPage")
	public ModelAndView insertOrderPage() { 
		ModelAndView mv = new ModelAndView("sale/insertOrder");
		return mv;
	}
	
	// 거래처 검색
	@GetMapping("/searchCliList")
	public List<ClientVO> searchCliList(String searchCli){
		return insertOrderService.getClientList(searchCli);
	}
	
	// 선택할 제품 목록
	@GetMapping("/productList")
	public List<ProductVO> productList(){
		return insertOrderService.productList();
	}
	
	// 주문 등록
	@PostMapping("/ajax/insertOrder")
	public String insertOrder(@RequestBody InsertOrderVO insertOrderVO) {
		int insertOk = insertOrderService.insertOrder(insertOrderVO.getOrderVO(), insertOrderVO.getOrderDetailVO());
		return insertOk==1 ? "ok" : "fail";
	}
}
