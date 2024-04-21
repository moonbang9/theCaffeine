package com.theCaffeine.mes.sale.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.theCaffeine.mes.sale.model.DiscPdVO;
@Mapper
public interface DiscPdMapper {
	List<DiscPdVO> discPdList(DiscPdVO vo);
	List<DiscPdVO> discPdChart(DiscPdVO vo);
}
