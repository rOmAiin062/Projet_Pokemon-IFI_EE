package com.ifi.tp.trainers.bo;

import com.ifi.tp.pokemonTypes.bo.PokemonType;


public class Pokemon {

    private Integer id;
    private Integer hp;
    private Integer pokemonNumber;
    private Integer level;
    private PokemonType pokemonType;

    public Pokemon()
    {

    }

    public Pokemon(Integer id, Integer hp, Integer pokemonNumber, Integer level, PokemonType pokemonType) {
        this.id = id;
        this.hp = hp;
        this.pokemonNumber = pokemonNumber;
        this.level = level;
        this.pokemonType = pokemonType;
    }

    public Pokemon(Integer hp, Integer pokemonNumber, Integer level, PokemonType pokemonType) {
        this.hp = hp;
        this.pokemonNumber = pokemonNumber;
        this.level = level;
        this.pokemonType = pokemonType;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getPokemonNumber() {
        return pokemonNumber;
    }

    public void setPokemonNumber(Integer pokemonNumber) {
        this.pokemonNumber = pokemonNumber;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }
}
