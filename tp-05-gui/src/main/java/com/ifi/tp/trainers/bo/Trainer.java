package com.ifi.tp.trainers.bo;


import java.util.ArrayList;
import java.util.List;


public class Trainer {

    private String name;

    private List<Pokemon> team;

    private String picture;

    private List<Item> inventory;

    private int wallet;

    public Trainer() {
    }

    public Trainer(String name) {

        this.name = name;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
