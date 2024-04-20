package com.theCaffeine.mes.sale.model;

import lombok.Data;

@Data
public class PdStockVO {

	private String pdCd;
	private String pdName;
	private String unit;
	
	private int curStk; 		//총재고
	private int totalNotSend;	//총미출고
	private int twoWPrdt;		//2주예상생산
	private int twoWNotSend;	//2주미출고
	private float possStats;		// 2주미출고/(총재고+2주예상생산) * 100 : 출고가능예상통계
	private int possTwoSend;	// (총재고+2주예상생산)-2주미출고 : 2주 출고가능량
	
}
