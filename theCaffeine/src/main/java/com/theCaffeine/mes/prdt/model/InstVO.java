package com.theCaffeine.mes.prdt.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstVO {
	private Integer pdtInstNo; 			//생산 지시 번호
	private Date pdtInstDt; 			//생산 지시 일
	private String pdtPdCd; 			//생산 제품 코드
	private String pdtPlanCd; 			//생산 계획 코드
	private Integer mtSendNo; 			//자재 출고 번호
	private Integer pdtInstDetailNo; 	//생산 지시 상세 번호
	private String pdCd; 				//제품 코드
	private Integer qt; 				//상세 수량
	private Date pdtSttTime; 			//생산 시작 시간
	private Date pdtexptFnTime; 		//생산예상 종료 시간
	private String compSt; 				//완료 상태
}
