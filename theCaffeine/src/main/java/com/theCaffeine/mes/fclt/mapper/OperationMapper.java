package com.theCaffeine.mes.fclt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.theCaffeine.mes.fclt.model.OperationVO;

@Mapper
public interface OperationMapper {
	int insertOprt(OperationVO vo);  //비가동 등록
	List<OperationVO> getOprtList(); //비가동 목록
	OperationVO getOprtInfo(String nonopCd);// 단건 조회 
	int deleteOprt (String nonopCd); //단건 삭제
	int updateOprt(OperationVO vo); //단건 수정
	int updateOpStatus(String fcCd); //스케줄러 용 상태 변경업데이트
}
