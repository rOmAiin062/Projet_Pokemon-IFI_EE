package com.ifi.tp.trainers.services;

import com.ifi.tp.trainers.bo.Trainer;

import java.util.List;

public interface TrainersService {

    List<Trainer> listTrainers();

    Trainer getTrainer(String name);

    void deleteTrainer(String name);

    void updateTrainer(Trainer trainer);
}
