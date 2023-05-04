package com.promineotech.eplkits.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.eplkits.entity.Orders;
import com.promineotech.eplkits.entity.OrdersEntry;
import com.promineotech.eplkits.service.EPLKitsOrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultEPLKitsOrderController implements EPLKitsOrderController {
	
	@Autowired
	private EPLKitsOrderService eplKitsOrderService;

	@Override
	public Orders createOrders(OrdersEntry ordersEntry) {
		log.info("Controller: {}", ordersEntry);
		return eplKitsOrderService.createOrders(ordersEntry);
	}

	@Override
	public Orders updateKit(@Valid OrdersEntry ordersEntry, Long ordersPK) {
		log.info("Controller: Updating order ID = {}, {}", ordersPK, ordersEntry);
		return eplKitsOrderService.updateKit(ordersEntry, ordersPK);
	}

	@Override
	public Orders deleteKit(Long ordersPK) {
		log.info("Controller: Deleting order ID = {}", ordersPK);
		return eplKitsOrderService.deleteKit(ordersPK);
	}

}
