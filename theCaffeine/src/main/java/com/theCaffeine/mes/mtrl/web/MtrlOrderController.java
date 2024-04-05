package com.theCaffeine.mes.mtrl.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.mtrl.model.MtrlOrderVO;
import com.theCaffeine.mes.mtrl.service.MtrlOrderService;

@RestController
public class MtrlOrderController {

	@Autowired MtrlOrderService mtrlOrderService;
	
	// 자재발주 페이지이동
	@GetMapping("/material/order")
	public ModelAndView list() { 
		ModelAndView mv = new ModelAndView("mtrl/order");
		return mv;
	}
	
	// 자재발주요청 목록 데이터
	@GetMapping("/ajax/orderList")
	public List<MtrlOrderVO> orderList(MtrlOrderVO vo) {
		return mtrlOrderService.getMtrlOrderList(vo);
	}
	
	// 거래처별 자재목록 데이터
	@GetMapping("/ajax/cliMtrlList/{cliCd}")
	public List<MtrlOrderVO> getMtrlList(@PathVariable String cliCd) {
		return mtrlOrderService.getMtrlList(cliCd);
	}
	
	// 자재발주요청 추가
	@PostMapping("/ajax/mtrlOrder")
	public MtrlOrderVO insertMtrl(@RequestBody MtrlOrderVO vo) {
		mtrlOrderService.insertMtrlOrder(vo);
		return vo;
	}
	
	// 자재발주요청 삭제
	@PostMapping("/ajax/deleteMtrlOrder")
	public String deleteMtrlOrder(@RequestBody String mtPlaceodCd) {
		mtrlOrderService.deleteMtrlOrder(mtPlaceodCd);
		return "OK";
	}
	
	// 자재 발주처리
	@PostMapping("/ajax/updateMtrlOrder")
	public MtrlOrderVO updateMtrlOrder(@RequestBody MtrlOrderVO vo) {
		mtrlOrderService.updateMtrlOrder(vo);
		System.out.println(vo);
		return vo;
	}
	
	// 거래처 목록 데이터
	@GetMapping("/ajax/mtrlCliList")
	public List<MtrlOrderVO> getMtrlCliList() {
		return mtrlOrderService.getMtrlCliList();
	}
		
}
