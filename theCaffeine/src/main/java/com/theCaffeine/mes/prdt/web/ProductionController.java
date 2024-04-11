package com.theCaffeine.mes.prdt.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.prdt.model.FailPlanVO;
import com.theCaffeine.mes.prdt.model.InstVO;
import com.theCaffeine.mes.prdt.model.MtrlPlanVO;
import com.theCaffeine.mes.prdt.model.PlanOrderDetailVO;
import com.theCaffeine.mes.prdt.model.PlanResistVO;
import com.theCaffeine.mes.prdt.model.PlanVO;
import com.theCaffeine.mes.prdt.model.SafePlanVO;
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
	
	//생산 주간 계획 상세 목록 데이터
	@GetMapping("/ajax/qnttMtrlList/{pdtPlanCd}")
	public List<MtrlPlanVO> getQnttMtrlList(@PathVariable String pdtPlanCd) {
		return prdtService.getQnttMtrlList(pdtPlanCd);
	}
	
	//생산 주간 계획 등록 페이지이동
	/*@GetMapping("/production/planRegist")
	public ModelAndView planRegist() { 
		ModelAndView mv = new ModelAndView("prdt/prdtPlanRegist");
		return mv;
	}*/
	
	//생산 주간 계획 등록 데이터 포함 이동 //수정
	@GetMapping(value = "/production/planRegist")
	public ModelAndView planRegist(String pdtPlanCd) { 
		ModelAndView mv = new ModelAndView("prdt/prdtPlanRegist");
		if(pdtPlanCd != null) {
			List<PlanVO> list = prdtService.getPlanDetailList(pdtPlanCd);
			PlanVO vo = prdtService.getPlanInfo(pdtPlanCd);
			mv.addObject("list",list);
			mv.addObject("vo",vo);
		}
		return mv;
	}
	
	//상세 주문목록 데이터
	@PostMapping("/ajax/planOrderDetail")
	public List<PlanOrderDetailVO> planOrderDetail(@RequestBody PlanOrderDetailVO vo) {
		return prdtService.getDetailOrderList(vo);
	}
	
	//상세 주문목록 데이터
	@GetMapping("/ajax/planSafeList")
	public List<SafePlanVO> planSafeList() {
		return prdtService.getSafeInventoryList();
	}
	
	//실패 수량 파악 데이터
	@GetMapping("/ajax/failProdList")
	public List<FailPlanVO> failProdList() {
		return prdtService.getFailProdList();
	}
	
	//전주 생산 수량 파악 데이터
	@GetMapping("/ajax/successProdList")
	public List<FailPlanVO> successProdList() {
		return prdtService.getSuccessProdList();
	}
	
	//선택안되는 일자
	@GetMapping("/ajax/noDate")
	public FailPlanVO notDate() {
		return prdtService.getNotDate();
	}
	
	//주간계획등록 기본 양식
	@GetMapping("/ajax/basicPlan")
	public List<PlanVO> basicPlanList() {
		return prdtService.getBasicPlanList();
	}
	
	//box -> kg 단위변경 
	@GetMapping("/ajax/planConsum")
	public List<FailPlanVO> planConsum() {
		return prdtService.getPlanConsum();
	}
	
	//계획 등록
	@PostMapping("/ajax/planResist")
	public String planResist(@RequestBody PlanResistVO vo) {
		if(prdtService.planResist(vo) > 0) {
			System.out.println("등록성공");
		}
		return "ok";
	}
	
	//계획 수정
	@PostMapping("/ajax/planUpdate")
	public String planUpdate(@RequestBody PlanResistVO vo) {
		if(prdtService.planUpdate(vo) > 0) {
			System.out.println("등록성공");
		}
		return "ok";
	}
	//계획 삭제
	@GetMapping("/ajax/planDelete/{pdtPlanCd}")
	public String planDelete(@PathVariable String pdtPlanCd) {
		if(prdtService.planDelete(pdtPlanCd) > 0) {
			System.out.println("등록성공");
		}
		return "ok";
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
	
	//지시목록 데이터
	@GetMapping("/ajax/instList")
	public List<InstVO> instList() {
		return prdtService.getInstList();
	}
	
	//상세지시목록 데이터
	@GetMapping("/ajax/instDetailList/{pdtInstNo}")
	public List<InstVO> instDetailList(@PathVariable Integer pdtInstNo) {
		return prdtService.getInstDetailList(pdtInstNo);
	}
	
	//지시 삭제
	@GetMapping("/ajax/instDetailDel/{pdtInstNo}")
	public String instDelete(@PathVariable Integer pdtInstNo) {
		if(prdtService.instDelete(pdtInstNo) > 0) {
			System.out.println("삭제성공");
		}
		return "ok";
	}
	
	//지시상세선택 삭제
	@GetMapping("/ajax/instDetailDel2/{pdtInstDetailNo}")
	public String instDetailDelete(@PathVariable Integer pdtInstDetailNo) {
		if(prdtService.instDetailDelete(pdtInstDetailNo) > 0) {
			System.out.println("삭제성공");
		}
		return "ok";
	}
	
	//계획코드 리스트
	@GetMapping("/ajax/planCdList")
	public List<PlanVO> planCdList() {
		return prdtService.getPlanCdList();
	}
}
