package com.ir.grocery.controllers;


import com.ir.grocery.models.MCategory;
import com.ir.grocery.models.MCurrency;
import com.ir.grocery.repository.MCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/grocery/currency")
public class MCurrencyController {


    @Autowired
    MCurrencyRepository mCurrencyRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public MCurrency createUom(@Valid @RequestBody MCurrency mCurrency) {
        mCurrencyRepository.save(mCurrency);
        return mCurrency;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public MCurrency getCategory(@PathVariable("id") String id) {
        return mCurrencyRepository.findById(id).get();

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Iterable<MCurrency> getCategory() {
        return mCurrencyRepository.findAll();

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteCategory(@PathVariable("id") String id) {
        mCurrencyRepository.delete(mCurrencyRepository.findById(id).get());
        return "Deleted";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteAllCategory() {
        mCurrencyRepository.deleteAll();
        return "Deleted";

    }

}
