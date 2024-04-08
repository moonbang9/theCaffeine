package com.theCaffeine.mes.fclt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.fclt.mapper.FcltMapper;
import com.theCaffeine.mes.fclt.model.FcltVO;
import com.theCaffeine.mes.fclt.service.FcltService;

@Service
public class FcltServiceImpl implements FcltService{

	@Autowired FcltMapper fcltMapper;

	@Override
	public int insertFclt(FcltVO vo) {
		return fcltMapper.insertFclt(vo);
	}

	@Override
	public List<FcltVO> getFcltList(FcltVO vo) {
		return fcltMapper.getFcltList(vo);
	}

	@Override
	public FcltVO getFcltInfo(String fcCd) {
		return fcltMapper.getFcltInfo(fcCd);
	}

	@Override
	public int deleteFclt(String fcCd) {
		return fcltMapper.deleteFclt(fcCd);
	}

	@Override
	public int updateFclt(FcltVO vo) {
		return fcltMapper.updateFclt(vo);


	}

	@Override
	public List<FcltVO> getNonopFcltList(FcltVO vo) {
		return fcltMapper.getNonopFcltList(vo);
	}

	@Override
	public List<FcltVO> getOpFcltList(FcltVO vo) {
	
		return fcltMapper.getOpFcltList(vo);
	}




	

}
