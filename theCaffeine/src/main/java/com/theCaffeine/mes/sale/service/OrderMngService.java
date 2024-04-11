package com.theCaffeine.mes.sale.service;

import java.util.List;

import com.theCaffeine.mes.sale.model.OrderMngVO;
import com.theCaffeine.mes.sale.model.OrderVO;
import com.theCaffeine.mes.sale.model.ProductVO;

public interface OrderMngService {

	List<OrderMngVO> getOrderList(OrderMngVO vo);
	OrderVO getOdInfo(int odNo);
	List<ProductVO> getOdPdList(int odNo);
}
