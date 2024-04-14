package com.theCaffeine.mes.prdt.model;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstResistVO {
	private InstVO instVO;
	private List<InstVO> instDetailVO;
}
