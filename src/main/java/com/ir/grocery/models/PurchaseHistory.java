package com.ir.grocery.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Document("purchase_history")
public class PurchaseHistory {

    @Id
    private String id;

    @DBRef
    private Item item;
    @DBRef
    private Users user;
    private Long price;
    private Date datetime;
    private Float qty;
    private Boolean isDeleted;
    private Boolean exclude;

    public PurchaseHistory(){
        this.isDeleted = false;
        this.exclude = false;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Date getDatetime() {
        return datetime;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return String.format(
                "uom[id=%d, item='%s', price='%s']",
                id, item, price);
    }


}
