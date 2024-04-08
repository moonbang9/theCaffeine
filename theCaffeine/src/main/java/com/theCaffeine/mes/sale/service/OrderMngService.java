package com.theCaffeine.mes.sale.service;

import java.util.List;

import com.theCaffeine.mes.sale.model.OrderMngVO;

public interface OrderMngService {

	List<OrderMngVO> getOrderList(OrderMngVO vo);
}
