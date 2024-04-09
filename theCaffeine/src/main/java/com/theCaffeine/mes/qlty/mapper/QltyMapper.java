package com.theCaffeine.mes.qlty.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.theCaffeine.mes.mtrl.model.MtrlVO;
import com.theCaffeine.mes.qlty.model.QltyVO;

@Mapper
public interface QltyMapper {
	List<QltyVO> getMtrlCheckList(QltyVO vo);
	List<QltyVO> getMtrlDoneList(QltyVO vo);
	
	int updateMcRes(QltyVO vo);
	int updatePlaceodSt(String mtPlaceodCd);

}
