package com.theCaffeine.mes.mtrl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.mtrl.model.MtrlStkListVO;
import com.theCaffeine.mes.mtrl.service.MtrlStoringService;

@RestController
public class MtrlStockListController {

	@Autowired MtrlStoringService mtrlStoringService;
	
	// 자재재고조회 페이지이동
	@GetMapping("/mtrlStocklist")
	public ModelAndView moveStockList() { 
		ModelAndView mv = new ModelAndView("mtrl/stocklist");
		return mv;
	}
	
	// 자재재고 목록 데이터
	@PostMapping("/ajax/stockList")
	public List<MtrlStkListVO> getMtrlStockList(@RequestBody MtrlStkListVO vo) {
		return mtrlStoringService.getMtrlStockList(vo);
	}	
	
	// ROT별 재고 목록 데이터
	@GetMapping("/ajax/lotStockList/{mtCd}")
	public List<MtrlStkListVO> getLotStockList(@PathVariable String mtCd) {
		return mtrlStoringService.getRotStockList(mtCd);
	}	
}
