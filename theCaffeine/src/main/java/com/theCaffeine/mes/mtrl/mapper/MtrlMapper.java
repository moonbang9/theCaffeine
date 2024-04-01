package com.theCaffeine.mes.mtrl.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.mtrl.model.MtrlVO;

@Mapper
public interface MtrlMapper {
	int insertMtrl(MtrlVO vo);
}
