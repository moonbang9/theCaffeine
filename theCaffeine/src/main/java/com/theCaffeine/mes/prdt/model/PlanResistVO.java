package com.theCaffeine.mes.prdt.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanResistVO {
	private PlanVO planVO;
	private List<PlanDetailVO> planDetailVO;
	private PlanOrderDetailVO planOrderDetailVO;
}
