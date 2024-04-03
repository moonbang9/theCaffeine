package com.theCaffeine.mes.fclt.service;

import java.util.List;

import com.theCaffeine.mes.fclt.model.FcltVO;

public interface FcltService {
	int insertFclt(FcltVO vo);  //설비 등록
	List<FcltVO> getFcltList(FcltVO vo); //설비 목록
	FcltVO getFcltInfo(String fcCd);// 단건 조회 <select id="getFltInfo" parameterType="string" resultType="FcltVO">
	int deleteFclt (String fcCd); //단건 삭제
	int updateFclt(FcltVO vo); //단건 수정
}
