package com.promineotech.eplkits.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.eplkits.dao.EPLKitsOrderDao;
import com.promineotech.eplkits.entity.Jerseys;
import com.promineotech.eplkits.entity.Orders;
import com.promineotech.eplkits.entity.OrdersEntry;
import com.promineotech.eplkits.entity.Shoes;
import com.promineotech.eplkits.entity.Shorts;
import com.promineotech.eplkits.entity.Teams;
import com.promineotech.eplkits.entity.Trainers;
import com.promineotech.eplkits.entity.Users;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultEPLKitsOrderService implements EPLKitsOrderService {
	
	@Autowired
	private EPLKitsOrderDao eplKitsOrderDao;

	@Override
	@Transactional
	public Orders createOrders(OrdersEntry ordersEntry) {
		log.info("Order={}", ordersEntry);
		Orders order = Orders.builder()
				.users(getUsers(ordersEntry))
				.teams(getTeams(ordersEntry))
				.shoes(getShoes(ordersEntry))
				.jerseys(getJerseys(ordersEntry))
				.shorts(getShorts(ordersEntry))
				.trainers(getTrainers(ordersEntry))								
				.build();
		
		return eplKitsOrderDao.saveOrder(order.getUsers(), order.getTeams(), order.getShoes(),
				order.getJerseys(), order.getShorts(), order.getTrainers());
		
	}
	
	@Override
	public Orders updateKit(OrdersEntry ordersEntry, Long ordersPK) {
		log.info("Updating order ID = {}: {}", ordersPK, ordersEntry);
		Orders order = Orders.builder()
				.users(getUsers(ordersEntry))
				.teams(getTeams(ordersEntry))
				.shoes(getShoes(ordersEntry))
				.jerseys(getJerseys(ordersEntry))
				.shorts(getShorts(ordersEntry))
				.trainers(getTrainers(ordersEntry))							
				.build();
		return eplKitsOrderDao.updateKit(order.getOrdersPK(), order.getUsers(), order.getTeams(), order.getShoes(),
				order.getJerseys(), order.getShorts(), order.getTrainers());
	}
	
	@Override
	@Transactional
	public Orders deleteKit(Long ordersPK) {
		log.info("Deleting order ID = {}", ordersPK);		
		return eplKitsOrderDao.deleteKit(ordersPK);
	}
	

	private Trainers getTrainers(OrdersEntry ordersEntry) {
		
		return eplKitsOrderDao.fetchTrainers(ordersEntry.getTrainers())
				.orElseThrow(() -> new NoSuchElementException("Trainers with ID="
						+ ordersEntry.getTrainers() + " was not found"));
	}

	private Shorts getShorts(OrdersEntry ordersEntry) {
		
		return eplKitsOrderDao.fetchShorts(ordersEntry.getShorts())
				.orElseThrow(() -> new NoSuchElementException("Shorts with ID="
						+ ordersEntry.getShorts() + " was not found"));
	}

	private Jerseys getJerseys(OrdersEntry ordersEntry) {
		
		return eplKitsOrderDao.fetchJerseys(ordersEntry.getJerseys())
				.orElseThrow(() -> new NoSuchElementException("Jersey with ID="
						+ ordersEntry.getJerseys() + " was not found"));
	}

	private Shoes getShoes(OrdersEntry ordersEntry) {
		
		return eplKitsOrderDao.fetchShoes(ordersEntry.getShoes())
				.orElseThrow(() -> new NoSuchElementException("Shoes with ID="
						+ ordersEntry.getShoes() + " was not found"));
	}

	private Teams getTeams(OrdersEntry ordersEntry) {
		
		return eplKitsOrderDao.fetchTeams(ordersEntry.getTeams())
				.orElseThrow(() -> new NoSuchElementException("Team with ID="
						+ ordersEntry.getTeams() + " was not found"));
	}

	private Users getUsers(OrdersEntry ordersEntry) {
		
		return eplKitsOrderDao.fetchUsers(ordersEntry.getUsers())
				.orElseThrow(() -> new NoSuchElementException("User with ID="
						+ ordersEntry.getUsers() + " was not found"));
	}

	

	

}
