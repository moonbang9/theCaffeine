package com.theCaffeine.mes.mtrl.service;

import java.util.List;

import com.theCaffeine.mes.mtrl.model.MtrlSituationVO;

public interface MtrlSituationService {
	List<MtrlSituationVO> getMtrlStoreList(MtrlSituationVO vo);
	List<MtrlSituationVO> getMtrlSendList(MtrlSituationVO vo);
	List<MtrlSituationVO> getMtrlReturnList(MtrlSituationVO vo);
}
