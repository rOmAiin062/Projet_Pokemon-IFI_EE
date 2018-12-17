package com.ifi.tp.service;

import com.ifi.tp.TrainerApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TrainerApi.class})
class NotificationServiceImplIntegrationTest {

    @Test
    void sendNotification(@Autowired NotificationService notificationService) {
        notificationService.sendNotification("test !");
    }
}