package com.ir.grocery;

import javax.validation.Valid;

import com.ir.grocery.models.MCategory;
import com.ir.grocery.repository.MCaregoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ir.grocery.models.MUom;
import com.ir.grocery.repository.MUomRepository;

@RestController
@RequestMapping("/grocery")
public class GroceryController {
	



	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void testService() {
		
		System.out.print("Reached");
	}
	


}
