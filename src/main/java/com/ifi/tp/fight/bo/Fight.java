package com.ifi.tp.fight.bo;

import com.ifi.tp.trainers.bo.Pokemon;
import com.ifi.tp.trainers.bo.Trainer;

public class Fight {

    private Trainer trainer1;
    private Trainer trainer2;

    private Pokemon attackingPokemonOfTrainer1;
    private Pokemon attackingPokemonOfTrainer2;

    private int positionInTeamOfActualPokemonTrainer1;
    private int positionInTeamOfActualPokemonTrainer2;

    private int nbAlivePokemonOfTrainer1;
    private int nbAlivePokemonOfTrainer2;

    private int nbTour;
    private Trainer winner;

    public Fight(Trainer trainer1, Trainer trainer2)
    {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;

        this.attackingPokemonOfTrainer1 = trainer1.getTeam().get(0);
        this.attackingPokemonOfTrainer2 = trainer2.getTeam().get(0);

        this.positionInTeamOfActualPokemonTrainer1 = 0;
        this.positionInTeamOfActualPokemonTrainer2 = 0;

        this.nbAlivePokemonOfTrainer1 = trainer1.getTeam().size();
        this.nbAlivePokemonOfTrainer2 = trainer2.getTeam().size();

        this.nbTour = 0;
        this.winner = null;
    }


    public Trainer getTrainer1() {
        return trainer1;
    }

    public void setTrainer1(Trainer trainer1) {
        this.trainer1 = trainer1;
    }

    public Trainer getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(Trainer trainer2) {
        this.trainer2 = trainer2;
    }

    public Pokemon getAttackingPokemonOfTrainer1() {
        return attackingPokemonOfTrainer1;
    }

    public void setAttackingPokemonOfTrainer1(Pokemon attackingPokemonOfTrainer1) {
        this.attackingPokemonOfTrainer1 = attackingPokemonOfTrainer1;
    }

    public Pokemon getAttackingPokemonOfTrainer2() {
        return attackingPokemonOfTrainer2;
    }

    public void setAttackingPokemonOfTrainer2(Pokemon attackingPokemonOfTrainer2) {
        this.attackingPokemonOfTrainer2 = attackingPokemonOfTrainer2;
    }

    public int getNbAlivePokemonOfTrainer1() {
        return nbAlivePokemonOfTrainer1;
    }

    public void setNbAlivePokemonOfTrainer1(int nbAlivePokemonOfTrainer1) {
        this.nbAlivePokemonOfTrainer1 = nbAlivePokemonOfTrainer1;
    }

    public int getNbAlivePokemonOfTrainer2() {
        return nbAlivePokemonOfTrainer2;
    }

    public void setNbAlivePokemonOfTrainer2(int nbAlivePokemonOfTrainer2) {
        this.nbAlivePokemonOfTrainer2 = nbAlivePokemonOfTrainer2;
    }

    public int getNbTour() {
        return nbTour;
    }

    public void setNbTour(int nbTour) {
        this.nbTour = nbTour;
    }

    public Trainer getWinner() {
        return winner;
    }

    public void setWinner(Trainer winner) {
        this.winner = winner;
    }

    public int getPositionInTeamOfActualPokemonTrainer1() {
        return positionInTeamOfActualPokemonTrainer1;
    }

    public void setPositionInTeamOfActualPokemonTrainer1(int positionInTeamOfActualPokemonTrainer1) {
        this.positionInTeamOfActualPokemonTrainer1 = positionInTeamOfActualPokemonTrainer1;
    }

    public int getPositionInTeamOfActualPokemonTrainer2() {
        return positionInTeamOfActualPokemonTrainer2;
    }

    public void setPositionInTeamOfActualPokemonTrainer2(int positionInTeamOfActualPokemonTrainer2) {
        this.positionInTeamOfActualPokemonTrainer2 = positionInTeamOfActualPokemonTrainer2;
    }
}
