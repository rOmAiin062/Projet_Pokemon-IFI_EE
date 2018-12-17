package com.ifi.tp.fight.services;

import com.ifi.tp.fight.bo.Fight;

import java.util.List;

public interface FightService {

    List<Fight> getFightsByTrainerName(String name);

    Iterable<Fight> getAllFights();

    Fight saveFight(Fight fight);
}
