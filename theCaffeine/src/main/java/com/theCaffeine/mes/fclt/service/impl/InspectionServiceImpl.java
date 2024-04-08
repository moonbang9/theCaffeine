package com.theCaffeine.mes.fclt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.fclt.mapper.InspectionMapper;
import com.theCaffeine.mes.fclt.model.InspectionVO;
import com.theCaffeine.mes.fclt.service.InspectionService;


@Service
public class InspectionServiceImpl implements InspectionService{

	@Autowired InspectionMapper inspMapper;

	@Override
	public int insertInspection(InspectionVO vo) {
		//설비 lastInsDt 업데이트 
		
		//설비 번호 단건조회;
		
		//설비 점검 일자 lastInsDt
		
		//update 호출
		
		//점검 내역 등록
		return inspMapper.insertInspection(vo);
	}

	

	@Override
	public InspectionVO getInspInfo(String insCd) {
		return inspMapper.getInspInfo(insCd);
	}

	@Override
	public int deleteInspection(String insCd) {
		return inspMapper.deleteInspection(insCd);
	}

	@Override
	public int updateInspection(InspectionVO vo) {
		return inspMapper.updateInspection(vo);
	}

	@Override
	public List<InspectionVO> getInspList(InspectionVO vo) {
		return inspMapper.getInspList(vo);
	}

	

	
	
	
	

}
