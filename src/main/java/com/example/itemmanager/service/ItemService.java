package com.example.itemmanager.service;

import com.example.itemmanager.model.Item;
import com.example.itemmanager.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Fetch all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Fetch an item by its ID
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id); // Handles database query
    }

    // Save a new or updated item
    public Item saveItem(Item item) {
        return itemRepository.save(item); // Handles persistence
    }

    // Delete an item by its ID
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
