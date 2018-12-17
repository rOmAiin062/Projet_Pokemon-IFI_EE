package com.ifi.tp.pokeBoutique.repository;

import com.ifi.tp.pokeBoutique.bo.PokeBoutique;
import com.ifi.tp.trainers.bo.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

public interface PokeBoutiqueRepository{
    PokeBoutique save(PokeBoutique pokeBoutique);
    HashMap<Item, Integer> findAll();

    void update(Item item, int newQuantity);
}
