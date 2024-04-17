package com.theCaffeine.mes.sale.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LotStockVO {
	
	private String pdLot;
	private String pdCd;
	private String pdName;
	private int qt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date pdtDt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date expDt;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date minPdtDt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date maxPdtDt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date minExpDt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date maxExpDt;
	
	// 재고가 0인 LOT도 포함할지 여부;
	private boolean zeroQt = false;
	
	
	
}
