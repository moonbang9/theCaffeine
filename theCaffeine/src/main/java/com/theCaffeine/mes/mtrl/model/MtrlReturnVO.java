package com.theCaffeine.mes.mtrl.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MtrlReturnVO {

	private int mtRtnNo;
	private int rtnQt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date rtnCompdt;
	private String rtnChg;
	private String mtPlaceodCd;
	private String mtCd;
	
}
