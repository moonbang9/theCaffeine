package com.theCaffeine.mes.sale.model;


import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrderMngVO {

	//(주문번호, 주문상세번호)주문일자, 거래처명, 제품명, 납기일, 총금액, 주문상세상태
	//제품코드, 거래처담당자명, 주문담당자
	
	private int odNo;
	private int odDetailNo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date odDt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dueDt;
	
	private String cliCd;
	private String cliName;
	private String cliChg;
	private String odChg;
	
	private float dcRate;
	private int totalPrice;
	
	private String pdCd;
	
	private String pdName;
	private String pd;
	
	private int odSt;
	private String st;
	
	int cnt;
	int detailPrice;
	//주문일자 조건검색
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date minOdDt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date maxOdDt;
	//납기일자 조건검색
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date minDueDt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date maxDueDt;
	//주문상태 조건검색
	List<String> stList;
	
	
	
	//미출고, 출고 목록
	private String no;
	private int qt;
	private int sendOdSt;
	private String sendStName;
}
