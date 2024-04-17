package com.theCaffeine.mes.mtrl.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MtrlOrderListVO {
	
	private String mtPlaceodCd;
	private String cliCd;
	private String cliName;
	private String mtCd;
	private String mtName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date placeodCompdt;
	private int placeodSt;
	private String placeodChg;
	private String st;
	
	List<String> stList;
	
	private Date placeodCompdt1;
	private Date placeodCompdt2;
	
	private String bussno;
	private String tel;
	private String addr;
	private String mail;
	private String cliChg;
	private int placeodQt;
	private String unit;
	private int cost;
	private int placeodCost;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String dueDt;
}
