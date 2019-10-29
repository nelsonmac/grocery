package com.ir.grocery.controllers;


import com.ir.grocery.models.Users;
import com.ir.grocery.repository.UserRepository;
import com.ir.grocery.services.MongoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/grocery/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    MongoUserDetailsService mongoUserDetailsService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public Users createItem(@Valid @RequestBody Users user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Users getItem(@PathVariable("id") String id) {
        return userRepository.findById(id).get();

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Iterable<Users> getItem() {
        return userRepository.findAll();

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteItem(@PathVariable("id") String id) {
        userRepository.delete(userRepository.findById(id).get());
        return "Deleted";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteAllItems() {
        userRepository.deleteAll();
        return "Deleted";

    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Boolean login(@Valid @RequestBody Users user){

        return mongoUserDetailsService.validateUser(user);
    }
}
