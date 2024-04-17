package com.theCaffeine.mes.qlty.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.qlty.model.ProcessVO;

@Mapper
public interface ProcessMapper {

	List<ProcessVO> getProcessCheckList(ProcessVO vo);
	List<ProcessVO> getProcessDoneList(ProcessVO vo);
	
	int updateMfckRes (ProcessVO vo);
	int updateCkSt (Integer ckSt);
	
	int deleteProcessDoneList(Integer mfCkNo);
	//검사 성공
	int updateSuccessHistProcess(Integer pdtInstDetailNo);
	//검사 실패
	int updateFailInstProcess(Integer pdtInstDetailNo);

}
