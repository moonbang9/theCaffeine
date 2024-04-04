package com.theCaffeine.mes.prdt.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MtrlPlanVO {				//생산계획 + 계획상세
	private String pdtPlanCd;			//생산계획코드
	private Integer placeodQt; 			//발주 수량
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date placeodCompdt;			//발주 완료일
	private String placeodRequester; 	//발주 요청자
	private String placeodChg; 			//발주 담당자
	private String mtCd; 				//자재 코드
	private String cliCd;				//거래처 코드
	private String mtDiv;				//자재 분류
	private String mtName;				//자재 명
	private String unit;				//단위
}
