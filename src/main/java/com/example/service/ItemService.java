package com.example.service;

import java.util.List;

import com.example.entity.Item;

public interface ItemService {
	Item createItem(Item item);
	List<Item> getAllItems();
	Item getItemById(Long id);
	Item updateItem(Long id,Item item);
	void deleteItem(Long id);

}
