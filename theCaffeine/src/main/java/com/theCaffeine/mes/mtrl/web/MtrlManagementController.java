package com.theCaffeine.mes.mtrl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
