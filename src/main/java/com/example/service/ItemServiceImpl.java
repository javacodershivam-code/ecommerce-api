package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Item;
import com.example.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Item createItem(Item item) {
		 return itemRepository.save(item);
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public Item getItemById(Long id) {
		return itemRepository.findById(id)
                			 .orElseThrow(() -> new RuntimeException("Item not found"));
	}

	@Override
	public Item updateItem(Long id, Item item) {
		Item exist = getItemById(id);
		exist.setName(item.getName());
		exist.setDescription(item.getDescription());
		exist.setPrice(item.getPrice());
		exist.setCategories(item.getCategories());		
		return itemRepository.save(exist);
	}

	@Override
	public void deleteItem(Long id) {
		itemRepository.deleteById(id);		
	}	

}
