package com.ir.grocery.controllers;


import com.ir.grocery.models.PriceHistory;
import com.ir.grocery.repository.PriceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grocery/pricehistory")
public class PriceHistoryController {

    @Autowired
    PriceHistoryRepository priceHistoryRepository;




    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public PriceHistory getPriceHistory(@PathVariable("id") String id) {
        return priceHistoryRepository.findById(id).get();

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Iterable<PriceHistory> getPriceHistory() {
        return priceHistoryRepository.findAll();

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String id) {
        priceHistoryRepository.delete(priceHistoryRepository.findById(id).get());
        return "Deleted";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteAll() {
        priceHistoryRepository.deleteAll();
        return "Deleted";

    }
}
