package com.theCaffeine.mes.mtrl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.mtrl.model.MtrlOrderListVO;
import com.theCaffeine.mes.mtrl.model.MtrlOrderVO;
import com.theCaffeine.mes.mtrl.model.MtrlStkListVO;

@Mapper
public interface MtrlOrderMapper {
	List<MtrlOrderVO> getMtrlOrderList(MtrlOrderVO vo);
	List<MtrlOrderVO> getMtrlList(String cliCd);
	int insertMtrlOrder(MtrlOrderVO vo);
	int deleteMtrlOrder(String mtPlaceodCd);
	int updateMtrlOrder(MtrlOrderVO vo);
	int updateMtrlOrder2(String mtPlaceodCd);
	List<MtrlOrderVO> getMtrlCliList();
	
	List<MtrlOrderVO> getMtrlqualList(MtrlOrderVO vo);
	int insertMtrlQuality(MtrlOrderVO vo);
	int updateMtrlOrder3(String mtPlaceodCd);
	
	List<MtrlStkListVO> getMtrlStkList(); 
	
	List<MtrlOrderListVO> getMtrlOrderSearchList(MtrlOrderListVO vo);
	MtrlOrderListVO getMtrlPlaceodInfo(String mtPlaceodCd);
}
