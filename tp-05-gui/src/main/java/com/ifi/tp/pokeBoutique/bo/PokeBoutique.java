package com.ifi.tp.pokeBoutique.bo;

import com.ifi.tp.trainers.bo.Item;

import javax.persistence.*;
import java.util.HashMap;

@Entity
public class PokeBoutique {

    @Id
    private int id;

    private HashMap<Item, Integer> availablesProducts;

    public PokeBoutique(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Item, Integer> getAvailablesProducts() {
        return availablesProducts;
    }

    public void setAvailablesProducts(HashMap<Item, Integer> availablesProducts) {
        this.availablesProducts = availablesProducts;
    }

}
