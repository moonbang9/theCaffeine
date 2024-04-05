package com.theCaffeine.mes.mtrl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.mtrl.model.MtrlVO;

@Mapper
public interface MtrlMapper {
	int insertMtrl(MtrlVO vo);
	List<MtrlVO> getMtrlList(MtrlVO vo);
	List<MtrlVO> getMtrlList2(MtrlVO vo);
	MtrlVO getMtrlInfo(String mtCd);
	int updateMtrl(MtrlVO vo);
	List<MtrlVO> getCliList();
}
