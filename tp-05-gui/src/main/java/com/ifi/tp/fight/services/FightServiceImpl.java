package com.ifi.tp.fight.services;

import com.ifi.tp.fight.bo.Fight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FightServiceImpl implements FightService {

    private RestTemplate restTemplate;
    private String fightServiceUrl;

    @Autowired
    public FightServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Fight> getAllFights() {
        Fight[] fights = restTemplate.getForObject(fightServiceUrl + "/fight", Fight[].class);
        return Arrays.asList(fights);
    }

    @Override
    public List<Fight> getFightsByTrainerName(String name) {
         Fight[] fights = restTemplate.getForObject(fightServiceUrl + "/fight/" + name, Fight[].class);
         return Arrays.asList(fights);
    }

    @Override
    public void startFight(String trainer1, String trainer2)
    {
        restTemplate.getForObject(fightServiceUrl + "/fight/" + trainer1 + "/" + trainer2, Void.class);
    }



    @Value("${fight.service.url}")
    void setFightServiceUrl(String fightServiceUrl)
    {
        this.fightServiceUrl = fightServiceUrl;
    }


}
