package com.theCaffeine.mes.sale.model;

import java.util.Date;

import lombok.Data;
@Data
public class OrderDetailVO {
	
	private int odDetailno;
	private int qt;
	private int cost;
	private int detailPrice;
	private int odNo;
	private String pdCd;
	private Date date;
	
}
