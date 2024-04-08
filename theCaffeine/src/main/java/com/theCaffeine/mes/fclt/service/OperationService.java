package com.theCaffeine.mes.fclt.service;

import java.util.List;

import com.theCaffeine.mes.fclt.model.OperationVO;

public interface OperationService {
	int insertOprt(OperationVO vo);  //비가동 등록
	List<OperationVO> getOprtList(); //비가동 목록
	OperationVO getOprtInfo(String nonopCd);// 단건 조회 
	int deleteOprt (String nonopCd); //단건 삭제
	int updateOprt(OperationVO vo); //단건 수정
	int updateFnTime (OperationVO vo); //비가동 종료 시간 수정
}
