package com.ifi.tp.fight.services;

import com.ifi.tp.fight.bo.Fight;

import java.util.List;

public interface FightService {

    List<Fight> getFightsByTrainerName(String name);

    List<Fight> getAllFights();

    void startFight(String trainer1, String trainer2);
}
