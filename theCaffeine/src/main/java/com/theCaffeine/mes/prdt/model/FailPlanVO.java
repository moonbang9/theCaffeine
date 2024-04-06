package com.theCaffeine.mes.prdt.model;

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
}
