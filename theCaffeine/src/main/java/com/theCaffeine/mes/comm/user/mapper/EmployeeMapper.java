package com.theCaffeine.mes.comm.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.comm.user.model.EmployeeVO;

@Mapper
public interface EmployeeMapper {
	List<EmployeeVO> getEmpList(EmployeeVO vo); //사원 목록 출력
	EmployeeVO getEmpInfo (int empNo); //사원 단건 조회
	int insertEmp (EmployeeVO vo); //사원  등록
	int deleteEmp (int empNo); //사원 삭제
	int updateEmp (EmployeeVO vo); //사원 정보 수정
}
