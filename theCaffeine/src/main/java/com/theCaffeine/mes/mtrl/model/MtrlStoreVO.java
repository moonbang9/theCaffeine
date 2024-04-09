package com.theCaffeine.mes.mtrl.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MtrlStoreVO {
	private int mtStrNo;
	private int strQt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date strCompdt;
	private String strChg;
	private String mtPlaceodCd;
	private String mtCd;
	
	private int expDt;
	
}
