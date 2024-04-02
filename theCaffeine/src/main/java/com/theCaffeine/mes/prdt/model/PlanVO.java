package com.theCaffeine.mes.prdt.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanVO {
	private String pdtPlanCd; //생산계획코드
	private Date wkPlanSttDt; //주간계획시작일
	private String odName; //계획명
	//PDT_PLAN_CD
//	PDT_PLAN_DETAIL_NO
//	PD_NAME
//	QT
//	DUE_DT
}
