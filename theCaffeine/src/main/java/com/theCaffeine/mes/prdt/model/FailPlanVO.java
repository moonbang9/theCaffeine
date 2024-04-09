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
public class FailPlanVO {				//실패 수량 파악
	private String pdCd;				//제품코드
	private String unit;				//단위
	private Integer failTat; 			//전주 실패 수량
	private Integer befSuccessTat; 		//전주 생산 수량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date noDate;				//선택안되는 일자
	private Integer consum; 			//단위 수량
	private Integer totConsum; 			//제품별 단위 합계 수량
	private Integer unitQt;				//박스별 단위 무게
}
