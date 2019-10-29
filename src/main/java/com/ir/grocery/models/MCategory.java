package com.ir.grocery.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Document("mcategory")
public class MCategory {
	

    @Id
    private String id;
    @Indexed(name = "category_name_index", unique = true)
    private String name;
    private String description;
    private Boolean	isDeleted = false;
    
    
    
    protected MCategory() {}
    
	public MCategory(String name, String description) {
		this.name = name;
		this.description = description;
		this.isDeleted = false;
	}
	
	@Override
    public String toString() {
        return String.format(
                "category[id=%d, name='%s', description='%s']",
                id, name, description);
    }
}
