package com.theCaffeine.mes.sale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.sale.mapper.PdStockMapper;
import com.theCaffeine.mes.sale.model.LotStockVO;
import com.theCaffeine.mes.sale.model.PdStockVO;
import com.theCaffeine.mes.sale.service.PdStockService;

import lombok.Setter;

@Service
public class PdStockServiceImpl implements PdStockService{

	@Setter(onMethod_ = @Autowired)
	PdStockMapper pdStockMapper;
	
	@Override
	public List<PdStockVO> pdStockList() {
		
		return pdStockMapper.pdStockList();
	}

	@Override
	public List<LotStockVO> lotStockList(LotStockVO vo) {
		return pdStockMapper.lotStockList(vo);
	}

}
