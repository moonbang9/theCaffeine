package com.theCaffeine.mes.mtrl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.mtrl.model.MtrlOrderVO;
import com.theCaffeine.mes.mtrl.model.MtrlReturnVO;
import com.theCaffeine.mes.mtrl.model.MtrlStoreVO;
import com.theCaffeine.mes.mtrl.service.MtrlStoringService;

@RestController
public class MtrlStoringController {

	@Autowired MtrlStoringService mtrlStoringService;
	
	// 자재입고관리 페이지이동
	@GetMapping("/material/storing")
	public ModelAndView list() { 
		ModelAndView mv = new ModelAndView("mtrl/storing");
		return mv;
	}
		
	// 검사합격 목록 데이터
	@GetMapping("/ajax/mtrlPassList")
	public List<MtrlOrderVO> getMtrlPassList(MtrlOrderVO vo) {
		return mtrlStoringService.getMtrlPassList(vo);
	}	
	
	// 검사불합격 목록 데이터
	@GetMapping("/ajax/mtrlFailList")
	public List<MtrlOrderVO> getMtrlFailList(MtrlOrderVO vo) {
		return mtrlStoringService.getMtrlFailList(vo);
	}
	
	// 부자재 목록 데이터
	@GetMapping("/ajax/mtrlSubList")
	public List<MtrlOrderVO> getMtrlSubsidiaryList(MtrlOrderVO vo) {
		return mtrlStoringService.getMtrlSubsidiaryList(vo);
	}
		
	// 검사합격 입고처리
	
	
	// 검사 불합격 반품처리
	@PostMapping("/ajax/mtrlReturn")
	public MtrlReturnVO insertMtrlReturn(@RequestBody MtrlReturnVO vo) {
		mtrlStoringService.insertMtrlReturn(vo);
		return vo;
	}
	
	// 원자재 입고처리
	@PostMapping("/ajax/mtrlMainStr")
	public MtrlStoreVO insertMtrlMain(@RequestBody MtrlStoreVO vo) {
		mtrlStoringService.insertMtrlStr(vo);
		return vo;
	}
	
	// 부자재 입고처리
	@PostMapping("/ajax/mtrlSubStr")
	public MtrlStoreVO insertMtrlSub(@RequestBody MtrlStoreVO vo) {
		mtrlStoringService.insertMtrlStr(vo);
		return vo;
	}
}
