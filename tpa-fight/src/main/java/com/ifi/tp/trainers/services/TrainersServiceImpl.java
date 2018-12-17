package com.ifi.tp.trainers.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ifi.tp.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainersServiceImpl implements TrainersService {

    private RestTemplate restTemplate;
    private String trainersServiceUrl;

    @Autowired
    public TrainersServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Trainer> listTrainers() {
        Trainer[] trainers = restTemplate.getForObject(trainersServiceUrl + "/trainers", Trainer[].class);
        return Arrays.asList(trainers);
    }

    @Override
    public Trainer getTrainer(String name) {
        Trainer trainer = restTemplate.getForObject(trainersServiceUrl + "/trainers/" + name, Trainer.class);
        return  trainer;
    }


    @Override
    public void deleteTrainer(String name) {
        System.out.println(trainersServiceUrl + "/trainers/" + name);
        restTemplate.delete(trainersServiceUrl + "/trainers/" + name);
    }

    @Override
    public void updateTrainer(Trainer trainer) {

        String resourceUrl = trainersServiceUrl + "/trainers/" + trainer.getName();
        Gson g = new Gson();
        String trainerJSON = g.toJson(trainer);

        try {
            URL url = new URL(resourceUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
            osw.write(trainerJSON);
            osw.flush();
            osw.close();
            //System.out.println(connection.getResponseCode());

        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Bad url");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't open url");
        }

    }

    @Value("${trainers.service.url}")
    void setTrainersServiceUrl(String trainersServiceUrl) {
        this.trainersServiceUrl = trainersServiceUrl;
    }


}
