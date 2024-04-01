package com.theCaffeine.mes.comm.main.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.comm.main.model.TestVO;

@Mapper
public interface MainMapper {
	TestVO getBoardInfo();
}
