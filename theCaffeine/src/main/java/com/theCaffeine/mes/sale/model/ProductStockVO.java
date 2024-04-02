package com.theCaffeine.mes.sale.model;

import java.util.Date;

import lombok.Data;
@Data
public class ProductStockVO {
	
	private String pdLot;
	private String unit;
	private int qt;
	private Date pdtDt;
	private Date expDt;
	private int st;
	private String pdCd;
	private int pdtInstDetailNo;
	
}
