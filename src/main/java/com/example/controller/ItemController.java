package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Item;
import com.example.service.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	
	@Autowired
    private ItemService itemService;	
	
	@PostMapping
	public ResponseEntity<Item> createItem(@Valid @RequestBody Item item){
		return new ResponseEntity<>(itemService.createItem(item), HttpStatus.CREATED);		
	}
	
	@GetMapping
	public ResponseEntity<List<Item>> getAllItems()
	{
		return ResponseEntity.ok(itemService.getAllItems());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long id)
	{
		return ResponseEntity.ok(itemService.getItemById(id));
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<Item> updateItem(@PathVariable Long id,@Valid @RequestBody Item item)
	{
		return ResponseEntity.ok(itemService.updateItem(id, item));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>  deleteItem(@PathVariable Long id){
		itemService.deleteItem(id);
		return ResponseEntity.noContent().build();
	}

}
