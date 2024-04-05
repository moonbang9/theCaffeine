package com.theCaffeine.mes.fclt.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.fclt.model.FcltVO;
import com.theCaffeine.mes.fclt.model.OperationVO;
import com.theCaffeine.mes.fclt.service.FcltService;
import com.theCaffeine.mes.fclt.service.OperationService;

@RestController
public class OperationController {
	@Autowired OperationService oprtService;
	@Autowired
	FcltService fcltService;

	// 비가동 페이지이동
		@GetMapping("/fclt/operationlist")
		public ModelAndView facility(FcltVO vo) { 
			ModelAndView mv = new ModelAndView("fclt/operationlist");
			mv.addObject("nonopFcltNames",fcltService.getFcltList(vo));
			return mv;
		}
		
		// 비가동 목록 데이터
		@GetMapping("/fclt/getoperation")
		public List<OperationVO> oprtList(OperationVO vo) {
			return oprtService.getOprtList();
		}
		
		//등록처리
		@PostMapping("/fclt/insertoprt") //요청 url -> empMng.html 에 등록
		public OperationVO insert(@RequestBody OperationVO vo) {
			oprtService.insertOprt(vo);
			return vo;
		}
		//단건조회 
		@GetMapping("/fclt/operationlist/{nonopCd}") //요청 url -> empMng.html 에 등록
		public OperationVO info(@PathVariable String nonopCd) {
			return oprtService.getOprtInfo(nonopCd);
		}
		
		// 비가동 수정
		@PostMapping("/fclt/updateoprt")
		public OperationVO updateMtrl(@RequestBody OperationVO vo) {
			oprtService.updateOprt(vo);
			System.out.println(vo);
			return vo;
		}	
		 
		 //비가동 삭제
		 @GetMapping("/fclt/deleteoprt") // <!-- localhost:8091/delete?employeeId=100&name=xxx -->
		 public String delete(String nonopCd) {
			 oprtService.deleteOprt(nonopCd);
			 System.out.println(nonopCd);
			 return "operationlist"; 
		 }
		 
}
