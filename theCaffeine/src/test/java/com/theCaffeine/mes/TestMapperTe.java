package com.theCaffeine.mes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.theCaffeine.mes.common.main.mapper.MainMapper;
import com.theCaffeine.mes.common.main.model.TestVO;


@SpringBootTest
public class TestMapperTe {
	
	@Autowired MainMapper testMapper;
	
	@Test
	public void 보드단건조회() {
		TestVO vo = testMapper.getBoardInfo();
		System.out.println(vo);
	}
}
