package com.ifi.tp.service;

import com.google.gson.Gson;
import com.ifi.tp.bo.HPNotification;
import com.ifi.tp.bo.Pokemon;
import com.ifi.tp.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private JmsTemplate jmsTemplate;

    @Autowired
    public NotificationServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendNotification(String message) {
        jmsTemplate.convertAndSend("notification", message);
    }

    @Override
    public void sendFullHPRecoveredNotification(Trainer ash, Pokemon pikachu) {

        HPNotification hpNotification = new HPNotification();
        hpNotification.setFullHP(true);
        hpNotification.setPokemon(pikachu);
        hpNotification.setTrainer(ash);
        jmsTemplate.convertAndSend("notification", hpNotification);
    }

    @Override
    public void sendOneHPRecoveredNotification(Trainer ash, Pokemon pikachu) {
        HPNotification hpNotification = new HPNotification();
        hpNotification.setFullHP(false);
        hpNotification.setPokemon(pikachu);
        hpNotification.setTrainer(ash);
        jmsTemplate.convertAndSend("notification", hpNotification);
    }
}