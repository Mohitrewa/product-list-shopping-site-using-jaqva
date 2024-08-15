package com.springboot.exceptionhandling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exceptionhandling.models.Item;
import com.springboot.exceptionhandling.repositories.ItemRepository;



@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepo;

    @GetMapping("/get-all-items")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemRepo.getAllItems();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }
    
    @GetMapping("/get")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @PostMapping(value = "/addItem",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> addItem(@RequestBody Item item){
        itemRepo.addItem(item);
        return new ResponseEntity<Item>(item, HttpStatus.CREATED);
    }
}
