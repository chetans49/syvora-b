package com.example.itemmanager.controller;

import com.example.itemmanager.model.Item;
import com.example.itemmanager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id) // Call the service method
                .map(ResponseEntity::ok)  // If present, return 200 OK with the item
                .orElse(ResponseEntity.notFound().build()); // If not present, return 404 Not Found
    }
    

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @PutMapping("/{id}")
public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
    return itemService.getItemById(id).map(item -> {
        // Update only non-null fields
        item.setName(itemDetails.getName() != null ? itemDetails.getName() : item.getName());
        item.setDescription(itemDetails.getDescription() != null ? itemDetails.getDescription() : item.getDescription());
        // Save the updated item
        return ResponseEntity.ok(itemService.saveItem(item));
    }).orElse(ResponseEntity.notFound().build()); // Return 404 if item not found
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (itemService.getItemById(id).isPresent()) {
            itemService.deleteItem(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

    @ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, String field, Object value) {
        super(String.format("%s not found with %s : '%s'", resource, field, value));
    }
}

    
}
