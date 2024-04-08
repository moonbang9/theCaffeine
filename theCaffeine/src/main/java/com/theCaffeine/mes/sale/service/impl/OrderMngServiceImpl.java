package com.theCaffeine.mes.sale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.sale.mapper.OrderMngMapper;
import com.theCaffeine.mes.sale.model.OrderMngVO;
import com.theCaffeine.mes.sale.service.OrderMngService;

import lombok.Setter;

@Service
public class OrderMngServiceImpl implements OrderMngService{

	@Setter(onMethod_ = @Autowired)
	OrderMngMapper orderMngMapper;
	
	@Override
	public List<OrderMngVO> getOrderList(OrderMngVO vo) {
		return orderMngMapper.getOrderList(vo);
	}

}
