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
public class InstVO {
	private Integer pdtInstNo; 			//생산 지시 번호
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date pdtInstDt; 			//생산 지시 일
	private String pdtPdCd; 			//생산 제품 코드
	private String pdtPlanCd; 			//생산 계획 코드
	private Integer mtSendNo; 			//자재 출고 번호
	private Integer pdtInstDetailNo; 	//생산 지시 상세 번호
	private String pdCd; 				//제품 코드
	private Integer qt; 				//상세 수량
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date pdtSttTime; 			//생산 시작 시간
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date pdtexptFnTime; 		//생산예상 종료 시간
	private Integer compSt; 				//완료 상태
	private Double msum; 				//총 예상 작업시간
	private Integer isum; 				//총 생산수량
	private String insttot; 			//지시 총 상품명 (외 몇개)
	private String pdName; 				//상품명
	private String pdtChg; 				//생산 담당자
}
