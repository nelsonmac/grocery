package com.ir.grocery.controllers;


import com.ir.grocery.models.MCategory;
import com.ir.grocery.repository.MCaregoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/grocery/category")
public class MCategoryConroller {



    @Autowired
    MCaregoryRepository mCaregoryRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public MCategory createUom(@Valid @RequestBody MCategory mCategory) {
        mCaregoryRepository.save(mCategory);
        return mCategory;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public MCategory getCategory(@PathVariable("id") String id) {
        return mCaregoryRepository.findById(id).get();

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Iterable<MCategory> getCategory() {
        return mCaregoryRepository.findAll();

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteCategory(@PathVariable("id") String id) {
        mCaregoryRepository.delete(mCaregoryRepository.findById(id).get());
        return "Deleted";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteAllCategory() {
        mCaregoryRepository.deleteAll();
        return "Deleted";

    }


}
