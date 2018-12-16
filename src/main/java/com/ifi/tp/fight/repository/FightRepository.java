package com.ifi.tp.fight.repository;

import com.ifi.tp.fight.bo.Fight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FightRepository extends CrudRepository<Fight, String> {


    List<Fight> getFightsByTrainer1Name(String name);

    List<Fight> getFightByTrainer2Name(String name);


}