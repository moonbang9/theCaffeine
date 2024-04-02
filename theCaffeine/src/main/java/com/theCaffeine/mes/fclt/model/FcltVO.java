package com.theCaffeine.mes.fclt.model;

import java.util.Date;

import lombok.Data;

@Data
public class FcltVO {
	String fcCd;
	String fcName;
	int st;
	String insMf;
	String mnfCom;
	Date strDt;
	int insCycle;
	int output;
	int durTime;
}
