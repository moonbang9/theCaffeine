package com.theCaffeine.mes.sale.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.sale.model.OrderMngVO;

@Mapper
public interface SendOrderMapper {

	//미출고 목록 조회
	List<OrderMngVO> notSendList(OrderMngVO vo);
	//출고된 목록(출고중, 출고완료) 조회
	List<OrderMngVO> sentList(OrderMngVO vo);
}
