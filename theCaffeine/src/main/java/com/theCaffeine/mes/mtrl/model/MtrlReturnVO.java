package com.theCaffeine.mes.mtrl.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MtrlReturnVO {

	int mtRtnNo;
	int rtnQt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date rtnCompdt;
	String rtnChg;
	String mtPlaceodCd;
	String mtCd;
	
}
