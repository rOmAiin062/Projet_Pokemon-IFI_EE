package com.ifi.tp.bo;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private int id;

    @Lob
    private String img;
    private String name;
    private int buying_price;


    public Item(String name, String img, int buying_price) {
        this.name = name;
        this.img = img;
        this.buying_price = buying_price;
    }

    public Item(){
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getBuying_price() {
        return buying_price;
    }

    public void setBuying_price(int buying_price) {
        this.buying_price = buying_price;
    }

}
