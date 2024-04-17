package com.theCaffeine.mes.comm.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.comm.main.model.CodeDetailVO;

@Mapper
public interface MainMapper {
	List<CodeDetailVO> getCodeDetailList(String wkCdNo);
}
