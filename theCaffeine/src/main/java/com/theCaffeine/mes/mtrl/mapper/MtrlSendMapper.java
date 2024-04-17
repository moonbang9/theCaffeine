package com.theCaffeine.mes.mtrl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.mtrl.model.MtrlSendVO;

@Mapper
public interface MtrlSendMapper {
	List<MtrlSendVO> getMtrlSendList();
	String insertMtrlSend(MtrlSendVO vo);
}
