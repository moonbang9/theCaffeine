package com.theCaffeine.mes.mtrl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.mtrl.model.MtrlOrderVO;
import com.theCaffeine.mes.mtrl.model.MtrlVO;

@Mapper
public interface MtrlOrderMapper {
	List<MtrlOrderVO> getMtrlOrderList(MtrlOrderVO vo);
	List<MtrlOrderVO> getMtrlList(String cliCd);
	int insertMtrlOrder(MtrlOrderVO vo);
	int deleteMtrlOrder(String mtPlaceodCd);
}
