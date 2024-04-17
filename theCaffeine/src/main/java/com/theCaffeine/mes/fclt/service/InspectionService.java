package com.theCaffeine.mes.fclt.service;

import java.util.List;

import com.theCaffeine.mes.fclt.model.InspectionVO;

public interface InspectionService {
	int insertInspection(InspectionVO vo);  //점검 등록
	List<InspectionVO> getInspList(InspectionVO vo); //점검 목록
	InspectionVO getInspInfo(String insCd);// 단건 조회 
	int deleteInspection (String insCd); //단건 삭제
	int updateInspection(InspectionVO vo); //단건 수정
}
