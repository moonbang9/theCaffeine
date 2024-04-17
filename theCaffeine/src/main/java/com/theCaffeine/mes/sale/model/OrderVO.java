package com.theCaffeine.mes.sale.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrderVO {
	
	private int odNo;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date odDt;
	private String odChg;
	private float dcRate;
	private int totalPrice;
	private String cliCd;
	private int odSt;
	
	private String cliName;
	private String bussno;
	private String tel;
	private String addr;
	private String mail;
	private String cliChg;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dueDt;
	private String dcPercent;
	
}
