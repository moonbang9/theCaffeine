package com.theCaffeine.mes.qlty.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.qlty.model.ProcessVO;
import com.theCaffeine.mes.qlty.service.ProcessService;

@RestController
public class ProcessController {
	@Autowired
	ProcessService processService;

	// 공정검사 페이지이동
	@GetMapping("/quality/process")
	public ModelAndView process() {
		ModelAndView mv = new ModelAndView("qlty/process");
		return mv;
	}

	// 공정검사대기 목록
	@GetMapping("/ajax/processCheckList")
	public List<ProcessVO> processCheckList(ProcessVO vo) {
		return processService.getProcessCheckList(vo);
	}

	// 공정검사결과 등록
	@PostMapping("/ajax/updateMfckRes")
	public int updateMfckRes(@RequestBody ProcessVO vo) {
		return processService.updateMfckRes(vo);
	}

	// 공정검사완료 목록
	@GetMapping("/ajax/processDoneList")
	public List<ProcessVO> processDoneList(ProcessVO vo) {
		return processService.getProcessDoneList(vo);
	}
	
	// 공정검사완료목록 삭제(DB삭제는 아니고 검사대기 목록으로 이동)
	@PostMapping("/ajax/deleteProcessDoneList")
	public int deleteMfckRes(@RequestBody ProcessVO vo) {
		return processService.deleteProcessDoneList(vo);
	}

}
