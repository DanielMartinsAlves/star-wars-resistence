package com.letscode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letscode.entidade.Item;
import com.letscode.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	public Item adicionar(Item item) {
		return itemRepository.save(item);
	}

}
