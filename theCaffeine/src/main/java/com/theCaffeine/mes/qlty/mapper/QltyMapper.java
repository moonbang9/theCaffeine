package com.theCaffeine.mes.qlty.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.qlty.model.QltyVO;

@Mapper
public interface QltyMapper {
	Integer insertQlty(QltyVO vo);

}
