package com.theCaffeine.mes.sale.service;

import java.util.List;

import com.theCaffeine.mes.comm.clnt.model.ClientVO;
import com.theCaffeine.mes.sale.model.ProductVO;

public interface InsertOrderService {
	List<ClientVO> getClientList(String searchCli);
	List<ProductVO> productList();
}
