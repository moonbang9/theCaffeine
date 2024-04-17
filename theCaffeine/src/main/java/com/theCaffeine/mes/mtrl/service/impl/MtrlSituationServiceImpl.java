package com.theCaffeine.mes.mtrl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.mtrl.mapper.MtrlSituationMapper;
import com.theCaffeine.mes.mtrl.model.MtrlSituationVO;
import com.theCaffeine.mes.mtrl.service.MtrlSituationService;

@Service
public class MtrlSituationServiceImpl implements MtrlSituationService{

	@Autowired MtrlSituationMapper mtrlSituationMapper;
	
	@Override
	public List<MtrlSituationVO> getMtrlStoreList(MtrlSituationVO vo) {
		return mtrlSituationMapper.getMtrlStoreList(vo);
	}

	@Override
	public List<MtrlSituationVO> getMtrlSendList(MtrlSituationVO vo) {
		return mtrlSituationMapper.getMtrlSendList(vo);
	}

	@Override
	public List<MtrlSituationVO> getMtrlReturnList(MtrlSituationVO vo) {
		return mtrlSituationMapper.getMtrlReturnList(vo);
	}

}
