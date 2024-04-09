package com.theCaffeine.mes.sale.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.sale.model.LotStockVO;
import com.theCaffeine.mes.sale.model.PdStockVO;
import com.theCaffeine.mes.sale.service.PdStockService;

@RequestMapping("/sales")
@RestController
public class PdStockMngController {

	@Autowired PdStockService pdStockService;
	
	// 재고 관리 페이지이동
	@GetMapping("/stockMng")
	public ModelAndView orderList() { 
		ModelAndView mv = new ModelAndView("sale/stockMng");
		return mv;
	}
	
	// 제품별 재고조회
	@GetMapping("/pdStockList")
	public List<PdStockVO> pdStockList(){
		return pdStockService.pdStockList();
	}
	
	// LOT별 조건검색 재고조회
	@PostMapping("/lotStockList")
	public List<LotStockVO> lotStockList(@RequestBody LotStockVO vo){
		System.out.println("LotStockVO입니다" + vo);
		return pdStockService.lotStockList(vo);
	}
	
	
}
