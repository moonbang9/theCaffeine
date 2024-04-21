package com.theCaffeine.mes.sale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.sale.mapper.DiscPdMapper;
import com.theCaffeine.mes.sale.model.DiscPdVO;
import com.theCaffeine.mes.sale.service.DiscPdService;

import lombok.Setter;
@Service
public class DiscPdServiceImpl implements DiscPdService{

	
	@Setter(onMethod_ = @Autowired)
	DiscPdMapper discPdMapper;
	
	@Override
	public List<DiscPdVO> discPdList(DiscPdVO vo) {
		return discPdMapper.discPdList(vo);
	}

	@Override
	public List<DiscPdVO> discPdChart(DiscPdVO vo) {
		return discPdMapper.discPdChart(vo);
	}

	
}
