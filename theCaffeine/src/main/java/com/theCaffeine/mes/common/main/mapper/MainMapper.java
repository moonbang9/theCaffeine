package com.theCaffeine.mes.common.main.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.common.main.model.TestVO;

@Mapper
public interface MainMapper {
	TestVO getBoardInfo();
}
