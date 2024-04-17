package com.theCaffeine.mes.comm.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.comm.user.mapper.EmployeeMapper;
import com.theCaffeine.mes.comm.user.model.EmployeeVO;
import com.theCaffeine.mes.comm.user.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired EmployeeMapper empMapper;
	@Override
	public List<EmployeeVO> getEmpList(EmployeeVO vo) {
		return empMapper.getEmpList(vo);
	}

	@Override
	public EmployeeVO getEmpInfo(int empNo) {
		return empMapper.getEmpInfo(empNo);
	}

	@Override
	public int insertEmp(EmployeeVO vo) {
		return empMapper.insertEmp(vo);
	}

	@Override
	public int deleteEmp(int empNo) {
		return empMapper.deleteEmp(empNo);
	}

	@Override
	public int updateEmp(EmployeeVO vo) {
		return empMapper.updateEmp(vo);
	}

}
