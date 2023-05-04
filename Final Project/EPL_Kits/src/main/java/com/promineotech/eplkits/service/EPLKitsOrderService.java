package com.promineotech.eplkits.service;

import com.promineotech.eplkits.entity.Orders;
import com.promineotech.eplkits.entity.OrdersEntry;

public interface EPLKitsOrderService {
	
	Orders createOrders(OrdersEntry ordersEntry);

	Orders updateKit(OrdersEntry ordersEntry, Long ordersPK);
	
	Orders deleteKit(Long ordersPK);
	

}
