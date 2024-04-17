package com.theCaffeine.mes.sale.model;

import lombok.Data;

@Data
public class PdStockVO {

	private String pdCd;
	private String pdName;
	private String unit;
	private int curStk;
	private int threeWNotSend;
	private int notSend;
	private int monthlyPrd;
	private int weeklyPrd;
	private int shortage;
	
}
