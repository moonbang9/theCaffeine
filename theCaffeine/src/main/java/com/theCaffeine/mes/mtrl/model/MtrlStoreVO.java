package com.theCaffeine.mes.mtrl.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MtrlStoreVO {
	int mtStrNo;
	int strQt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date strCompdt;
	String strChg;
	String mtPlaceodCd;
	String mtCd;
	
	int expDt;
	
}
