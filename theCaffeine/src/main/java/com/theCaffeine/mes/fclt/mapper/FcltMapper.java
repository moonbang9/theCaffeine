package com.theCaffeine.mes.fclt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.theCaffeine.mes.fclt.model.FcltVO;

@Mapper
public interface FcltMapper {
	int insertFclt(FcltVO vo);  //설비 등록
	List<FcltVO> getFcltList(FcltVO vo); //설비 목록
	List<FcltVO> getNonopFcltList(FcltVO vo);//비가동 설비 목록
	List<FcltVO> getOpFcltList(FcltVO vo);//가동중인 설비 목록
	FcltVO getFcltInfo(String fcCd);// 단건 조회 <select id="getFltInfo" parameterType="string" resultType="FcltVO">
	int deleteFclt (String fcCd); //단건 삭제
	int updateFclt(FcltVO vo); //단건 수정
}
