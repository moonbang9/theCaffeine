package com.theCaffeine.mes.qlty.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.qlty.mapper.PackagingMapper;
import com.theCaffeine.mes.qlty.model.PackagingVO;
import com.theCaffeine.mes.qlty.service.PackagingService;

@Service
public class PackagingServiceImpl implements PackagingService{
	
	@Autowired
	PackagingMapper packagingMapper;

	@Override
	public List<PackagingVO> getPackagingCheckList(PackagingVO vo) {
		return packagingMapper.getPackagingCheckList(vo);
	}

	@Override
	public List<PackagingVO> getPackagingDoneList(PackagingVO vo) {
		return packagingMapper.getPackagingDoneList(vo);
	}
	
	@Transactional
	@Override
	public int updatePackckRes(PackagingVO vo) {
		packagingMapper.updatePackckRes(vo);
		packagingMapper.updateSuccessInstPackaging(vo.getPdtInstDetailNo());
		packagingMapper.updateSuccessHistPackaging(vo.getPdtInstDetailNo());
		return packagingMapper.updateCkSt(vo.getPackCkNo());
	}
	
	@Transactional
	@Override
	public int updateFailPackckRes(PackagingVO vo) {
		packagingMapper.updatePackckRes(vo);
		packagingMapper.updateFailInstPackaging(vo.getPdtInstDetailNo());
		packagingMapper.updateFailHistPackaging(vo.getPdtInstDetailNo());
		return packagingMapper.updateCkSt(vo.getPackCkNo());
	}
	
	@Override
	public int deletePackagingDoneList(PackagingVO vo) {
		return packagingMapper.deletePackagingDoneList(vo.getPackCkNo());
	}

	@Override
	public int insertPdSTK(PackagingVO vo) {
		// TODO Auto-generated method stub
		return packagingMapper.insertPdSTK(vo);
	}


}
