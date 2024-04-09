package com.theCaffeine.mes.qlty.service.impl;

import java.util.List;

import javax.transaction.Transactional;

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
	
	@Transactional
	@Override
	public int updateMcRes(QltyVO vo) {
		qltyMapper.updateMcRes(vo);
		return qltyMapper.updatePlaceodSt(vo.getMtPlaceodCd());
	}

	@Override
	public List<QltyVO> getMtrlDoneList(QltyVO vo) {
		return qltyMapper.getMtrlDoneList(vo);
	}



}
