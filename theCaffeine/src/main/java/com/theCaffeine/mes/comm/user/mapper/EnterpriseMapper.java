package com.theCaffeine.mes.comm.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.comm.user.model.EnterpriseVO;
import com.theCaffeine.mes.scrt.CustomUserDetails;

@Mapper
public interface EnterpriseMapper {
	List<EnterpriseVO> getEnterpriseList(EnterpriseVO vo); //가입 기업 목록 출력
	EnterpriseVO getEnterInfo (String enterCd); //기업 단건 조회
	String idChk (String id);//아이디 중복체크
	public EnterpriseVO loginChk(String id); // 로그인 체크 
	int insertEnter (EnterpriseVO vo); //기업 회원 등록
	int deleteEnter (String enterCd); //기업 삭제
	int updateEnter (EnterpriseVO vo); //기업 정보 수정
}

