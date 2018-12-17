package com.ifi.tp.controller;

import com.ifi.tp.fight.bo.Fight;
import com.ifi.tp.fight.services.FightService;
import com.ifi.tp.pokemonTypes.services.PokemonService;
import com.ifi.tp.trainers.bo.Pokemon;
import com.ifi.tp.trainers.bo.Trainer;
import com.ifi.tp.trainers.services.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/fight")
public class FightController {

    private FightService fightService;
    private TrainersService trainersService;
    private PokemonService pokemonService;

    private int positionPokemonFighterTrainer1 = 0;
    private int positionPokemonFighterTrainer2 = 0;

    private int pokemonAliveTrainer1 = 0;
    private int pokemonAliveTrainer2 = 0;

    private int idPokemonTrainer1 = 0;
    private int idPokemonTrainer2 = 0;

    private int speedPokemonTrainer1 = 0;
    private int speedPokemonTrainer2 = 0;

    private int nbTours = 1;
    private int nbLogs = 0;

    private HashMap<Integer, String> logs;

    @Autowired
    FightController(FightService fightService ,TrainersService trainersService, PokemonService pokemonService)
    {
        this.fightService = fightService;
        this.trainersService = trainersService;
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{trainerName1}/{trainerName2}")
    public void runFight(@PathVariable String trainerName1, @PathVariable String trainerName2)
    {
        Fight fight = new Fight();
        fight.setTrainerName1(trainerName1);
        fight.setTrainerName2(trainerName2);

        logs = new HashMap<>();
        nbLogs = 0;

        Trainer trainer1 = trainersService.getTrainer(trainerName1);
        Trainer trainer2 = trainersService.getTrainer(trainerName2);


        List<Pokemon> teamTrainer1 = trainer1.getTeam();
        List<Pokemon> teamTrainer2 = trainer2.getTeam();

        pokemonAliveTrainer1 = trainer1.getTeam().size();
        pokemonAliveTrainer2 = trainer2.getTeam().size();

        positionPokemonFighterTrainer1 = 0;
        positionPokemonFighterTrainer2 = 0;

        nbTours = 1;
        int newIdPosition;

        while(pokemonAliveTrainer1 > 0 && pokemonAliveTrainer2 > 0)
        {
            idPokemonTrainer1 = trainer1.getTeam().get(positionPokemonFighterTrainer1).getPokemonNumber();
            idPokemonTrainer2 = trainer2.getTeam().get(positionPokemonFighterTrainer2).getPokemonNumber();
            speedPokemonTrainer1 = trainer1.getTeam().get(positionPokemonFighterTrainer1).getLevel() + this.pokemonService.getPokemonTypeById(idPokemonTrainer1).getStats().getSpeed();
            speedPokemonTrainer2 = trainer2.getTeam().get(positionPokemonFighterTrainer2).getLevel() + this.pokemonService.getPokemonTypeById(idPokemonTrainer2).getStats().getSpeed();

            if(speedPokemonTrainer1 >= speedPokemonTrainer2) // Trainer 1 START
            {
                System.out.println("=======================");
                System.out.println("NOMBRE DE TOURS = " + nbTours);
                System.out.println("=======================");

                String msg = this.pokemonService.getPokemonTypeById(trainer1.getTeam().get(positionPokemonFighterTrainer1).getPokemonNumber()).getName() + " hits first. ";
                System.out.println(msg);
                logs.put(nbLogs++, msg);
                newIdPosition = this.fight(trainer1, positionPokemonFighterTrainer1, trainer2, positionPokemonFighterTrainer2);
                pokemonAliveTrainer2 = (newIdPosition == positionPokemonFighterTrainer2) ? pokemonAliveTrainer2 : pokemonAliveTrainer2-1; // Si le nv id a pas changé, pas de pokemon ko.
                positionPokemonFighterTrainer2 = newIdPosition;

                this.trainersService.updateTrainer(trainer1);
                this.trainersService.updateTrainer(trainer2);
                if(pokemonAliveTrainer2 == 0) break;

                newIdPosition = this.fight(trainer2, positionPokemonFighterTrainer2, trainer1, positionPokemonFighterTrainer1);
                pokemonAliveTrainer1 = (newIdPosition == positionPokemonFighterTrainer1) ? pokemonAliveTrainer1 : pokemonAliveTrainer1-1; // Si le nv id a pas changé, pas de pokemon ko.

                positionPokemonFighterTrainer1 = newIdPosition;
                this.trainersService.updateTrainer(trainer1);
                this.trainersService.updateTrainer(trainer2);
                nbTours++;
            }
            else // Trainer 2 START
            {
                System.out.println("=======================");
                System.out.println("NOMBRE DE TOURS = " + nbTours);
                System.out.println("=======================");

                String msg = this.pokemonService.getPokemonTypeById(trainer2.getTeam().get(positionPokemonFighterTrainer2).getPokemonNumber()).getName() + " hits first. ";
                System.out.println(msg);
                logs.put(nbLogs++, msg);

                newIdPosition = this.fight(trainer2, positionPokemonFighterTrainer2, trainer1, positionPokemonFighterTrainer1);
                pokemonAliveTrainer1 = (newIdPosition == positionPokemonFighterTrainer1) ? pokemonAliveTrainer1 : pokemonAliveTrainer1-1; // Si le nv id a pas changé, pas de pokemon ko.
                positionPokemonFighterTrainer1 = newIdPosition;

                this.trainersService.updateTrainer(trainer1);
                this.trainersService.updateTrainer(trainer2);

                if(pokemonAliveTrainer1 == 0) break;

                newIdPosition = this.fight(trainer1, positionPokemonFighterTrainer1, trainer2, positionPokemonFighterTrainer2);
                pokemonAliveTrainer2 = (newIdPosition == positionPokemonFighterTrainer2) ? pokemonAliveTrainer2 : pokemonAliveTrainer2-1; // Si le nv id a pas changé, pas de pokemon ko.
                positionPokemonFighterTrainer2 = newIdPosition;

                this.trainersService.updateTrainer(trainer1);
                this.trainersService.updateTrainer(trainer2);

                nbTours++;
            }

            this.trainersService.updateTrainer(trainer1);
            this.trainersService.updateTrainer(trainer2);
            //nbTours++;
        }

        fight.setNbTours(nbTours);
        String winner = (pokemonAliveTrainer1 > 0) ? trainerName1 : trainerName2;

        System.out.println(winner + " wins !");
        logs.put(nbLogs++, winner + " wins !");

        fight.setWinner(winner);
        fight.setLogs(logs);
        this.fightService.saveFight(fight);
        System.out.println("END OF THE FIGHT.");
    }


    @GetMapping("/{trainerName}")
    public List<Fight> getFightByTrainer(@PathVariable String trainerName)
    {
        List<Fight> fights = this.fightService.getFightsByTrainerName(trainerName);
        return  fights;
    }


    @GetMapping("")
    public Iterable<Fight> getAllFights()
    {
        return this.fightService.getAllFights();
    }

    // PokemonFirst attack first / PokemonSecond attack second
    private int getDegat(Pokemon pokemonFirst, Pokemon pokemonSecond) {
        int theoriqueDebat = 0;
        int reelDegat = 0;


        int attaquePokemonFirst = pokemonFirst.getLevel() + this.pokemonService.getPokemonTypeById(pokemonFirst.getPokemonNumber()).getStats().getAttack();

        int defensePokemonSecond = pokemonSecond.getLevel() + this.pokemonService.getPokemonTypeById(pokemonSecond.getPokemonNumber()).getStats().getDefense();

        theoriqueDebat = attaquePokemonFirst - defensePokemonSecond;
        reelDegat = (theoriqueDebat > 0) ? theoriqueDebat : 1;

        return reelDegat;
    }

    private int checkStateOfPokemon(Trainer trainer, int positionPokemonDefense) {
        if(trainer.getTeam().get(positionPokemonDefense).getHp() <= 0)
        {
            if(positionPokemonDefense + 1 < trainer.getTeam().size()) {
                String msg = this.pokemonService.getPokemonTypeById(trainer.getTeam().get(positionPokemonDefense).getPokemonNumber()).getName() + " is KO. "
                        + this.pokemonService.getPokemonTypeById(trainer.getTeam().get(positionPokemonDefense + 1).getPokemonNumber()).getName() + " enters battle ! ";
                System.out.println(msg);
                logs.put(nbLogs++, msg);

            }
            else {
                String msg = this.pokemonService.getPokemonTypeById(trainer.getTeam().get(positionPokemonDefense).getPokemonNumber()).getName() + " is KO. No more Pokemon available. ";
                System.out.print(msg);
                logs.put(nbLogs++, msg);
            }
            return positionPokemonDefense+1;
        }
        return positionPokemonDefense;
    }

    private int fight(Trainer trainerAttaquant, int positionPokemonAttaquant, Trainer trainerDefense, int positionPokemonDefense){

        int degat = getDegat(trainerAttaquant.getTeam().get(positionPokemonAttaquant), trainerDefense.getTeam().get(positionPokemonDefense));
        int hp = trainerDefense.getTeam().get(positionPokemonDefense).getHp();

        if(hp - degat >= 0)
            trainerDefense.getTeam().get(positionPokemonDefense).setHp(hp - degat);
        else
            trainerDefense.getTeam().get(positionPokemonDefense).setHp(0);

        int idPokemonAttaquant = trainerAttaquant.getTeam().get(positionPokemonAttaquant).getPokemonNumber();
        int idPokemonDefense = trainerDefense.getTeam().get(positionPokemonDefense).getPokemonNumber();

        String msg = this.pokemonService.getPokemonTypeById(idPokemonAttaquant).getName() + " hits. " +
                this.pokemonService.getPokemonTypeById(idPokemonDefense).getName() + " loses " + degat + " HP.";
        System.out.println(msg);
        logs.put(nbLogs++, msg);

        int newPositionPokemonDefense = checkStateOfPokemon(trainerDefense, positionPokemonDefense);
        return  newPositionPokemonDefense;
    }


}
