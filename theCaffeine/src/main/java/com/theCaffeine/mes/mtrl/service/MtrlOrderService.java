package com.theCaffeine.mes.mtrl.service;

import java.util.List;

import com.theCaffeine.mes.mtrl.model.MtrlOrderVO;

public interface MtrlOrderService {
	List<MtrlOrderVO> getMtrlOrderList(MtrlOrderVO vo);
	List<MtrlOrderVO> getMtrlList(String cliCd);
	int insertMtrlOrder(MtrlOrderVO vo);
	int deleteMtrlOrder(String mtPlaceodCd);
}
