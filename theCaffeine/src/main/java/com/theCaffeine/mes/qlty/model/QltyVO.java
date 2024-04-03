package com.theCaffeine.mes.qlty.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class QltyVO {
	private String mtPlaceodCd; //자재발주코드
	private Integer placeodQt; //발주 수량
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date placeodReqdt; //발주 요청일
	private Date placeodCompdt; //발주 완료일
	private String placeodRequester; //발주 요청자
	private String placeodChg; //발주 담당자
	private Integer placeodSt; //발주 상태
	private String mtCd; //자재 코드
	private String cliCd; //거래처 코드
	
	
	private String mtCheck; // 자재 검사 테이블
	private String mtName; //자재명
	private String cliName; //거래처명
	private String ckName; //검사명
	
	
	
}
