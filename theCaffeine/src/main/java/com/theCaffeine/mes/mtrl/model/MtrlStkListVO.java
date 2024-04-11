package com.theCaffeine.mes.mtrl.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MtrlStkListVO {
	private String mtDiv;
	private String mtCd;
	private String mtName;
	private String unit;
	private int sumStkQt;
	private int sumPlaceodQt;
	private int safeStkQt;
	private int qtDifference;
	private int pqtt;
	
	private String mtLot;
	private int stkQt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date expDt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date strCompdt;
}
