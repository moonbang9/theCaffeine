package com.theCaffeine.mes.mtrl.service;

import java.util.List;

import com.theCaffeine.mes.mtrl.model.MtrlOrderVO;
import com.theCaffeine.mes.mtrl.model.MtrlReturnVO;
import com.theCaffeine.mes.mtrl.model.MtrlStkListVO;
import com.theCaffeine.mes.mtrl.model.MtrlStoreVO;

public interface MtrlStoringService {
	List<MtrlOrderVO> getMtrlPassList(MtrlOrderVO vo);
	List<MtrlOrderVO> getMtrlFailList(MtrlOrderVO vo);
	List<MtrlOrderVO> getMtrlSubsidiaryList(MtrlOrderVO vo);
	
	String insertMtrlStr(MtrlStoreVO vo);
	
	int insertMtrlReturn(MtrlReturnVO vo);
	
	List<MtrlStkListVO> getMtrlStockList(MtrlStkListVO vo);
	List<MtrlStkListVO> getRotStockList(String mtCd);
}
