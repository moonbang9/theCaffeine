package com.theCaffeine.mes.comm.main.service;

import java.util.List;

import com.theCaffeine.mes.comm.main.model.CodeDetailVO;

public interface MainService {
	List<CodeDetailVO> getCodeDetailList(String wkCdNo);
}
