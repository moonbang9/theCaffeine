package com.theCaffeine.mes.comm.main.service.impl;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.comm.main.mapper.MainMapper;
import com.theCaffeine.mes.comm.main.model.CodeDetailVO;
import com.theCaffeine.mes.comm.main.service.MainService;

@Service
public class MainServiceImpl implements MainService{

	@Autowired MainMapper mainMapper;
	
	@Override
	public List<CodeDetailVO> getCodeDetailList(String wkCdNo) {
		return mainMapper.getCodeDetailList(wkCdNo);
	}

}


