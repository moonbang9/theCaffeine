package com.theCaffeine.mes.qlty.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.qlty.mapper.ProcessMapper;
import com.theCaffeine.mes.qlty.model.ProcessVO;
import com.theCaffeine.mes.qlty.service.ProcessService;

@Service
public class ProcessServiceImpl implements ProcessService{
	
	@Autowired
	ProcessMapper processMapper;

	@Override
	public List<ProcessVO> getProcessCheckList(ProcessVO vo) {
		return processMapper.getProcessCheckList(vo);
	}

	@Override
	public List<ProcessVO> getProcessDoneList(ProcessVO vo) {
		return processMapper.getProcessDoneList(vo);
	}
	
	@Transactional
	@Override
	public int updateMfckRes(ProcessVO vo) {
		processMapper.updateMfckRes(vo);
		return processMapper.updateCkSt(vo.getMfCkNo());
	}
	
	@Transactional
	@Override
	public int deleteProcessDoneList(ProcessVO vo) {
			processMapper.updateSuccessHistProcess(vo.getPdtInstDetailNo());
		
		return processMapper.deleteProcessDoneList(vo.getMfCkNo());
	}
	


}
