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
public class PlanOrderDetailVO {
	
	private Integer odDetailno;			//상세제품번호
	private String pdCd;			//제품코드
	private String unit;			//단위
	private Integer qt;             //수량(Box)
	private Integer pdtQt;			//생산 수량
	private Integer prePdtQt;		//생산 예정수량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dueDt;				//납기 일
	private Integer odDetailSt;		//주문상태
}
