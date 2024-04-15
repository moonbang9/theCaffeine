package com.theCaffeine.mes.sale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.sale.mapper.SendOrderMapper;
import com.theCaffeine.mes.sale.model.OrderMngVO;
import com.theCaffeine.mes.sale.service.SendOrderService;

import lombok.Setter;
@Service
public class SendOrderServiceImpl implements SendOrderService {

	@Setter(onMethod_ = @Autowired)
	SendOrderMapper sendOrderMapper;
	
	@Override
	public List<OrderMngVO> notSendList(OrderMngVO vo) {
		return sendOrderMapper.notSendList(vo);
	}

	@Override
	public List<OrderMngVO> sentList(OrderMngVO vo) {
		return sendOrderMapper.sentList(vo);
	}

}
