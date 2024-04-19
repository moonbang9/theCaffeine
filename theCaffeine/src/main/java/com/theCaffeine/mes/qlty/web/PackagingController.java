package com.theCaffeine.mes.qlty.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.theCaffeine.mes.qlty.model.PackagingVO;
import com.theCaffeine.mes.qlty.service.PackagingService;

@RestController
public class PackagingController {
	@Autowired
	PackagingService packagingService;

	// 포장검사 페이지이동
	@GetMapping("/quality/packaging")
	public ModelAndView packaging() {
		ModelAndView mv = new ModelAndView("qlty/packaging");
		return mv;
	}

	// 포장검사대기 목록
	@GetMapping("/ajax/packagingCheckList")
	public List<PackagingVO> packagingCheckList(PackagingVO vo){
		return packagingService.getPackagingCheckList(vo);
	}	

	// 포장검사결과 등록
	@PostMapping("/ajax/updatePackckRes")
	public int updatePackckRes(@RequestBody PackagingVO vo) {
		return packagingService.updatePackckRes(vo);
	}
	
	// 포장검사결과 실패등록
	@PostMapping("/ajax/updateFailPackckRes")
	public int updateFailPackckRes(@RequestBody PackagingVO vo) {
		return packagingService.updateFailPackckRes(vo);
	}
	
	// 포장검사결과 완제품 등록
	@PostMapping("/ajax/insertPdSTK")
	public int insertPdSTK(@RequestBody PackagingVO vo) {
		return packagingService.insertPdSTK(vo);
	}
	
	// 포장검사완료 목록
	@GetMapping("/ajax/packagingDoneList")
	public List<PackagingVO> packagingDoneList(PackagingVO vo){
		return packagingService.getPackagingDoneList(vo);
	}
	
	// 공정검사완료목록 삭제(DB삭제는 아니고 검사대기 목록으로 이동)
	@PostMapping("/ajax/deletePackagingDoneList")
	public int deletePackckRes(@RequestBody PackagingVO vo) {
		return packagingService.deletePackagingDoneList(vo);
	}

}
