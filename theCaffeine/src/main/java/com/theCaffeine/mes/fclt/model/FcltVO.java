package com.theCaffeine.mes.fclt.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class FcltVO {
	String fcCd;
	String fcName;
	String st;
	String insMf;
	String mnfCom;
	@JsonFormat(pattern="yyyy-MM-dd")
	Date strDt;
	@JsonFormat(pattern="yyyy-MM-dd")
	Date lastInsDt;
	@JsonFormat(pattern="yyyy-MM-dd")
	Date nextInsDt;
	int insCycle;
	int output;
	int durTime;
}
