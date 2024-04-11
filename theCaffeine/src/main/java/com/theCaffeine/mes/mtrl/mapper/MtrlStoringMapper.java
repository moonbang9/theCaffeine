package com.theCaffeine.mes.mtrl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.mtrl.model.MtrlOrderVO;
import com.theCaffeine.mes.mtrl.model.MtrlReturnVO;
import com.theCaffeine.mes.mtrl.model.MtrlStkListVO;
import com.theCaffeine.mes.mtrl.model.MtrlStoreVO;

@Mapper
public interface MtrlStoringMapper {
	// 입고관리 페이지 목록 출력
	List<MtrlOrderVO> getMtrlPassList(MtrlOrderVO vo);
	List<MtrlOrderVO> getMtrlFailList(MtrlOrderVO vo);
	List<MtrlOrderVO> getMtrlSubsidiaryList(MtrlOrderVO vo);
	// 입고처리
	String insertMtrlStr(MtrlStoreVO vo);
	int updateMtrlOrder(String mtPlaceodCd);
	// 반품처리
	int insertMtrlReturn(MtrlReturnVO vo);
	int updateMtrlOrder2(String mtPlaceodCd);
	
	// 자재재고조회 페이지 목록 출력
	List<MtrlStkListVO> getMtrlStockList(MtrlStkListVO vo);
	List<MtrlStkListVO> getRotStockList(String mtCd);
}
