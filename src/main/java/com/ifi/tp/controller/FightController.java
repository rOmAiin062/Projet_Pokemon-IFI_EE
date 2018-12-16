package com.ifi.tp.controller;

import com.ifi.tp.fight.services.FightService;
import com.ifi.tp.trainers.bo.Trainer;
import com.ifi.tp.trainers.services.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fight")
public class FightController {

    private FightService fightService;
    private TrainersService trainersService;

    @Autowired
    FightController(FightService fightService ,TrainersService trainersService)
    {
        this.fightService = fightService;
        this.trainersService = trainersService;
    }

    @GetMapping("/{trainer1}/{trainer2}")
    public void startFight(@PathVariable String name, @PathVariable String name2)
    {
        Trainer trainer1 = this.trainersService.getTrainer(name);
        Trainer trainer2 = this.trainersService.getTrainer(name2);
        this.fightService.startFight(trainer1, trainer2);
    }

    @GetMapping("/{trainer}")
    public void getFightByTrainer(@PathVariable String trainerName)
    {
        this.fightService.getFightsByTrainerName(trainerName);
    }
}
