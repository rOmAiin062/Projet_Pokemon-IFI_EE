package com.ifi.tp.fight.services;

import com.ifi.tp.fight.bo.Fight;
import com.ifi.tp.fight.repository.FightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FightServiceImpl implements FightService {

    @Autowired
    private FightRepository fightRepository;


    @Autowired
    public FightServiceImpl(FightRepository fightRepository) {
        this.fightRepository = fightRepository;
    }

    public Iterable<Fight> getAllFights() {
        return this.fightRepository.findAll();
    }

    @Override
    public List<Fight> getFightsByTrainerName(String name) {
        List<Fight> fight = this.fightRepository.getFightsByTrainerName1(name);
        List<Fight> fight2 = this.fightRepository.getFightsByTrainerName2(name);

        ArrayList<Fight> result = new ArrayList<>();
        result.addAll(fight);

        for(Fight f: fight2){
            if(!result.contains(f))
                result.add(f);
        }

        return result;
    }

    @Override
    public Fight saveFight(Fight fight) {
        return this.fightRepository.save(fight);
    }


}
