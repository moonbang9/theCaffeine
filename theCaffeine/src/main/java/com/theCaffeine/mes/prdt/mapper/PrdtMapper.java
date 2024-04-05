package com.theCaffeine.mes.prdt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.prdt.model.MtrlPlanVO;
import com.theCaffeine.mes.prdt.model.PlanOrderDetailVO;
import com.theCaffeine.mes.prdt.model.PlanVO;
import com.theCaffeine.mes.prdt.model.SafePlanVO;


@Mapper
public interface PrdtMapper {
	List<PlanVO> getPlanList(PlanVO vo); //주간 생산계획조회
	List<PlanVO> getPlanDetailList(String pdtPlanCd); //주간 생산계획조회
	List<MtrlPlanVO> getQnttMtrlList(String pdtPlanCd); //주간 발주계획
	List<PlanOrderDetailVO> getDetailOrderList(PlanOrderDetailVO vo); //상세주문조회
	List<SafePlanVO> getSafeInventoryList(); //재고수량 파악
}
