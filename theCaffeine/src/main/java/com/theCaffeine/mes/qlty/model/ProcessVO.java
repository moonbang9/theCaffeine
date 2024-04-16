package com.theCaffeine.mes.qlty.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ProcessVO {
	private Integer mfCkNo; //공정 검사 번호
	private String ccName; //검사명 : 색도검사
	private Integer ckSt; //검사 상태
	private String pdName; //제품명
	private Integer pdtQt; //생산 수량
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date rtDt; //로스팅일
	private String rtChg; //로스팅 담당자
	private Integer firstCc; //1차 색도검사
	private Integer secondCc; //2차 색도검사
	private Integer thirdCc; //3차 색도검사
	private Integer fourthCc; //4차 색도검사
	private Integer fifthCc; //5차 색도검사
	private Integer ccAvg; //색도검사 평균
	private String mfckRes; //공정검사(색도검사) 결과
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ckDt; //검사일
	private String ckChg; // 검사 담당자
	private Integer pdtInstDetailNo; //생산 지시 상세 번호

}
