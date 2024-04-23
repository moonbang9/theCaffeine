package com.theCaffeine.mes.qlty.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.qlty.model.PackagingVO;
import com.theCaffeine.mes.qlty.model.ProcessVO;

@Mapper
public interface PackagingMapper {
	List<PackagingVO> getPackagingCheckList(PackagingVO vo);
	List<PackagingVO> getPackagingDoneList(PackagingVO vo);
	
	int updatePackckRes (PackagingVO vo);
	int updateCkSt (Integer ckSt);
	
	int deletePackagingDoneList(Integer packCkNo);
	
	// 포장 성공
	int updateSuccessInstPackaging(Integer pdtInstDetailNo);
	int updateSuccessHistPackaging(Integer pdtInstDetailNo);
	// 포장 실패
	int updateFailInstPackaging(Integer pdtInstDetailNo);
	int updateFailHistPackaging(Integer pdtInstDetailNo);
	
	//완제품 등록
	int insertPdSTK(PackagingVO vo);
	//공정 수정
	int updateCkProcess(PackagingVO vo);
}
