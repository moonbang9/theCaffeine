package com.theCaffeine.mes.fclt.model;


import java.util.Date;


import lombok.Data;

@Data
public class InspectionVO {
	String insCd;
	Date insDt;
	int insCat;
	String insCont;
	String cc;
	String chg;
	String fcCd;
	String nonopCd;
	String fcName;
}
