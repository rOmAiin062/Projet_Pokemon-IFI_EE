package com.ifi.tp.controller;

import com.ifi.tp.fight.bo.Fight;
import com.ifi.tp.fight.services.FightService;
import com.ifi.tp.pokemonTypes.bo.PokemonType;
import com.ifi.tp.pokemonTypes.services.PokemonService;
import com.ifi.tp.trainers.bo.Trainer;
import com.ifi.tp.trainers.services.TrainersService;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class TrainersController {

    private TrainersService trainersService;
    private PokemonService pokemonService;
    private FightService fightService;

    @Autowired
    public TrainersController(TrainersService trainersService,
                              PokemonService pokemonService,
                              FightService fightService) {
        this.trainersService = trainersService;
        this.pokemonService = pokemonService;
        this.fightService = fightService;
    }



    @GetMapping("/trainers")
    public ModelAndView trainers() {
        ModelAndView modelAndView = new ModelAndView("trainers");

        List<Trainer> trainersList = this.trainersService.listTrainers();
        for(Trainer trainer : trainersList){
            for(int i = 0; i < trainer.getTeam().size(); i++)
            {
                int idPokemon = trainer.getTeam().get(i).getPokemonNumber();
                PokemonType pokemonType = this.pokemonService.getPokemonTypeById(idPokemon);
                trainer.getTeam().get(i).setPokemonType(pokemonType);
            }
        }

        modelAndView.addObject("trainers", trainersList);
        return modelAndView;
    }

    @GetMapping("/trainers/{trainer}")
    public ModelAndView trainer(@PathVariable String trainer)
    {
        ModelAndView modelAndView = new ModelAndView("trainers");

        Trainer trainer_ = this.trainersService.getTrainer(trainer);
        for(int i = 0; i < trainer_.getTeam().size(); i++)
        {
            int idPokemon = trainer_.getTeam().get(i).getPokemonNumber();
            PokemonType pokemonType = this.pokemonService.getPokemonTypeById(idPokemon);
            trainer_.getTeam().get(i).setPokemonType(pokemonType);
        }

        modelAndView.addObject("trainers", trainer_);
        modelAndView.addObject("pagePerso", true);
        return modelAndView;
    }

    @GetMapping("/trainers/{trainer}/fights")
    public ModelAndView trainerFight(@PathVariable String trainer)
    {
        ModelAndView modelAndView = new ModelAndView("trainerFight");

        List<Fight> fights = this.fightService.getFightsByTrainerName(trainer);

        modelAndView.addObject("fights", fights);
        modelAndView.addObject("name", trainer);
        return modelAndView;
    }

    @GetMapping("trainers/{trainer}/fights/{id_fight}")
    public ModelAndView trainerFightDetail(@PathVariable String trainer, @PathVariable int id_fight) {
        ModelAndView modelAndView = new ModelAndView("trainerFightDetail");

        Set<Map.Entry<Integer, String>> entrySet = null;
        List<String> logsS = null;
        List<Integer> logsI = null;
        List<Fight> fights = this.fightService.getFightsByTrainerName(trainer);
        for(Fight f : fights)
        {
            if(f.getId() == id_fight) {
                modelAndView.addObject("fight", f);
                entrySet = f.getLogs().entrySet();
                logsS = new ArrayList<String>(f.getLogs().values());
                logsI = new ArrayList<>(f.getLogs().keySet());
                break;
            }
        }
        modelAndView.addObject("logs", entrySet);
        modelAndView.addObject("logsI", logsI);
        modelAndView.addObject("logsS", logsS);
        modelAndView.addObject("name",trainer);
        return modelAndView;
    }

    @GetMapping("trainers/{trainer}/arena")
    public ModelAndView arena(@PathVariable String trainer)
    {
        ModelAndView modelAndView = new ModelAndView("arena");

        List<Trainer> trainers = this.trainersService.listTrainers();
        List<Trainer> trainersF = new ArrayList<Trainer>();
        int idxTrainer = -1;
        for(int i = 0; i < trainers.size(); i++)
        {
            if(trainers.get(i).getName().toLowerCase().equals(trainer.toLowerCase()) == false)
            {
                trainersF.add(trainers.get(i));
            }

        }


        modelAndView.addObject("trainers", trainersF);
        modelAndView.addObject("trainerName", trainer);

        return modelAndView;
    }

    @GetMapping("trainers/{trainer1}/fight/{trainer2}")
    public void startFight(@PathVariable String trainer1, @PathVariable String trainer2)
    {
        this.fightService.startFight(trainer1, trainer2);
    }
}
