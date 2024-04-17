package com.theCaffeine.mes.mtrl.model;

import lombok.Data;

@Data
public class MtrlVO {
	private String mtCd;
	private String mtDiv;
	private String mtName;
	private int cost;
	private String unit;
	private int expDt;
	private int leadtm;
	private int safeStkRate;
	private String cliCd;
	private String cliName;
}
