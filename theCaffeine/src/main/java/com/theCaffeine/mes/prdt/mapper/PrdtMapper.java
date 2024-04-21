package com.theCaffeine.mes.prdt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.mtrl.model.MtrlSendVO;
import com.theCaffeine.mes.prdt.model.FailPlanVO;
import com.theCaffeine.mes.prdt.model.HistVO;
import com.theCaffeine.mes.prdt.model.InstVO;
import com.theCaffeine.mes.prdt.model.MfProcessVO;
import com.theCaffeine.mes.prdt.model.MtrlPlanVO;
import com.theCaffeine.mes.prdt.model.NonopFcVO;
import com.theCaffeine.mes.prdt.model.PlanDetailVO;
import com.theCaffeine.mes.prdt.model.PlanOrderDetailVO;
import com.theCaffeine.mes.prdt.model.PlanResistVO;
import com.theCaffeine.mes.prdt.model.PlanVO;
import com.theCaffeine.mes.prdt.model.SafePlanVO;
import com.theCaffeine.mes.prdt.model.TotalVO;
import com.theCaffeine.mes.prdt.model.YearTotalVO;


@Mapper
public interface PrdtMapper {
	List<PlanVO> getPlanList(PlanVO vo); //주간 생산계획조회
	PlanVO getPlanInfo(String pdtPlanCd); // 생산계획 단건 조회
	List<PlanVO> getPlanDetailList(String pdtPlanCd); //주간 생산계획조회
	List<MtrlPlanVO> getQnttMtrlList(String pdtPlanCd); //주간 발주계획
	List<PlanOrderDetailVO> getDetailOrderList(PlanOrderDetailVO vo); //상세주문조회
	List<SafePlanVO> getSafeInventoryList(); //재고수량 파악
	List<FailPlanVO> getFailProdList(); //실패수량 파악
	List<FailPlanVO> getSuccessProdList(); //전주생산수량 파악
	FailPlanVO getNotDate(); //선택안되는 일자
	List<PlanVO> getBasicPlanList(); // 주간계획등록 기본 양식
	List<FailPlanVO> getPlanConsum(); // box -> kg 단위변경
	int insertPrdtPlan(PlanVO vo); //계획 등록
	int insertPrdtDetailPlan(PlanDetailVO vo); //계획상세 등록
	int updatePrdtPlan(PlanVO vo); //계획 수정
	int updatePrdtDetailPlan(PlanDetailVO vo); //계획상세 수정
	int planDelete(String pdtPlanCd); //계획 삭제
	int planDetailDelete(String pdtPlanCd); //계획상세 삭제
	List<InstVO> getInstList(); //일별 지시조회
	List<InstVO> getInstDetailList(Integer pdtInstNo); //일별 지시상세조회
	int instDelete(Integer pdtInstNo); //지시 삭제
	int instDetailDelete(Integer pdtInstNo); //지시상세 삭제
	int instDetailDelete2(Integer pdtInstDetailNo); //지시상세 디테일 삭제
	List<PlanVO> getPlanCdList(); // 계획코드 리스트
	int insertPrdtInst(InstVO vo); //지시 등록
	int insertPrdtInstDetail(InstVO vo); //지시상세 등록
	String updateMtSend(Integer pdtInstDetailNo); // 반납자재 수정
	List<HistVO> getTodayProduct(HistVO vo); //금일 생산지시 목표량
	List<MfProcessVO> getInstDetailProcess(InstVO vo); // 공정과정
	List<NonopFcVO> getNonopFc(); //비가동 설비 판단
	TotalVO getTot(); //실적값들
	List<HistVO> getSuccessTot(); //성공실적값
	List<HistVO> getFailTot(); //실패실적값
	List<YearTotalVO> getMonths(); //월간계획
}
