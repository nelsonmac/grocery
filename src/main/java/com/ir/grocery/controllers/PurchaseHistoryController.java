package com.ir.grocery.controllers;


import com.ir.grocery.models.Item;
import com.ir.grocery.models.PriceHistory;
import com.ir.grocery.models.PurchaseHistory;
import com.ir.grocery.models.Users;
import com.ir.grocery.repository.ItemRepository;
import com.ir.grocery.repository.PriceHistoryRepository;
import com.ir.grocery.repository.PurchaseHistoryRepository;
import com.ir.grocery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/grocery/ph")
public class PurchaseHistoryController {

    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    PriceHistoryRepository priceHistoryRepository;


    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public PurchaseHistory createPurchaseHistory(@Valid @RequestBody PurchaseHistory purchaseHistory) {

        if(purchaseHistory.getUser().getId() == null) {
            Users user = userRepository.findByEmail(purchaseHistory.getUser().getEmail());
            purchaseHistory.setUser(user);
        }

        if (purchaseHistory.getDatetime() == null){
            purchaseHistory.setDatetime(new Date());
        }
        Item item = itemRepository.findById(purchaseHistory.getItem().getId()).get();
        if(purchaseHistory.getItem().getPricePerUnit() != item.getPricePerUnit()){
            //price update for the item
            item.setPricePerUnit(purchaseHistory.getItem().getPricePerUnit());
            itemRepository.save(item);

            priceHistoryRepository.save(new PriceHistory(item,purchaseHistory.getItem().getPricePerUnit()));


        }
        purchaseHistoryRepository.save(purchaseHistory);
        return purchaseHistory;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public PurchaseHistory getPurchaseHistory(@PathVariable("id") String id) {
        return purchaseHistoryRepository.findById(id).get();

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Iterable<PurchaseHistory> getPurchaseHistory() {
        return purchaseHistoryRepository.findAll();

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deletePurchaseHistory(@PathVariable("id") String id) {
        purchaseHistoryRepository.delete(purchaseHistoryRepository.findById(id).get());
        return "Deleted";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteAll() {
        purchaseHistoryRepository.deleteAll();
        return "Deleted";

    }
}
