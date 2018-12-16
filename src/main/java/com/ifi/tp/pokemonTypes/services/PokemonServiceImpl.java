package com.ifi.tp.pokemonTypes.services;

import com.ifi.tp.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService{

    private RestTemplate restTemplate;
    private String pokemonServiceUrl;

    @Autowired
    public PokemonServiceImpl(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    public List<PokemonType> listPokemonsTypes() {
       PokemonType[] pokemonTypes = restTemplate.getForObject(pokemonServiceUrl + "/pokemons", PokemonType[].class);
       return Arrays.asList(pokemonTypes);
    }

    @Override
    public PokemonType getPokemonTypeById(int id) {
        return restTemplate.getForObject(pokemonServiceUrl + "/pokemons/" + id, PokemonType.class);
    }

    @Value("${pokemon.service.url}")
    void setPokemonServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }
}
