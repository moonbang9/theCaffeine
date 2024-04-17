package com.theCaffeine.mes.sale.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.sale.model.OrderMngVO;
import com.theCaffeine.mes.sale.model.OrderVO;
import com.theCaffeine.mes.sale.model.ProductVO;

@Mapper
public interface OrderMngMapper {
	
	List<OrderMngVO> getOrderList(OrderMngVO vo);
	OrderVO getOdInfo(int odNo);
	List<ProductVO> getOdPdList(int odNo);
}
