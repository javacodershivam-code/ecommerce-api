package com.example.service;

import java.util.List;

import com.example.entity.Order;

public interface OrderService {

	Order createOrder(Order order);
	List<Order> getAllOrders();
	Order getOrderById(Long id);
	void cancelOrder(Long id);
	
	
}
