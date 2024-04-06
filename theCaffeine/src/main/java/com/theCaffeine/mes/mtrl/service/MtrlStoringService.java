package com.theCaffeine.mes.mtrl.service;

import java.util.List;

import com.theCaffeine.mes.mtrl.model.MtrlOrderVO;
import com.theCaffeine.mes.mtrl.model.MtrlStoreVO;

public interface MtrlStoringService {
	List<MtrlOrderVO> getMtrlPassList(MtrlOrderVO vo);
	List<MtrlOrderVO> getMtrlFailList(MtrlOrderVO vo);
	List<MtrlOrderVO> getMtrlSubsidiaryList(MtrlOrderVO vo);
	
	int insertMtrlStr(MtrlStoreVO vo);
}
