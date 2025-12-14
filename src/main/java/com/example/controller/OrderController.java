package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Order;
import com.example.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order)
	{
		return ResponseEntity.ok(orderService.createOrder(order));		
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders(){
		return ResponseEntity.ok(orderService.getAllOrders());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id)
	{
		return ResponseEntity.ok(orderService.getOrderById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> cancelOrder(@PathVariable Long id){
		orderService.cancelOrder(id);
		return ResponseEntity.noContent().build();
				
	}
}
