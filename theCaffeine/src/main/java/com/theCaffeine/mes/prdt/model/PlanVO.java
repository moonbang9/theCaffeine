package com.theCaffeine.mes.prdt.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanVO {					//생산계획 + 계획상세
	private String pdtPlanCd; 			//생산계획코드
	private Date wkPlanSttDt; 			//주간계획시작일
	private String odName; 				//계획명
	private Integer pdtPlanDetailNo; 	//생산계획 상세번호
	private String pdName; 				//제품 명
	private String qt;					//수량
	private Date dueDt;					//납기 일
}
