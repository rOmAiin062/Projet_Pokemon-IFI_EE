package com.ifi.tp.fight.repository;

import com.ifi.tp.fight.bo.Fight;
import com.ifi.tp.trainers.bo.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FightRepository extends CrudRepository<Fight, String> {


    List<Fight> getFightsByTrainerName1(String name);

    List<Fight> getFightsByTrainerName2(String name);

}