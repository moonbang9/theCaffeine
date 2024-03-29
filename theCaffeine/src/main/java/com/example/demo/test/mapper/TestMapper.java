package com.example.demo.test.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.test.TestVO;

@Mapper
public interface TestMapper {
	TestVO getBoardInfo();
}
