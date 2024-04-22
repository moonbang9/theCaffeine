package com.theCaffeine.mes.prdt.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalVO {				//실적계산
	private Integer tot1;				//누적 총생산량
	private Integer tot2;				//금일 총생산량
	private Integer tot3; 				//금일 생산 성공량
	private Integer tot4; 				//금일 생산 실패량
	private Integer tot5;				//누적 총 수율
	private Integer tot6; 				//금일 수율
}
