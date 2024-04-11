package com.theCaffeine.mes.fclt.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.theCaffeine.mes.fclt.mapper.OperationMapper;

import com.theCaffeine.mes.fclt.model.OperationVO;

import com.theCaffeine.mes.fclt.service.OperationService;



@Service
public class OperationServiceImpl implements OperationService{

	@Autowired OperationMapper oprtMapper;

	@Override
	public int insertOprt(OperationVO vo) {
		return oprtMapper.insertOprt(vo);
	}

	@Override
	public List<OperationVO> getOprtList(OperationVO vo) {
		return oprtMapper.getOprtList(vo);
	}

	@Override
	public OperationVO getOprtInfo(String nonopCd) {
		return oprtMapper.getOprtInfo(nonopCd);
	}

	@Override
	public int deleteOprt(String nonopCd) {
		return oprtMapper.deleteOprt(nonopCd);
	}


	@Override
	public int updateOprt(OperationVO vo) {
		return oprtMapper.updateOprt(vo);
	}

	@Override
	public int updateFnTime(OperationVO vo) {
		return oprtMapper.updateFnTime(vo);
	}

	
	

}
