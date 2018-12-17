package com.ifi.tp.controller;

import com.ifi.tp.pokemonTypes.bo.PokemonType;
import com.ifi.tp.pokemonTypes.services.PokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PokemonControllerTest {

    @Test
    void controllerShouldBeAnnotated(){
        assertNotNull(PokemonController.class.getAnnotation(Controller.class));
    }

    @Test
    void pokemons_shouldReturnAModelAndView() {
        var pokemonService = mock(PokemonService.class);

        when(pokemonService.listPokemonsTypes()).thenReturn(List.of(new PokemonType(), new PokemonType()));

        var pokemonController = new PokemonController(pokemonService);
        var modelAndView = pokemonController.pokemons();

        assertEquals("pokemons", modelAndView.getViewName());
        var pokemons = (List<PokemonType>)modelAndView.getModel().get("pokemons");
        assertEquals(2, pokemons.size());
        verify(pokemonService).listPokemonsTypes();
    }

    @Test
    void pokmeons_shouldBeAnnotated() throws NoSuchMethodException {
        var pokemonsMethod = PokemonController.class.getMethod("pokemons");
        var getMapping = pokemonsMethod.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/pokemons"}, getMapping.value());
    }

}
