package com.theCaffeine.mes.fclt.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class OperationVO {
	String nonopCd;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date nonopSttTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date nonopFnTime;
	String fcChg;
	String rsn;
	String rsnDesc;
	String fcCd;
}
