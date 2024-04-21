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
public class YearTotalVO {				//월간실적
	private String insCont; //설비 특이사항
	private String months; //월
	private Integer pbr01; //브라질 원두
	private Integer pcb01; //콜롬비아 원두
	private Integer pct01; //코스타리카 원두
	private Integer pet01; //브라질 원두
	private Integer ppr01; //페루 원두
	private Integer sums; //원두 합계
}
