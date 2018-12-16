package com.ifi.tp.fight.services;

import com.ifi.tp.fight.bo.Fight;
import com.ifi.tp.fight.repository.FightRepository;
import com.ifi.tp.trainers.bo.Pokemon;
import com.ifi.tp.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FightServiceImpl implements FightService {

    @Autowired
    private FightRepository fightRepository;

    private Fight fight;

    @Autowired
    public FightServiceImpl(FightRepository fightRepository) {
        this.fightRepository = fightRepository;
    }

    @Override
    public void startFight(Trainer trainer1, Trainer trainer2) {
        this.fight = new Fight(trainer1, trainer2);


        while(fight.getNbAlivePokemonOfTrainer1() > 0 && fight.getNbAlivePokemonOfTrainer2() > 0)
        {

            int speedPokemonTrainer1 = fight.getAttackingPokemonOfTrainer1().getPokemonType().getStats().getSpeed();
            int speedPokemonTrainer2 = fight.getAttackingPokemonOfTrainer2().getPokemonType().getStats().getSpeed();

            // Pokemon Trainer 1 START
            if(speedPokemonTrainer1 >= speedPokemonTrainer2)
            {
                System.out.println(this.fight.getAttackingPokemonOfTrainer1().getPokemonType().getName() + " hits first");

                // Attack TRAINER 1
                int reelDegat = attack("trainer1");
                int hpPokemonTrainer2 = this.fight.getAttackingPokemonOfTrainer2().getHp();
                this.fight.getAttackingPokemonOfTrainer2().setHp(hpPokemonTrainer2 - reelDegat);

                System.out.println(this.fight.getAttackingPokemonOfTrainer1().getPokemonType().getName() + " hits." +
                        this.fight.getAttackingPokemonOfTrainer2().getPokemonType().getName() + " loses " + reelDegat + " HP.");

                // Attack TRAINER 2
                reelDegat = attack("trainer2");
                int hpPokemonTrainer1 = this.fight.getAttackingPokemonOfTrainer1().getHp();
                this.fight.getAttackingPokemonOfTrainer1().setHp(hpPokemonTrainer1 - reelDegat);

                System.out.println(this.fight.getAttackingPokemonOfTrainer2().getPokemonType().getName() + " hits." +
                        this.fight.getAttackingPokemonOfTrainer1().getPokemonType().getName() + " loses " + reelDegat + " HP.");

            }
            // Pokemon of Trainer 2 START
            else{

                System.out.println(this.fight.getAttackingPokemonOfTrainer2().getPokemonType().getName() + " hits first");


                // Attack TRAINER 2
                int reelDegat = attack("trainer2");
                int hpPokemonTrainer1 = this.fight.getAttackingPokemonOfTrainer1().getHp();
                this.fight.getAttackingPokemonOfTrainer1().setHp(hpPokemonTrainer1 - reelDegat);

                System.out.println(this.fight.getAttackingPokemonOfTrainer2().getPokemonType().getName() + " hits." +
                        this.fight.getAttackingPokemonOfTrainer1().getPokemonType().getName() + " loses " + reelDegat + " HP.");


                // Attack TRAINER 1
                reelDegat = attack("trainer1");
                int hpPokemonTrainer2 = this.fight.getAttackingPokemonOfTrainer2().getHp();
                this.fight.getAttackingPokemonOfTrainer2().setHp(hpPokemonTrainer2 - reelDegat);

                System.out.println(this.fight.getAttackingPokemonOfTrainer1().getPokemonType().getName() + " hits." +
                        this.fight.getAttackingPokemonOfTrainer2().getPokemonType().getName() + " loses " + reelDegat + " HP.");

            }

            // Check if Pokemon are alive
            checkTeam("trainer1");

            checkTeam("trainer2");

        }
        setWinner();
        
        saveFight(); 
    }

    @Override
    public List<Fight> getFightsByTrainerName(String name) {
        List<Fight> fight = this.fightRepository.getFightsByTrainer1Name(name);
        List<Fight> fight2 = this.fightRepository.getFightByTrainer2Name(name);

        ArrayList<Fight> result = new ArrayList<>();
        result.addAll(fight);

        for(Fight f: fight2){
            if(!result.contains(f))
                result.add(f);
        }

        return result;
    }

    private void saveFight() {
        this.fightRepository.save(this.fight);
    }

    private void checkTeam(String trainer) {

        int hpPokemonAttack = 0;
        int positionActualAttackPokemon = 0;
        Pokemon nextPokemon;

        if("trainer1".equals(trainer))
        {
            this.fight.getAttackingPokemonOfTrainer1().getHp();
            if(hpPokemonAttack <= 0 && this.fight.getNbAlivePokemonOfTrainer1() > 0)
            {

                String log = this.fight.getAttackingPokemonOfTrainer1().getPokemonType().getName() + " is KO ! ";

                positionActualAttackPokemon = this.fight.getPositionInTeamOfActualPokemonTrainer1();
                this.fight.setPositionInTeamOfActualPokemonTrainer1(positionActualAttackPokemon + 1);

                nextPokemon = this.fight.getTrainer1().getTeam().get(positionActualAttackPokemon + 1);
                this.fight.setAttackingPokemonOfTrainer1(nextPokemon); // on passe au pokemonSuivant

                log += this.fight.getAttackingPokemonOfTrainer1().getPokemonType().getName() + " enters battle ! ";

                System.out.println(log);
            }

        }
        else{
            this.fight.getAttackingPokemonOfTrainer2().getHp();
            if(hpPokemonAttack <= 0 && this.fight.getNbAlivePokemonOfTrainer2() > 0)
            {

                String log = this.fight.getAttackingPokemonOfTrainer2().getPokemonType().getName() + " is KO ! ";


                positionActualAttackPokemon = this.fight.getPositionInTeamOfActualPokemonTrainer2();
                this.fight.setPositionInTeamOfActualPokemonTrainer2(positionActualAttackPokemon + 1);

                nextPokemon = this.fight.getTrainer2().getTeam().get(positionActualAttackPokemon + 1);
                this.fight.setAttackingPokemonOfTrainer2(nextPokemon); // on passe au pokemonSuivant

                log += this.fight.getAttackingPokemonOfTrainer2().getPokemonType().getName() + " enters battle ! ";

                System.out.println(log);
            }
        }
    }


    /**
     * Retourne la valeur de HP perdu par le pokémon adverse
     * @param attaquant
     * @return
     */
    private int attack(String attaquant)
    {
        int theoriqueDegat = 0;
        int reelDegat = 1;
        if("trainer1".equals(attaquant))
        {
            // Pokemon Trainer 1 Attack
            int attaquePokemonTrainer1 = fight.getAttackingPokemonOfTrainer1().getPokemonType().getStats().getAttack();
            int defensePokemonTrainer2 = fight.getAttackingPokemonOfTrainer2().getPokemonType().getStats().getDefense();

            theoriqueDegat = attaquePokemonTrainer1 - defensePokemonTrainer2;
            reelDegat = (theoriqueDegat > 0) ? theoriqueDegat : 1;
        }
        else
        {
            // Pokemon Trainer 2 Attack
            int attaquePokemonTrainer2 = fight.getAttackingPokemonOfTrainer2().getPokemonType().getStats().getAttack();
            int defensePokemonTrainer1 = fight.getAttackingPokemonOfTrainer1().getPokemonType().getStats().getDefense();

            theoriqueDegat = attaquePokemonTrainer2 - defensePokemonTrainer1;
            reelDegat = (theoriqueDegat > 0) ? theoriqueDegat : 1;
        }

        return reelDegat;
    }

    private void setWinner() {
        if(this.fight.getNbAlivePokemonOfTrainer1() > 0)
        {
            this.fight.setWinner(this.fight.getTrainer1());
        }
        else
        {
            this.fight.setWinner(this.fight.getTrainer2());
        }
    }
}
