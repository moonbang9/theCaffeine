package com.theCaffeine.mes.comm.user.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PaymentVO {
	String payCd;
	@JsonFormat(pattern="yyyy-MM-dd")
	Date payDt;
	String key;
	int price;
	int subNo;
	String enterCd;
	
}
