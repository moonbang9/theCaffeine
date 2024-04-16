package com.theCaffeine.mes.mtrl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.mtrl.model.MtrlSendVO;
import com.theCaffeine.mes.mtrl.service.MtrlSendService;

@RestController
public class MtrlSendController {

	@Autowired MtrlSendService mtrlSendService;
	
	// 자재출고 페이지이동
	@GetMapping("/material/send")
	public ModelAndView moveSend() { 
		ModelAndView mv = new ModelAndView("mtrl/send");
		return mv;
	}
	
	// 자재출고 목록 데이터
	@GetMapping("/ajax/sendList")
	public List<MtrlSendVO> getMtrlSendList() {
		return mtrlSendService.getMtrlSendList();
	}
	
	// 자재 출고처리
	@PostMapping("/ajax/mtrlMainSend")
	public MtrlSendVO insertMtrlSend(@RequestBody MtrlSendVO vo) {
		mtrlSendService.insertMtrlSend(vo);
		return vo;
	}
	
}
