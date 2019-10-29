package com.ir.grocery.models;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@AllArgsConstructor
@Document("price_history")
public class PriceHistory {

    @Id
    private String Id;

    @DBRef
    @Indexed(name = "price_his_item_index")
    private Item item;

    private Long price;
    private Date datetime;
    private Boolean isDeleted;

    public PriceHistory(Item item, Long price){

        this.item = item;
        this.price = price;
        this.datetime = new Date();
        this.isDeleted = false;

    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
