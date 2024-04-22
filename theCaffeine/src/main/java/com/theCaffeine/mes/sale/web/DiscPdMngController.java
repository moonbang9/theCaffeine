package com.theCaffeine.mes.sale.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.sale.model.DiscPdVO;
import com.theCaffeine.mes.sale.service.DiscPdService;
@RequestMapping("/sales")
@RestController
public class DiscPdMngController {

	@Autowired
	DiscPdService discPdService;
	
	// 제품 폐기 페이지이동
	@GetMapping("/discardProduct")
	public ModelAndView clientList() { 
		ModelAndView mv = new ModelAndView("sale/discPdMng");
		return mv;
	}
	
	// 다중 조건 폐기 목록 검색
	@PostMapping("/ajax/discPdList")
	public List<DiscPdVO> discPdList(@RequestBody DiscPdVO vo) {
		System.out.println("브이오다" + vo);
		return discPdService.discPdList(vo);
	}
	// 다중 조건 폐기 차트
	@PostMapping("/ajax/discPdChart")
	public List<DiscPdVO> discPdChart(@RequestBody DiscPdVO vo) {
		System.out.println("브이오다" + vo);
		return discPdService.discPdChart(vo);
	}
}
