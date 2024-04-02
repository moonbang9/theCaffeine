package com.theCaffeine.mes.mtrl.service;

import java.util.List;

import com.theCaffeine.mes.mtrl.model.MtrlVO;

public interface MtrlService {
	int insertMtrl(MtrlVO vo);
	List<MtrlVO> getMtrlList(MtrlVO vo);
	List<MtrlVO> getMtrlList2(MtrlVO vo);
	MtrlVO getMtrlInfo(String mtCd);
	int updateMtrl(MtrlVO vo);
}
