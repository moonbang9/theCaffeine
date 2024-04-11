package com.theCaffeine.mes.sale.model;

import java.util.List;

import lombok.Data;

@Data
public class InsertOrderVO {
	OrderVO orderVO;
	List<OrderDetailVO> orderDetailVO;
	
	//주문 상세 정보 - 주문 제품 목록
	List<ProductVO> productVO;
}
