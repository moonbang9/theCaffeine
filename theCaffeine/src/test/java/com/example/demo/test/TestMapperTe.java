package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.test.mapper.TestMapper;


@SpringBootTest
public class TestMapperTe {
	
	@Autowired TestMapper testMapper;
	
	@Test
	public void 보드단건조회() {
		TestVO vo = testMapper.getBoardInfo();
		System.out.println(vo);
	}
}
