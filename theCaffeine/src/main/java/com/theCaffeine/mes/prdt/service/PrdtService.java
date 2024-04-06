package com.theCaffeine.mes.prdt.service;

import java.util.List;

import com.theCaffeine.mes.prdt.model.FailPlanVO;
import com.theCaffeine.mes.prdt.model.MtrlPlanVO;
import com.theCaffeine.mes.prdt.model.PlanOrderDetailVO;
import com.theCaffeine.mes.prdt.model.PlanVO;
import com.theCaffeine.mes.prdt.model.SafePlanVO;

public interface PrdtService {
	List<PlanVO> getPlanList(PlanVO vo); //주간 생산계획조회
	List<PlanVO> getPlanDetailList(String pdtPlanCd); //주간 생산상세 계획조회
	List<MtrlPlanVO> getQnttMtrlList(String pdtPlanCd); //주간 발주계획
	List<PlanOrderDetailVO> getDetailOrderList(PlanOrderDetailVO vo); //상세 주문조회
	List<SafePlanVO> getSafeInventoryList(); //안전재고량 조회
	List<FailPlanVO> getFailProdList(); //실패수량 조회
	List<FailPlanVO> getSuccessProdList(); //전주생산수량 파악
}
