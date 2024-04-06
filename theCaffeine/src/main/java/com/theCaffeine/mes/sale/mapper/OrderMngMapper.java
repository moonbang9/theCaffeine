package com.theCaffeine.mes.sale.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.sale.model.OrderMngVO;

@Mapper
public interface OrderMngMapper {
	
	List<OrderMngVO> getOrderList(OrderMngVO vo);
	
}
