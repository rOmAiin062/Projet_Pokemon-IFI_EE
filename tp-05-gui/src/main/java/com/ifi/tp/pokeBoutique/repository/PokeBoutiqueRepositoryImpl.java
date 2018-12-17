package com.ifi.tp.pokeBoutique.repository;

import com.ifi.tp.pokeBoutique.bo.PokeBoutique;
import com.ifi.tp.trainers.bo.Item;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PokeBoutiqueRepositoryImpl implements PokeBoutiqueRepository {

    private PokeBoutique pokeboutique;

    @Override
    public PokeBoutique save(PokeBoutique pokeBoutique) {
        this.pokeboutique = pokeBoutique;
        return  pokeBoutique;
    }

    @Override
    public HashMap<Item, Integer> findAll() {
        return this.pokeboutique.getAvailablesProducts();
    }

    @Override
    public void update(Item item, int newQuantity) {
        HashMap<Item, Integer> availablesProducts = this.pokeboutique.getAvailablesProducts();
        availablesProducts.put(item, newQuantity);
    }
}
