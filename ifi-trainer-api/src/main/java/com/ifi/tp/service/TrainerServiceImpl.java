package com.ifi.tp.service;

import com.ifi.tp.bo.Pokemon;
import com.ifi.tp.bo.Trainer;
import com.ifi.tp.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private PokemonService pokemonService;

    private List<String> protectedTrainers = List.of("Ash","Misty");

    @Autowired
    private NotificationService notificationService;

    @Autowired
    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Iterable<Trainer> getAllTrainers() {
        return this.trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainer(String name) {
        return this.trainerRepository.findById(name).orElse(null);
    }

    @Override
    public Trainer createTrainer(Trainer trainer) {
        return this.trainerRepository.save(trainer);
    }

    @Override
    public Trainer updateTrainer(Trainer trainer) {
        return this.trainerRepository.save(trainer);
    }

    @Override
    public void deleteTrainer(String trainerName) {
        if(protectedTrainers.contains(trainerName)){
            return;
        }
        this.trainerRepository.deleteById(trainerName);
    }

    @Override
    @Scheduled(fixedRate = 10000)
    public void restoreOneHp() {
        Iterable<Trainer> trainers = this.getAllTrainers();
        for (Trainer trainer : trainers) {
            List<Pokemon> pokemons = trainer.getTeam();
            for(Pokemon pokemon : pokemons)
            {
                if(pokemon.getHp() < pokemonService.getPokemonMaxHp(pokemon.getPokemonNumber())){
                    pokemon.setHp(pokemon.getHp() + 1);
                    this.notificationService.sendOneHPRecoveredNotification(trainer, pokemon);
                }
                else if(pokemon.getHp() == pokemonService.getPokemonMaxHp(pokemon.getPokemonNumber())){
                    this.notificationService.sendFullHPRecoveredNotification(trainer, pokemon);
                }
            }
            this.updateTrainer(trainer);
        }
    }

    @Autowired
    public void setPokemonService(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Autowired
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


}
