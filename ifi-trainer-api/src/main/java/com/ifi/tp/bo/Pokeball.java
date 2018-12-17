package com.ifi.tp.bo;

import javax.persistence.Entity;

@Entity
public class Pokeball extends Item {

    private double bonus_ball;
    private int resale_price;


    public Pokeball(String name, double bonus_ball, int buying_price, int resale_price, String img) {
        super(name, img, buying_price);
        this.bonus_ball = bonus_ball;
        this.resale_price = resale_price;
    }

    public Pokeball() {

    }

    public double getBonus_ball() {
        return bonus_ball;
    }

    public void setBonus_ball(double bonus_ball) {
        this.bonus_ball = bonus_ball;
    }

    public int getResale_price() {
        return resale_price;
    }

    public void setResale_price(int resale_price) {
        this.resale_price = resale_price;
    }

}
