package com.theCaffeine.mes.mtrl.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.mtrl.model.MtrlVO;
import com.theCaffeine.mes.mtrl.service.MtrlService;

@RestController
public class MtrlManagementController {

	@Autowired MtrlService mtrlService;
	
	// 자재관리 페이지이동
	@GetMapping("/material/management")
	public ModelAndView list() { 
		ModelAndView mv = new ModelAndView("mtrl/management");
		return mv;
	}
	
	// 자재 등록처리
	@PostMapping("/ajax/mtrl")
	public MtrlVO insertMtrl(@RequestBody MtrlVO vo) {
		mtrlService.insertMtrl(vo);
		return vo;
	}
	
	// 원자재 목록 데이터
	@GetMapping("/ajax/mtrlList")
	public List<MtrlVO> mtrlList(MtrlVO vo) {
		return mtrlService.getMtrlList(vo);
	}
	
	// 부자재 목록 데이터
	@GetMapping("/ajax/mtrlList2")
	public List<MtrlVO> mtrlList2(MtrlVO vo) {
		return mtrlService.getMtrlList2(vo);
	}
	
	// 자재 상세조회
	@GetMapping("/ajax/mtrlInfo/{mtCd}")
	public MtrlVO getMtrlInfo(@PathVariable String mtCd) {
		return mtrlService.getMtrlInfo(mtCd);
	}	
	
	// 자재 수정처리
	@PostMapping("/ajax/mtrlUpdate")
	public MtrlVO updateMtrl(@RequestBody MtrlVO vo) {
		mtrlService.updateMtrl(vo);
		System.out.println(vo);
		return vo;
	}	
	
}
