package com.theCaffeine.mes.prdt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theCaffeine.mes.prdt.mapper.PrdtMapper;
import com.theCaffeine.mes.prdt.model.FailPlanVO;
import com.theCaffeine.mes.prdt.model.InstVO;
import com.theCaffeine.mes.prdt.model.MtrlPlanVO;
import com.theCaffeine.mes.prdt.model.PlanDetailVO;
import com.theCaffeine.mes.prdt.model.PlanOrderDetailVO;
import com.theCaffeine.mes.prdt.model.PlanResistVO;
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

	@Override
	public FailPlanVO getNotDate() {
		// TODO Auto-generated method stub
		return prdtMapper.getNotDate();
	}

	@Override
	public List<PlanVO> getBasicPlanList() {
		// TODO Auto-generated method stub
		return prdtMapper.getBasicPlanList();
	}

	@Override
	public List<FailPlanVO> getPlanConsum() {
		// TODO Auto-generated method stub
		return prdtMapper.getPlanConsum();
	}
	
	@Transactional
	@Override
	public int planResist(PlanResistVO vo) {
		// TODO Auto-generated method stub
		prdtMapper.insertPrdtPlan(vo.getPlanVO());
		
		if(vo.getPlanDetailVO() != null) {
			for(PlanDetailVO i : vo.getPlanDetailVO()) {
				if(i.getQt() != 0) {
					prdtMapper.insertPrdtDetailPlan(i);
				}
			}
		}
		
		return 1;
	}

	@Override
	public PlanVO getPlanInfo(String pdtPlanCd) {
		// TODO Auto-generated method stub
		return prdtMapper.getPlanInfo(pdtPlanCd);
	}
	
	@Transactional
	@Override
	public int planUpdate(PlanResistVO vo) {
		prdtMapper.updatePrdtPlan(vo.getPlanVO());
		
		if(vo.getPlanDetailVO() != null) {
			for(PlanDetailVO i : vo.getPlanDetailVO()) {
				if(i.getQt() != 0) {
					prdtMapper.updatePrdtDetailPlan(i);
				}
			}
		}
		return 1;
	}
	
	@Transactional
	@Override
	public int planDelete(String pdtPlanCd) {
		// TODO Auto-generated method stub
		prdtMapper.planDelete(pdtPlanCd);
		
		return prdtMapper.planDetailDelete(pdtPlanCd);
	}

	@Override
	public List<InstVO> getInstList() {
		// TODO Auto-generated method stub
		return prdtMapper.getInstList();
	}

	@Override
	public List<InstVO> getInstDetailList(Integer pdtInstNo) {
		// TODO Auto-generated method stub
		return prdtMapper.getInstDetailList(pdtInstNo);
	}

	@Override
	public int instDelete(Integer pdtInstNo) {
		prdtMapper.instDelete(pdtInstNo);
		
		return prdtMapper.instDetailDelete(pdtInstNo);
	}

	@Override
	public int instDetailDelete(Integer pdtInstDetailNo) {
		// TODO Auto-generated method stub
		return prdtMapper.instDetailDelete2(pdtInstDetailNo);
	}

	@Override
	public List<PlanVO> getPlanCdList() {
		// TODO Auto-generated method stub
		return prdtMapper.getPlanCdList();
	}
	
}
