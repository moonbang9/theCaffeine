package com.theCaffeine.mes.qlty.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.theCaffeine.mes.qlty.model.QltyVO;

@Service
public interface QltyService {
	List<QltyVO> getMtrlCheckList(QltyVO vo);
	List<QltyVO> getMtrlDoneList(QltyVO vo);
	int updateMcRes(QltyVO vo);
	

}
