package com.theCaffeine.mes.qlty.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class LookupVO {
	private String mcName; // 검사명 : 수분검사
	private String ccName; // 검사명 : 색도검사
	private String ncName; // 검사명 : 질소충전검사
	private String mcRes; // 수분검사 결과
	private String mfckRes; // 공정검사(색도검사) 결과
	private String packckRes; //포장검사(질소충전검사) 결과
	@JsonFormat(pattern="yyyy-MM-dd") 
	private Date ckDt; //검사일

}
