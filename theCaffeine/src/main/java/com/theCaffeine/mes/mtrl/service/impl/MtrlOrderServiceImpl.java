
package com.theCaffeine.mes.mtrl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.mtrl.mapper.MtrlOrderMapper;
import com.theCaffeine.mes.mtrl.model.MtrlOrderVO;
import com.theCaffeine.mes.mtrl.service.MtrlOrderService;

@Service
public class MtrlOrderServiceImpl implements MtrlOrderService{

	@Autowired MtrlOrderMapper mtrlOrderMapper;
	
	@Override
	public List<MtrlOrderVO> getMtrlOrderList(MtrlOrderVO vo) {
		return mtrlOrderMapper.getMtrlOrderList(vo);
	}

	@Override
	public List<MtrlOrderVO> getMtrlList(String cliCd) {
		return mtrlOrderMapper.getMtrlList(cliCd);
	}

	@Override
	public int insertMtrlOrder(MtrlOrderVO vo) {
		return mtrlOrderMapper.insertMtrlOrder(vo);
	}

	@Override
	public int deleteMtrlOrder(String mtPlaceodCd) {
		return mtrlOrderMapper.deleteMtrlOrder(mtPlaceodCd);
	}
	
}
