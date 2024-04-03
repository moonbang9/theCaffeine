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
import com.theCaffeine.mes.fclt.service.FcltService;

@RestController
public class FacilityController {
	@Autowired FcltService fcltService;

	// 설비 페이지이동
		@GetMapping("/fclt/facilitylist")
		public ModelAndView facility() { 
			ModelAndView mv = new ModelAndView("fclt/facilitylist");
			return mv;
		}
		
		// 원자재 목록 데이터
		@GetMapping("/fclt/getfacility")
		public List<FcltVO> fcltList(FcltVO vo) {
			return fcltService.getFcltList(vo);
		}
		
		//등록처리
		@PostMapping("/fclt/insert") //요청 url -> empMng.html 에 등록
		public FcltVO insert(@RequestBody FcltVO vo) {
			fcltService.insertFclt(vo);
			return vo;
		}
		//단건조회 
		@GetMapping("/fclt/facilitylist/{fcName}") //요청 url -> empMng.html 에 등록
		public FcltVO info(@PathVariable String fcName) {
			return fcltService.getFcltInfo(fcName);
		}
		
		// 설비 수정
		@PostMapping("/fclt/update")
		public FcltVO updateMtrl(@RequestBody FcltVO vo) {
			fcltService.updateFclt(vo);
			System.out.println(vo);
			return vo;
		}	
		 
		 //설비 삭제
		 @GetMapping("/fclt/delete") // <!-- localhost:8091/delete?employeeId=100&name=xxx -->
		 public String delete(int employeeId, String fcCd) {
			 fcltService.deleteFclt(fcCd);
			 System.out.println(fcCd);
			 return "facilitylist"; 
		 }
		 
}
