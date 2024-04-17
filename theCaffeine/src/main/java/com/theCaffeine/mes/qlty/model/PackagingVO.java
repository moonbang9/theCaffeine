package com.theCaffeine.mes.qlty.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PackagingVO {
	private Integer packCkNo; //포장검사 번호
	private String ncName; //검사명:질소충전검사
	private Integer ckSt; //검사 상태
	private String pdName; //제품명
	private Integer pdtQt; //생산 수량
	private String pdLot; //제품 LOT
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date packDt; //포장일
	private String packChg; //포장 담당자
	private Integer firstNc; //1차 질소충전검사
	private Integer secondNc; //2차 질소충전검사
	private Integer thirdNc; //3차 질소충전검사
	private Integer fourthNc; //4차 질소충전검사
	private Integer fifthNc; //5차 질소충전검사	
	private Integer ncAvgVal; //질소충전검사 평균값
	private String packckRes; //포장검사 결과
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ckDt; //검사일
	private String ckChg; //검사 담당자
	private Integer pdtInstDetailNo; //생산 지시 상세 번호

}
