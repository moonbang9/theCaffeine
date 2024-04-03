package com.theCaffeine.mes.prdt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MfProcessVO {
	private String pdtPdCd; 			//생산 제품 코드
	private String addMfTime; 			//추가 공정 시간
	private String pdtPsCd; 			//생산 과정 코드
	private String mfCd; 				//공정 코드
	private String mfPsDiv; 			//공정 과정 분류
	private Integer mfStepTime; 		//공정 순서 시간
	private String mfStep; 				//공정 순서
}
