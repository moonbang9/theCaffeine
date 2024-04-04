package com.theCaffeine.mes.comm.clnt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BomVO {
	private Integer bomNo; 		//bom 번호
	private String pdCd; 		//제품코드
	private String unit; 		//단위
	private String detailUnit; 	//상세단위
	private Integer consum; 	//소모량
	private String mtCd; 		//자재코드
}
