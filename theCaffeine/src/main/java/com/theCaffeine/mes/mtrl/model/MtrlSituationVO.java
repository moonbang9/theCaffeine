package com.theCaffeine.mes.mtrl.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MtrlSituationVO {
	// 공통
	private String mtDiv;
	private String mtCd;
	private String mtName;
	private String unit;
    
	// 입고 목록
    private int strQt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date strCompdt;
    private String strChg;
	
	// 출고 목록
    private int sendQt;
    private String mtLot;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date sendCompdt;
    private String sendChg;
	
	// 반품 목록
    private int rtnQt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rtnCompdt;
    private String rtnChg;
	
	// 검색조건
	private Date minDt;
	private Date maxDt;
	private Date minDt1;
	private Date minDt2;
}
