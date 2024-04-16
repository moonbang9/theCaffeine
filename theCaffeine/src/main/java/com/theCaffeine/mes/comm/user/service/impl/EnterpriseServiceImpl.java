package com.theCaffeine.mes.comm.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.theCaffeine.mes.comm.user.mapper.EnterpriseMapper;
import com.theCaffeine.mes.comm.user.model.EnterpriseVO;
import com.theCaffeine.mes.comm.user.service.EnterpriseService;
import com.theCaffeine.mes.scrt.CustomUserDetails;
@Service
public class EnterpriseServiceImpl implements EnterpriseService,UserDetailsService {

	@Autowired EnterpriseMapper enterMapper;
	@Override
	public List<EnterpriseVO> getEnterpriseList(EnterpriseVO vo) {
		return enterMapper.getEnterpriseList(vo);
	}

	@Override
	public EnterpriseVO getEnterInfo(String enterCd) {
		return enterMapper.getEnterInfo(enterCd);
	}

	@Override
	public int insertEnter(EnterpriseVO vo) {
		return enterMapper.insertEnter(vo);
	}

	@Override
	public int deleteEnter(String enterCd) {
		return enterMapper.deleteEnter(enterCd);
	}

	@Override
	public int updateEnter(EnterpriseVO vo) {
		return enterMapper.updateEnter(vo);
	}

	@Override
	public String idChk(String id) {
		return enterMapper.idChk(id);
	}

	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EnterpriseVO enterVO = enterMapper.getEnterInfo(username);
		if(enterVO == null) {
			throw new UsernameNotFoundException("id not found");
		}
		return new CustomUserDetails(enterVO);
	}

	@Override
	public CustomUserDetails loginChk(String id) {
		return null;
	}
	
}
