package com.theCaffeine.mes.mtrl.service.impl;

import java.util.List;

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

	@Override
	public List<MtrlVO> getMtrlList(MtrlVO vo) {
		return mtrlMapper.getMtrlList(vo);
	}

	@Override
	public List<MtrlVO> getMtrlList2(MtrlVO vo) {
		return mtrlMapper.getMtrlList2(vo);
	}

	@Override
	public MtrlVO getMtrlInfo(String mtCd) {
		return mtrlMapper.getMtrlInfo(mtCd);
	}

	@Override
	public int updateMtrl(MtrlVO vo) {
		return mtrlMapper.updateMtrl(vo);
	}

	@Override
	public List<MtrlVO> getCliList() {
		return mtrlMapper.getCliList();
	}

}
