	package com.example.entity;

import java.math.BigDecimal;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.JoinColumn;


@Entity
@Data
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotBlank
	private String name;
	
	private String description;
	
	@NotNull
	@Positive
	private BigDecimal price;
	@ManyToMany
	@JoinTable(
		    name = "item_categories",
		    joinColumns  = @JoinColumn(name = "item_id"),
		    inverseJoinColumns = @JoinColumn(name = "category_id")
		)
	private Set<Category> categories;
}
