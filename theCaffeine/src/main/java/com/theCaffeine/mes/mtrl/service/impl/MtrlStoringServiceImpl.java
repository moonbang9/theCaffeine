package com.theCaffeine.mes.mtrl.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.mtrl.mapper.MtrlStoringMapper;
import com.theCaffeine.mes.mtrl.model.MtrlOrderVO;
import com.theCaffeine.mes.mtrl.model.MtrlReturnVO;
import com.theCaffeine.mes.mtrl.model.MtrlStkListVO;
import com.theCaffeine.mes.mtrl.model.MtrlStoreVO;
import com.theCaffeine.mes.mtrl.service.MtrlStoringService;

@Service
public class MtrlStoringServiceImpl implements MtrlStoringService{

	@Autowired MtrlStoringMapper mtrlStoringMapper;
	
	@Override
	public List<MtrlOrderVO> getMtrlPassList(MtrlOrderVO vo) {
		return mtrlStoringMapper.getMtrlPassList(vo);
	}

	@Override
	public List<MtrlOrderVO> getMtrlFailList(MtrlOrderVO vo) {
		return mtrlStoringMapper.getMtrlFailList(vo);
	}

	@Override
	public List<MtrlOrderVO> getMtrlSubsidiaryList(MtrlOrderVO vo) {
		return mtrlStoringMapper.getMtrlSubsidiaryList(vo);
	}

	@Transactional
	@Override
	public int insertMtrlReturn(MtrlReturnVO vo) {
		mtrlStoringMapper.updateMtrlOrder2(vo.getMtPlaceodCd());
		return mtrlStoringMapper.insertMtrlReturn(vo);
	}

	@Transactional
	@Override
	public String insertMtrlStr(MtrlStoreVO vo) {
		mtrlStoringMapper.updateMtrlOrder(vo.getMtPlaceodCd());
		mtrlStoringMapper.insertMtrlStr(vo);
		String result = "OK";
		return result;
	}

	@Override
	public List<MtrlStkListVO> getMtrlStockList(MtrlStkListVO vo) {
		return mtrlStoringMapper.getMtrlStockList(vo);
	}

	@Override
	public List<MtrlStkListVO> getRotStockList(String mtCd) {
		return mtrlStoringMapper.getRotStockList(mtCd);
	}

}
