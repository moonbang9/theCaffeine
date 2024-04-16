package com.theCaffeine.mes.mtrl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.mtrl.mapper.MtrlSendMapper;
import com.theCaffeine.mes.mtrl.model.MtrlSendVO;
import com.theCaffeine.mes.mtrl.service.MtrlSendService;

@Service
public class MtrlSendServiceImpl implements MtrlSendService{

	@Autowired MtrlSendMapper mtrlSendMapper;
	
	@Override
	public List<MtrlSendVO> getMtrlSendList() {
		return mtrlSendMapper.getMtrlSendList();
	}

	@Override
	public String insertMtrlSend(MtrlSendVO vo) {
		return mtrlSendMapper.insertMtrlSend(vo);
	}

	
}
