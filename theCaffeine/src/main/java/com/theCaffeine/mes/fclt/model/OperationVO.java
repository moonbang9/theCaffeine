package com.theCaffeine.mes.fclt.model;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class OperationVO {
	String nonopCd;
	String fcName;
	String st;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	Date nonopSttTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	Date nonopFnTime;
	String fcChg;
	String rsn;
	String rsnDesc;
	String fcCd;
}
