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
public class MfProcessVO {
	private String pdCd; 				//제품 코드
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date pdtSttTime; 			//생산 시작 시간
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date pdtFnTime; 			//생산 종료 시간
	private String process1; 			//예열 및 대기
	private String process2; 			//투입
	private String process3; 			//1차크랙
	private String process4; 			//2차크랙
	private String process5; 			//배출
	private String process6; 			//공정검사
	private String process7; 			//냉각
	private String process8; 			//봉지포장
	private String process9; 			//포장검사
	private String process10; 			//입고
	
	private String pdtPdCd; 			//생산 제품 코드
	private String addMfTime; 			//추가 공정 시간
	private String pdtPsCd; 			//생산 과정 코드
	private String mfCd; 				//공정 코드
	private String mfPsDiv; 			//공정 과정 분류
	private Integer mfStepTime; 		//공정 순서 시간
	private String mfStep; 				//공정 순서
}
