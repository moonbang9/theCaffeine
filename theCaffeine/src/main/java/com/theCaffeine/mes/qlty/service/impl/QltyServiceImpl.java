package com.theCaffeine.mes.qlty.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.qlty.mapper.QltyMapper;
import com.theCaffeine.mes.qlty.model.QltyVO;
import com.theCaffeine.mes.qlty.service.QltyService;

@Service
public class QltyServiceImpl implements QltyService{
	
	@Autowired
	QltyMapper qltyMapper;
	
	@Override
	public List<QltyVO> getMtrlCheckList(QltyVO vo) {
		return qltyMapper.getMtrlCheckList(vo);
	}

}
