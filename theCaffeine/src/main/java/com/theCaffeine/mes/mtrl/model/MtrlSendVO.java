package com.theCaffeine.mes.mtrl.model;

import java.util.Date;

import lombok.Data;

@Data
public class MtrlSendVO {
	// 출고 테이블 인서트
	private int mtSendNo;
	private int sendQt;
	private Date sendCompdt;
	private String sendChg;
	private String mtLot;
	private int pdtInstNo;
	
	// 출고 자재 목록
	private String mtCd;
	private String mtDiv;
	private String mtName;
	private int mtQt;
	private String unit;
	private int sumStkQt;
	private int reStkQt;
}
