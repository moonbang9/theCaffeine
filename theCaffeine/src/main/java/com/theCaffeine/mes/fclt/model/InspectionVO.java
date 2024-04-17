package com.theCaffeine.mes.fclt.model;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class InspectionVO {
	String insCd;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	Date insDt;
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	Date lastInsDt;
	String insCat;
	String insCont;
	String cc;
	String chg;
	String fcCd;
	String nonopCd;
	String fcName;
	
	@JsonIgnore
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	Date insDt2;
}
