package com.theCaffeine.mes.prdt.service;

import java.util.List;

import com.theCaffeine.mes.prdt.model.FailPlanVO;
import com.theCaffeine.mes.prdt.model.InstVO;
import com.theCaffeine.mes.prdt.model.MtrlPlanVO;
import com.theCaffeine.mes.prdt.model.PlanOrderDetailVO;
import com.theCaffeine.mes.prdt.model.PlanResistVO;
import com.theCaffeine.mes.prdt.model.PlanVO;
import com.theCaffeine.mes.prdt.model.SafePlanVO;

public interface PrdtService {
	List<PlanVO> getPlanList(PlanVO vo); //주간 생산계획조회
	PlanVO getPlanInfo(String pdtPlanCd); // 생산계획 단건 조회
	List<PlanVO> getPlanDetailList(String pdtPlanCd); //주간 생산상세 계획조회
	List<MtrlPlanVO> getQnttMtrlList(String pdtPlanCd); //주간 발주계획
	List<PlanOrderDetailVO> getDetailOrderList(PlanOrderDetailVO vo); //상세 주문조회
	List<SafePlanVO> getSafeInventoryList(); //안전재고량 조회
	List<FailPlanVO> getFailProdList(); //실패수량 조회
	List<FailPlanVO> getSuccessProdList(); //전주생산수량 파악
	FailPlanVO getNotDate(); //선택안되는 일자
	List<PlanVO> getBasicPlanList(); //주간계획등록 기본 양식
	List<FailPlanVO> getPlanConsum(); // box -> kg 단위변경 
	int planResist(PlanResistVO vo); //계획 등록
	int planUpdate(PlanResistVO vo); //계획 등록
	int planDelete(String pdtPlanCd); //계획 삭제
	List<InstVO> getInstList(); //일별 지시조회
	List<InstVO> getInstDetailList(Integer pdtInstNo); //일별 지시상세조회
	int instDelete(Integer pdtInstNo); //지시 삭제
	int instDetailDelete(Integer pdtInstDetailNo); //지시상세 삭제
	List<PlanVO> getPlanCdList(); // 계획코드 리스트
}
