package com.theCaffeine.mes.prdt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.prdt.model.PlanVO;
import com.theCaffeine.mes.prdt.service.PrdtService;

@RestController
public class ProductionController {
	
	@Autowired PrdtService prdtService;
	
	//생산 주간 계획 페이지이동
	@GetMapping("/production/plan")
	public ModelAndView planList() { 
		ModelAndView mv = new ModelAndView("prdt/prdtPlan");
		return mv;
	}
	
	//생산 주간 계획 목록 데이터
	@GetMapping("/ajax/planList")
	public List<PlanVO> planList(PlanVO vo){
		return prdtService.getPlanList(vo);
	}
	
	//생산 주간 계획 상세 목록 데이터
	@GetMapping("/ajax/planDetailList/{pdtPlanCd}")
	public List<PlanVO> getPlanDetailList(@PathVariable String pdtPlanCd) {
		return prdtService.getPlanDetailList(pdtPlanCd);
	}
	
	//생산 주간 계획 등록 페이지이동
	@GetMapping("/production/planRegist")
	public ModelAndView planRegist() { 
		ModelAndView mv = new ModelAndView("prdt/prdtPlanRegist");
		return mv;
	}
	
	//연간 생산 현황 페이지이동
	@GetMapping("/production/prdtYearState")
	public ModelAndView prdtYearStateList() { 
		ModelAndView mv = new ModelAndView("prdt/prdtYearState");
		return mv;
	}
	
	//생산 지시 관리 목록 페이지이동
	@GetMapping("/production/prdtInst")
	public ModelAndView prdtInstList() { 
		ModelAndView mv = new ModelAndView("prdt/prdtInst");
		return mv;
	}
	
	//생산 지시 관리 등록 페이지이동
	@GetMapping("/production/prdtInstRegist")
	public ModelAndView prdtInstRegist() { 
		ModelAndView mv = new ModelAndView("prdt/prdtInstRegist");
		return mv;
	}
	
	//생산 내역 조회 페이지이동
	@GetMapping("/production/prdtHistList")
	public ModelAndView prdtHistList() { 
		ModelAndView mv = new ModelAndView("prdt/prdtHistList");
		return mv;
	}
	
	//생산 실적 조회 페이지이동
	@GetMapping("/production/prdtPerformanceList")
	public ModelAndView prdtPerformanceList() { 
		ModelAndView mv = new ModelAndView("prdt/prdtPerformanceList");
		return mv;
	}
	
	
}
