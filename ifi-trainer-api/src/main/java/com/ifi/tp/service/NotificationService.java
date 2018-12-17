package com.ifi.tp.service;

import com.ifi.tp.bo.Pokemon;
import com.ifi.tp.bo.Trainer;

public interface NotificationService {

    void sendNotification(String message);

    void sendFullHPRecoveredNotification(Trainer ash, Pokemon pikachu);

    void sendOneHPRecoveredNotification(Trainer ash, Pokemon pikachu);
}
