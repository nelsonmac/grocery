package com.ir.grocery.controllers;


import com.ir.grocery.models.MUom;
import com.ir.grocery.repository.MUomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/grocery/uom")
public class MUomController {

    @Autowired
    private MUomRepository mUomRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public MUom createUom(@Valid @RequestBody MUom uom) {
        mUomRepository.save(uom);
        return uom;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public MUom getUom(@PathVariable("id") String id) {
        return mUomRepository.findById(id).get();

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Iterable<MUom> getUom() {
        return mUomRepository.findAll();

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteUom(@PathVariable("id") String id) {
        mUomRepository.delete(mUomRepository.findById(id).get());
        return "Deleted";

    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteAll() {
        mUomRepository.deleteAll();
        return "Deleted";

    }
}
