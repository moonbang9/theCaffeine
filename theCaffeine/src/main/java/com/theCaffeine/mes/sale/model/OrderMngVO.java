package com.theCaffeine.mes.sale.model;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderMngVO {

	//(주문번호, 주문상세번호)주문일자, 거래처명, 제품명, 납기일, 총금액, 주문상세상태
	//제품코드, 거래처담당자명, 주문담당자
	
	private int odNo;
	private int odDetailNo;
	
	private Date odDt;
	private Date dueDt;
	
	private String cliCd;
	private String cliName;
	private String cliChg;
	private String odChg;
	
	private float dcRate;
	private int totalPrice;
	
	private String pdCd;
	private String pdName;
	private Integer odDetailSt;
	
	//주문일자 조건검색
	Date minOdDt;
	Date maxOdDt;
	//납기일자 조건검색
	Date minDueDt;
	Date maxDueDt;
	//주문상태 조건검색
	List<Integer> stList;
}
