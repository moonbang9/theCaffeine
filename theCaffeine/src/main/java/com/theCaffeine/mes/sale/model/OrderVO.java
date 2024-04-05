package com.theCaffeine.mes.sale.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrderVO {
	
	private int odNo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date odDt;
	private String odChg;
	private float dcRate;
	private int totalPrice;
	private String cliCd;
}
