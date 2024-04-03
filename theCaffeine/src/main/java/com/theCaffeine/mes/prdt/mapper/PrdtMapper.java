package com.theCaffeine.mes.prdt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.prdt.model.PlanVO;


@Mapper
public interface PrdtMapper {
	List<PlanVO> getPlanList(PlanVO vo); //주간 생산계획조회
	List<PlanVO> getPlanDetailList(String pdtPlanCd); //주간 생산계획조회
}
