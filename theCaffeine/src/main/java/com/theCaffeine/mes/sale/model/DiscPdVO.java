package com.theCaffeine.mes.sale.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class DiscPdVO {

	private int discNo;
	private int qt;
	private int cost;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date discDt;
	private int rsn;
	private String discChg;
	private String pdLot;
	
	private String pdName;
	private String reason;
	private String pdCd;
	
	
	// 1금일 2금주 3전주 4금월 5전월
	private int period;
	
//	private int today;
//	private int thisWeek;
//	private int prevWeek;
//	private int thisMonth;
//	private int prevMonth;
	
	//직접설정
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date minDiscDt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date maxDiscDt;
	
	//차트
	private int sumQt;
	
}
