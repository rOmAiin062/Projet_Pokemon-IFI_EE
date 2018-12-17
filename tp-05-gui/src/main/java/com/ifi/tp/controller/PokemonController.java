package com.ifi.tp.controller;

import com.ifi.tp.pokemonTypes.bo.PokemonType;
import com.ifi.tp.pokemonTypes.services.PokemonService;
import com.ifi.tp.trainers.bo.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {

        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemons")
    public ModelAndView pokemons() {
        ModelAndView modelAndView = new ModelAndView("pokemons");
        modelAndView.addObject("pokemons", this.pokemonService.listPokemonsTypes());
        return modelAndView;
    }

    @GetMapping("/pokemons/{id}")
    public ModelAndView pokemonById(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("pokemons");
        List<PokemonType> pokemonTypes = new ArrayList<PokemonType>();
        PokemonType pokemonType = this.pokemonService.getPokemonTypeById(id);
        pokemonTypes.add(pokemonType);
        modelAndView.addObject("pokemons", pokemonTypes);
        return modelAndView;
    }
}
