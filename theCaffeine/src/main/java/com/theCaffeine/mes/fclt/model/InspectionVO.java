package com.theCaffeine.mes.fclt.model;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class InspectionVO {
	String insCd;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	Date insDt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	Date lastInsDt;
	String insCat;
	String insCont;
	String cc;
	String chg;
	String fcCd;
	String nonopCd;
	String fcName;
}
