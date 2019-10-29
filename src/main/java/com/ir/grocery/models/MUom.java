package com.ir.grocery.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter @Document("muom")
public class MUom {
	

    @Id
    private String id;

    @Indexed(name = "uom_name_index", unique = true)
    private String name;
    private String description;
    private Boolean	isDeleted = false;
    
    
    
    protected MUom() {}
    
	public MUom(String name, String description) {
		this.name = name;
		this.description = description;
		this.isDeleted = false;
	}
	
	@Override
    public String toString() {
        return String.format(
                "uom[id=%d, name='%s', description='%s']",
                id, name, description);
    }
    
}
