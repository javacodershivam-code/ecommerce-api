package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Order;
import com.example.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		order.setOrderDate(LocalDateTime.now());
		order.setStatus("cretaed");
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(Long id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id)
							  .orElseThrow(()-> new RuntimeException("Order not found"));
	}

	@Override
	public void cancelOrder(Long id) {
		// TODO Auto-generated method stub
		Order cancel= getOrderById(id);
		cancel.setStatus("Status");
		orderRepository.save(cancel);
	}

}
