package com.ir.grocery.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;


@Getter @Setter @AllArgsConstructor
@Document("mcurrency")
public class MCurrency {


    @Id
    private String id;
    private String name;
    @Indexed(name = "currency_code_index", unique = true)
    @Size(min = 3, max =3)
    private String code;
    @Size(min = 2, max =2)
    private String countryCode;
    private Boolean	isDeleted = false;

    public MCurrency(){
        this.isDeleted = false;
    };


	@Override
    public String toString() {
        return String.format(
                "uom[id=%d, name='%s']",
                id, name);
    }
    
}
