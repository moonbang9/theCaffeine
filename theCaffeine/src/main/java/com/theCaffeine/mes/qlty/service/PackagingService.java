package com.theCaffeine.mes.qlty.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.theCaffeine.mes.qlty.model.PackagingVO;

@Service
public interface PackagingService {
	List<PackagingVO> getPackagingCheckList(PackagingVO vo);
	List<PackagingVO> getPackagingDoneList(PackagingVO vo);
	
	int updatePackckRes (PackagingVO vo);
	int updateFailPackckRes (PackagingVO vo);
	int insertPdSTK (PackagingVO vo);
	
	int deletePackagingDoneList(PackagingVO vo);

}
