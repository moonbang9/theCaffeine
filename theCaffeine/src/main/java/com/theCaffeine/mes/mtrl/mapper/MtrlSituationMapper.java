package com.theCaffeine.mes.mtrl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.mtrl.model.MtrlSituationVO;

@Mapper
public interface MtrlSituationMapper {
	List<MtrlSituationVO> getMtrlStoreList(MtrlSituationVO vo);
	List<MtrlSituationVO> getMtrlSendList(MtrlSituationVO vo);
	List<MtrlSituationVO> getMtrlReturnList(MtrlSituationVO vo);
}
