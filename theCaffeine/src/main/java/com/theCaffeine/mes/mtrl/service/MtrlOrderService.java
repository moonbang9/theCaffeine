package com.theCaffeine.mes.mtrl.service;

import java.util.List;

import com.theCaffeine.mes.mtrl.model.MtrlOrderVO;
import com.theCaffeine.mes.mtrl.model.MtrlStkListVO;

public interface MtrlOrderService {
	List<MtrlOrderVO> getMtrlOrderList(MtrlOrderVO vo);
	List<MtrlOrderVO> getMtrlList(String cliCd);
	int insertMtrlOrder(MtrlOrderVO vo);
	int deleteMtrlOrder(String mtPlaceodCd);
	int updateMtrlOrder(MtrlOrderVO vo);
	List<MtrlOrderVO> getMtrlCliList();
	
	List<MtrlOrderVO> getMtrlqualList(MtrlOrderVO vo);
	int insertMtrlQuality(MtrlOrderVO vo);
	
	List<MtrlStkListVO> getMtrlStkList();
}
