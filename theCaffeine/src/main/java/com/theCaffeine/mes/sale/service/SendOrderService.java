package com.theCaffeine.mes.sale.service;

import java.util.List;

import com.theCaffeine.mes.sale.model.OrderMngVO;

public interface SendOrderService {

	//미출고 목록 조회
	List<OrderMngVO> notSendList(OrderMngVO vo);
	//출고된 목록(출고중, 출고완료) 조회
	List<OrderMngVO> sentList(OrderMngVO vo);
}
