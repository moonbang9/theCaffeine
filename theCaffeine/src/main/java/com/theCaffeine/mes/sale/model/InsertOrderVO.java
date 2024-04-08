package com.theCaffeine.mes.sale.model;

import java.util.List;

import lombok.Data;

@Data
public class InsertOrderVO {
	OrderVO orderVO;
	List<OrderDetailVO> orderDetailVO;
}
