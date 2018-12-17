package com.ifi.tp.service;

import org.springframework.web.client.RestTemplate;

public interface PokemonService {
    int getPokemonMaxHp(int pokemonId);

    public void setPokemonServiceUrl(String pokemonServiceUrl);
    public void setRestTemplate(RestTemplate restTemplate);
}
