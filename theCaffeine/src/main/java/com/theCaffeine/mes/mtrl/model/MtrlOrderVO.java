package com.theCaffeine.mes.mtrl.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MtrlOrderVO {

	String mtPlaceodCd;
	int placeodQt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date placeodReqdt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date placeodCompdt;
	String placeodRequester;
	String placeodChg;
	int placeodSt;
	String mtCd;
	String cliCd;
	String mtDiv;
	String mtName;
	String cliName;
	String unit;
	int leadtm;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date placeodArridt;
}
