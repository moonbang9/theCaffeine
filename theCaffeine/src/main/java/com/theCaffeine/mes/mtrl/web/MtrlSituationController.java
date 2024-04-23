package com.theCaffeine.mes.mtrl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.mtrl.model.MtrlSituationVO;
import com.theCaffeine.mes.mtrl.service.MtrlSituationService;

@RestController
public class MtrlSituationController {

	@Autowired MtrlSituationService mtrlSituationService;
	
	// 자재현황조회 페이지이동
	@GetMapping("/situation")
	public ModelAndView moveStockList() { 
		ModelAndView mv = new ModelAndView("mtrl/situation");
		return mv;
	}
	
	// 입고 목록 데이터
	@PostMapping("/ajax/storeList")
	public List<MtrlSituationVO> getMtrlStoreList(@RequestBody MtrlSituationVO vo) {
		return mtrlSituationService.getMtrlStoreList(vo);
	}
	
	// 출고 목록 데이터
	@PostMapping("/ajax/sendList")
	public List<MtrlSituationVO> getMtrlSendList(@RequestBody MtrlSituationVO vo) {
		return mtrlSituationService.getMtrlSendList(vo);
	}
	
	// 반품 목록 데이터
	@PostMapping("/ajax/returnList")
	public List<MtrlSituationVO> getMtrlReturnList(@RequestBody MtrlSituationVO vo) {
		return mtrlSituationService.getMtrlReturnList(vo);
	}
	
}
