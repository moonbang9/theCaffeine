package com.theCaffeine.mes.sale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.comm.clnt.model.ClientVO;
import com.theCaffeine.mes.sale.mapper.InsertOrderMapper;
import com.theCaffeine.mes.sale.model.ProductVO;
import com.theCaffeine.mes.sale.service.InsertOrderService;

import lombok.Setter;

@Service
public class InsertOrderServiceImpl implements InsertOrderService{

	@Setter(onMethod_ = @Autowired)
	InsertOrderMapper insertOrderMapper;
	
	@Override
	public List<ClientVO> getClientList(String searchCli) {
		return insertOrderMapper.getClientList(searchCli);
	}

	@Override
	public List<ProductVO> productList() {
		return insertOrderMapper.productList();
	}

}
