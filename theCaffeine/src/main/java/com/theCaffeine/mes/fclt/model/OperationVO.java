package com.theCaffeine.mes.fclt.model;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class OperationVO {
	String nonopCd;
	Timestamp nonopSttTime;
	Timestamp nonopFnTime;
	String fcChg;
	String rsn;
	String rsnDesc;
	String fcCd;
}
