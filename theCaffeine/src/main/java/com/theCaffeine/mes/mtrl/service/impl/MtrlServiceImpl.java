package com.theCaffeine.mes.mtrl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.mtrl.mapper.MtrlMapper;
import com.theCaffeine.mes.mtrl.model.MtrlVO;
import com.theCaffeine.mes.mtrl.service.MtrlService;

@Service
public class MtrlServiceImpl implements MtrlService{

	@Autowired MtrlMapper mtrlMapper;
	
	@Override
	public int insertMtrl(MtrlVO vo) {
		return mtrlMapper.insertMtrl(vo);
	}

}
