package com.theCaffeine.mes.qlty.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.theCaffeine.mes.qlty.model.ProcessVO;

@Service
public interface ProcessService {
	List<ProcessVO> getProcessCheckList(ProcessVO vo);
	List<ProcessVO> getProcessDoneList(ProcessVO vo);
	int updateMfckRes(ProcessVO vo);
	int updateFailMfckRes(ProcessVO vo);
	int deleteProcessDoneList(ProcessVO vo);
	
}
