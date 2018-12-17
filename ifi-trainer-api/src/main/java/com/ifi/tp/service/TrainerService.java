package com.ifi.tp.service;


import com.ifi.tp.bo.Trainer;

public interface TrainerService {


    Iterable<Trainer> getAllTrainers();

    Trainer getTrainer(String name);

    Trainer createTrainer(Trainer trainer);

    Trainer updateTrainer(Trainer trainer);

    void deleteTrainer(String trainerName);

    void restoreOneHp();

    void setPokemonService(PokemonService pokemonService);

    void setNotificationService(NotificationService notificationService);
}
