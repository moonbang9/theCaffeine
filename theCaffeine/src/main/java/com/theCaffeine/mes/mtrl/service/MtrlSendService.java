package com.theCaffeine.mes.mtrl.service;

import java.util.List;

import com.theCaffeine.mes.mtrl.model.MtrlSendVO;

public interface MtrlSendService {
	List<MtrlSendVO> getMtrlSendList();
	String insertMtrlSend(MtrlSendVO vo);
}
