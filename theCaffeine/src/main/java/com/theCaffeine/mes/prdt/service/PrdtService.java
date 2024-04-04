package com.theCaffeine.mes.prdt.service;

import java.util.List;

import com.theCaffeine.mes.prdt.model.MtrlPlanVO;
import com.theCaffeine.mes.prdt.model.PlanVO;

public interface PrdtService {
	List<PlanVO> getPlanList(PlanVO vo); //주간 생산계획조회
	List<PlanVO> getPlanDetailList(String pdtPlanCd); //주간 생산상세 계획조회
	List<MtrlPlanVO> getQnttMtrlList(String pdtPlanCd); //주간 발주계획
}
