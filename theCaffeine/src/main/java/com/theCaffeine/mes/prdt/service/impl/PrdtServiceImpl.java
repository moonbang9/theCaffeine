package com.theCaffeine.mes.prdt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.prdt.mapper.PrdtMapper;
import com.theCaffeine.mes.prdt.service.PrdtService;

@Service
public class PrdtServiceImpl implements PrdtService{

	@Autowired PrdtMapper prdtMapper;
	
}
