package com.ifi.tp;

import com.ifi.tp.pokeBoutique.bo.PokeBoutique;
import com.ifi.tp.pokeBoutique.repository.PokeBoutiqueRepository;
import com.ifi.tp.trainers.bo.Item;
import com.ifi.tp.trainers.bo.Pokeball;
import com.ifi.tp.trainers.bo.Potion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class TrainerWebApp {

    public static void main(String... args){
        SpringApplication.run(TrainerWebApp.class, args);
    }

}
