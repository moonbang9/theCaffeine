package com.theCaffeine.mes.sale.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.sale.model.LotStockVO;
import com.theCaffeine.mes.sale.model.PdStockVO;

@Mapper
public interface PdStockMapper {

	List<PdStockVO> pdStockList();
	List<LotStockVO> lotStockList(LotStockVO vo);
}
