package com.theCaffeine.mes.prdt.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanDetailVO {					//생산계획 + 계획상세
	private String pdtPlanCd;			//생산계획코드
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date wkPlanSttDt; 			//주간계획시작일
	private String odName; 				//계획명
	private Integer pdtPlanDetailNo; 	//생산계획 상세번호
	private String pdName; 				//제품 명
	private Integer qt;					//수량
	private Integer addQt;				//추가 수량
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDt;					//납기 일
	private String plantot;				//주간 토탈 상품명
	private Integer psum;				//주간 토탈 원두 생산량
	private String pdCd;				//제품코드
	private Integer unitQt;				//박스별 단위 무게
	
}
