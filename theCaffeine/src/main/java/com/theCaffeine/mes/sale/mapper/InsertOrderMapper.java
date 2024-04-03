package com.theCaffeine.mes.sale.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.comm.clnt.model.ClientVO;
import com.theCaffeine.mes.sale.model.ProductVO;

@Mapper
public interface InsertOrderMapper {
	List<ClientVO> getClientList(String searchCli);
	List<ProductVO> productList();
}
