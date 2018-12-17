package com.ifi.tp.pokeBoutique.services;

import com.ifi.tp.trainers.bo.Item;

import java.util.HashMap;

public interface PokeBoutiqueService {

    HashMap<Item, Integer> listProducts();

    void updateItemQuantity(Item item, int newQuantity);

}
