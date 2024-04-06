package com.theCaffeine.mes.mtrl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.mtrl.model.MtrlOrderVO;
import com.theCaffeine.mes.mtrl.model.MtrlStoreVO;

@Mapper
public interface MtrlStoringMapper {
	List<MtrlOrderVO> getMtrlPassList(MtrlOrderVO vo);
	List<MtrlOrderVO> getMtrlFailList(MtrlOrderVO vo);
	List<MtrlOrderVO> getMtrlSubsidiaryList(MtrlOrderVO vo);
	
	int insertMtrlStr(MtrlStoreVO vo);
	//int insertMtrlRtn(MtrlStoreVO vo);
}
