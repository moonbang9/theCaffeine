package com.theCaffeine.mes.mtrl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.mtrl.model.MtrlStoreVO;

@Mapper
public interface MtrlStorionMapper {
	List<MtrlStoreVO> getMtrlPassList(MtrlStoreVO vo);
	List<MtrlStoreVO> getMtrlFailList(MtrlStoreVO vo);
	List<MtrlStoreVO> getMtrlSubsidiaryList(MtrlStoreVO vo);
	
}
