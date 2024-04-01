package com.theCaffeine.mes.mtrl.model;

import java.util.Date;

import lombok.Data;

@Data
public class MtrlVO {
	String mtCd;
	String mtDiv;
	String mtName;
	int cost;
	String unit;
	Date expDt;
	int leadtm;
	int safeStkRate;
	String cliCd;
}
