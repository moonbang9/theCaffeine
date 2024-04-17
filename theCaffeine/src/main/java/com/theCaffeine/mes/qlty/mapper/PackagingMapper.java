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

}
