package com.theCaffeine.mes.sale.service;

import java.util.List;

import com.theCaffeine.mes.sale.model.LotStockVO;
import com.theCaffeine.mes.sale.model.PdStockVO;

public interface PdStockService {

	//제품 전체 재고 조회
	List<PdStockVO> pdStockList();
	List<LotStockVO> lotStockList(LotStockVO vo);
}
