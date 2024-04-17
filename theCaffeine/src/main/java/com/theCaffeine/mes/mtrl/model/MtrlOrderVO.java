package com.theCaffeine.mes.mtrl.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MtrlOrderVO {

	private String mtPlaceodCd;
	private int placeodQt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date placeodReqdt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date placeodCompdt;
	private String placeodRequester;
	private String placeodChg;
	private int placeodSt;
	private String mtCd;
	private String cliCd;
	private String mtDiv;
	private String mtName;
	private String cliName;
	private String unit;
	private int leadtm;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date placeodArridt;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date ckDt;
	private String ckChg;
	private int expDt;
}
