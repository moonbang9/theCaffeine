package com.theCaffeine.mes.mtrl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.mtrl.model.MtrlOrderVO;
import com.theCaffeine.mes.mtrl.service.MtrlOrderService;

@RestController
public class MtrlQualityController {

	@Autowired MtrlOrderService mtrlOrderService;
	
	// 자재검사관리 페이지이동
	@GetMapping("/material/quality")
	public ModelAndView list() { 
		ModelAndView mv = new ModelAndView("mtrl/quality");
		return mv;
	}
	
	// 자재검사대기 목록 데이터
	@GetMapping("/ajax/qualityList")
	public List<MtrlOrderVO> orderList(MtrlOrderVO vo) {
		return mtrlOrderService.getMtrlqualList(vo);
	}
	
	// 자재검사 요청처리
	@PostMapping("/ajax/mtrlQuality")
	public MtrlOrderVO insertMtrl(@RequestBody MtrlOrderVO vo) {
		mtrlOrderService.insertMtrlQuality(vo);
		return vo;
	}
}
