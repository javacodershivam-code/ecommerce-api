package com.example.entity;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Data
@Table(name="order_items")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "item_id")
    private Item item;
	
	@Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
	
	@NotNull
    private BigDecimal price;
}

