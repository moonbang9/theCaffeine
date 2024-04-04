
package com.theCaffeine.mes.mtrl.service.impl;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

	@Override
	public int updateMtrlOrder(MtrlOrderVO vo) {
        ScheduledExecutorService excutorService = Executors.newScheduledThreadPool(1);
        excutorService.schedule(() -> {
        	mtrlOrderMapper.updateMtrlOrder2(vo.getMtPlaceodCd());
            excutorService.shutdown();
        }, vo.getLeadtm(), TimeUnit.MINUTES); // TimeUnit.DAYS 로 바꾸면 됨.
        
		return mtrlOrderMapper.updateMtrlOrder(vo);
	}

	@Override
	public List<MtrlOrderVO> getMtrlqualList(MtrlOrderVO vo) {
		return mtrlOrderMapper.getMtrlqualList(vo);
	}

	@Override
	public int insertMtrlQuality(MtrlOrderVO vo) {
		return mtrlOrderMapper.insertMtrlQuality(vo);
	}
	
}
