package com.ifi.tp.pokeBoutique.services;

import com.ifi.tp.pokeBoutique.bo.PokeBoutique;
import com.ifi.tp.pokeBoutique.repository.PokeBoutiqueRepository;
import com.ifi.tp.trainers.bo.Item;
import com.ifi.tp.trainers.bo.Pokeball;
import com.ifi.tp.trainers.bo.Potion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PokeBoutiqueServiceImpl implements PokeBoutiqueService {

    private PokeBoutiqueRepository pokeBoutiqueRepository;

    @Autowired
    public PokeBoutiqueServiceImpl(PokeBoutiqueRepository pokeBoutiqueRepository)
    {
        this.pokeBoutiqueRepository = pokeBoutiqueRepository;
        PokeBoutique pokeBoutique = new PokeBoutique();
        var products = new HashMap<Item, Integer>();
        products.put(Pokeball.pokeball, 5);
        products.put(Pokeball.superball, 5);
        products.put(Potion.potion, 5);
        products.put(Potion.superPotion, 5);
        pokeBoutique.setAvailablesProducts(products);
        pokeBoutique.setId(1);
        this.pokeBoutiqueRepository.save(pokeBoutique);
    }

    @Override
    public HashMap<Item, Integer> listProducts() {
        return this.pokeBoutiqueRepository.findAll();
    }

    @Override
    public void updateItemQuantity(Item item, int newQuantity) {
        this.pokeBoutiqueRepository.update(item, newQuantity);
    }


}
