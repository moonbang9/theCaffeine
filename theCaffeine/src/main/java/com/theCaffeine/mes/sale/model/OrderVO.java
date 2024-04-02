package com.theCaffeine.mes.sale.model;

import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {
	
	private int odNo;
	private Date odDt;
	private String odChg;
	private int dcRate;
	private int totalPrice;
	private String cliCd;
}
