package com.theCaffeine.mes.prdt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SafePlanVO {				//안전재고 수량 파악
	private String pdCd;				//제품코드
	private String unit;				//단위
	private Integer nowStk; 			//현재 재고 수량
	private Integer safeStk; 			//현재 안전재고 수량
	private Integer msStk; 				//안전재고 수량차
}
