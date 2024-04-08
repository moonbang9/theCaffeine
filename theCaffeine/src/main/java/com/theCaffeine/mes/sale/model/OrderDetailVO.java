package com.theCaffeine.mes.sale.model;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class OrderDetailVO {
	
	private int odDetailNo;
	private int qt;
	private int cost;
	private int detailPrice;
	private int odNo;
	private String pdCd;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDt;
	private int odDetailSt;
	
}
