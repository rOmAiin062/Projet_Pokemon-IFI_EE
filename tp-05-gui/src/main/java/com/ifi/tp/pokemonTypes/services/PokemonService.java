package com.ifi.tp.pokemonTypes.services;

import com.ifi.tp.pokemonTypes.bo.PokemonType;
import java.util.List;

public interface PokemonService {

    List<PokemonType> listPokemonsTypes();

    PokemonType getPokemonTypeById(int id);

}
