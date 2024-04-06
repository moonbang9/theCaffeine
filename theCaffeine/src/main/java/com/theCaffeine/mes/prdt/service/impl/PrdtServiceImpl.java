package com.theCaffeine.mes.prdt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.prdt.mapper.PrdtMapper;
import com.theCaffeine.mes.prdt.model.FailPlanVO;
import com.theCaffeine.mes.prdt.model.MtrlPlanVO;
import com.theCaffeine.mes.prdt.model.PlanOrderDetailVO;
import com.theCaffeine.mes.prdt.model.PlanVO;
import com.theCaffeine.mes.prdt.model.SafePlanVO;
import com.theCaffeine.mes.prdt.service.PrdtService;

@Service
public class PrdtServiceImpl implements PrdtService{

	@Autowired PrdtMapper prdtMapper;

	@Override
	public List<PlanVO> getPlanList(PlanVO vo) {
		// TODO Auto-generated method stub
		return prdtMapper.getPlanList(vo);
	}

	@Override
	public List<PlanVO> getPlanDetailList(String pdtPlanCd) {
		// TODO Auto-generated method stub
		return prdtMapper.getPlanDetailList(pdtPlanCd);
	}

	@Override
	public List<MtrlPlanVO> getQnttMtrlList(String pdtPlanCd) {
		// TODO Auto-generated method stub
		return prdtMapper.getQnttMtrlList(pdtPlanCd);
	}

	@Override
	public List<PlanOrderDetailVO> getDetailOrderList(PlanOrderDetailVO vo) {
		// TODO Auto-generated method stub
		return prdtMapper.getDetailOrderList(vo);
	}

	@Override
	public List<SafePlanVO> getSafeInventoryList() {
		// TODO Auto-generated method stub
		return prdtMapper.getSafeInventoryList();
	}

	@Override
	public List<FailPlanVO> getFailProdList() {
		// TODO Auto-generated method stub
		return prdtMapper.getFailProdList();
	}

	@Override
	public List<FailPlanVO> getSuccessProdList() {
		// TODO Auto-generated method stub
		return prdtMapper.getSuccessProdList();
	}
	
}
