package com.ifi.tp.fight.services;

import com.ifi.tp.fight.bo.Fight;
import com.ifi.tp.trainers.bo.Trainer;

import java.util.List;

public interface FightService {

    void startFight(Trainer trainer1, Trainer trainer2);

    List<Fight> getFightsByTrainerName(String name);
}
