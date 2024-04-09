package com.theCaffeine.mes.mtrl.model;

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
}
