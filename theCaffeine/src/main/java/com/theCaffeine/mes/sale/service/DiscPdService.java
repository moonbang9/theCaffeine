package com.theCaffeine.mes.sale.service;

import java.util.List;

import com.theCaffeine.mes.sale.model.DiscPdVO;

public interface DiscPdService {

	List<DiscPdVO> discPdList(DiscPdVO vo);
	List<DiscPdVO> discPdChart(DiscPdVO vo);
}
