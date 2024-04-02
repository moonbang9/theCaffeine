package com.theCaffeine.mes.fclt.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.fclt.model.InspectionVO;
import com.theCaffeine.mes.fclt.service.FcltService;
import com.theCaffeine.mes.fclt.service.InspectionService;

@RestController
public class InspectionController {
	
	@Autowired InspectionService inspService;
	@Autowired FcltService fcltService; 

	// 점검 목록 페이지이동
	@GetMapping("/fclt/inspection")
	public ModelAndView inspection() { 
		
		ModelAndView mv = new ModelAndView("fclt/inspection");
		mv.addObject("fcltNames",fcltService.getFcltList());
		return mv;
	}
		
		//등록처리
		@PostMapping("/fclt/insertinsp") 
		public InspectionVO insert(@RequestBody InspectionVO vo) {
			//System.out.println(vo);
			inspService.insertInspection(vo);
			return vo;
		}
		//단건조회 
		@GetMapping("/fclt/inspection/{insCd}") 
		public InspectionVO info(@PathVariable String insCd) {
			return inspService.getInspInfo(insCd);
		}
		
		//점검 정보 수정
		 @GetMapping("/fclt/updateinsp/{insCd}") //<!-- localhost:8091/update/100 -->
		 public String update(@PathVariable String insCd) {
			 System.out.println(insCd);
			 return "inspection";
		 }
		 
		 //설비 삭제
		 @GetMapping("/fclt/deleteinsp") // <!-- localhost:8091/delete?employeeId=100&name=xxx -->
		 public String delete(String insCd) {
			 inspService.deleteInspection(insCd);
			 System.out.println(insCd);
			 return "inspection"; 
		 }
		 
		
		
	
	
}
