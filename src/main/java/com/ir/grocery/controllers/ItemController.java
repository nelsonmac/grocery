package com.ir.grocery.controllers;


import com.ir.grocery.models.Item;
import com.ir.grocery.models.MUom;
import com.ir.grocery.repository.ItemRepository;
import com.ir.grocery.repository.MUomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/grocery/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public Item createItem(@Valid @RequestBody Item item) {
        itemRepository.save(item);
        return item;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable("id") String id) {
        return itemRepository.findById(id).get();

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Iterable<Item> getItem() {
        return itemRepository.findAll();

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteItem(@PathVariable("id") String id) {
        itemRepository.delete(itemRepository.findById(id).get());
        return "Deleted";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteAllItems() {
        itemRepository.deleteAll();
        return "Deleted";

    }
}
