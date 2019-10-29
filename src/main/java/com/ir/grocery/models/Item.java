package com.ir.grocery.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document("item")
public class Item {

    @Id
    String id;
    String name;
    @DBRef
    MCategory category;
    @DBRef
    MUom uom;
    @DBRef
    MCurrency currency;
    Float defaultQty;
    Long pricePerUnit;
    Boolean isDeleted = false;


    protected Item() {
    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Long pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return String.format(
                "category[id=%d, name='%s']",
                id, name);
    }

}
