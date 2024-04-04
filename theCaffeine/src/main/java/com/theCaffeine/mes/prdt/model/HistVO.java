package com.theCaffeine.mes.prdt.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistVO {
	private Integer pdtHistNo; 			//생산 내역 번호
	private Date pdtDt; 				//생산 일
	private String pdName; 				//제품 명
	private Integer pdtQt; 				//생산 수량
	private Date pdtExptSttTime; 		//생산 예상 시작 시간
	private Date pdtExptFnTime; 		//생산 예상 종료 시간
	private Date pdtSttTime; 			//생산 시작 시간
	private Date pdtFnTime; 			//생산 종료 시간
	private Integer pdtInstDetailNo; 	//생산 지시 상세 번호
	
	private Integer mfQualSt; 			//공정 품질 상태
	private Integer packQualSt; 		//포장 품질 상태
	private String failRsn; 			//실패사유
	private String mfCd; 				//공정 코드
}
