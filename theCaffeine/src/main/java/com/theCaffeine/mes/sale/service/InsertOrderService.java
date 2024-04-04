package com.theCaffeine.mes.sale.service;

import java.util.List;

import com.theCaffeine.mes.comm.clnt.model.ClientVO;
import com.theCaffeine.mes.sale.model.OrderDetailVO;
import com.theCaffeine.mes.sale.model.OrderVO;
import com.theCaffeine.mes.sale.model.ProductVO;

public interface InsertOrderService {
	
	//거래처 목록 검색
	List<ClientVO> getClientList(String searchCli);
	//제품 목록
	List<ProductVO> productList();
	
	//주문 + 주문 상세 등록
	public int insertOrder(OrderVO orderVO, OrderDetailVO orderDetailVO);
	
}
