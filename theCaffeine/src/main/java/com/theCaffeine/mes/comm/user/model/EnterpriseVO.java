package com.theCaffeine.mes.comm.user.model;

import java.util.List;

import com.theCaffeine.mes.prdt.model.InstVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseVO {
		String enterCd;
		String id;
		String pw;
		String bussno;
		String enterName;
		String chg;
		String mail;
		String ceo;
		String authNo;
		String authName;
		int st;
		// table view 
		String memType;
		String name;
		String tel;
		String dpt;
}
