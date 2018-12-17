package com.ifi.tp.fight.bo;

import com.ifi.tp.trainers.bo.Trainer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.HashMap;

public class Fight {

    private int id;

    private String trainerName1;
    private String trainerName2;

    private int nbTours;

    private HashMap<Integer, String> logs;

    private String winner;

    public Fight() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbTours() {
        return nbTours;
    }

    public void setNbTours(int nbTours) {
        this.nbTours = nbTours;
    }

    public HashMap<Integer, String> getLogs() {
        return logs;
    }

    public void setLogs(HashMap<Integer, String> logs) {
        this.logs = logs;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getTrainerName1() {
        return trainerName1;
    }

    public void setTrainerName1(String trainerName1) {
        this.trainerName1 = trainerName1;
    }

    public String getTrainerName2() {
        return trainerName2;
    }

    public void setTrainerName2(String trainerName2) {
        this.trainerName2 = trainerName2;
    }
}
