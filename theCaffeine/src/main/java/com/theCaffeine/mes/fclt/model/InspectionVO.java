package com.theCaffeine.mes.fclt.model;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class InspectionVO {
	String insCd;
	Date insDt;
	Timestamp sttTime;
	Timestamp fnTime;
	int insCat;
	String insCont;
	String cc;
	String chg;
	String fcCd;
	String nonopCd;
}
