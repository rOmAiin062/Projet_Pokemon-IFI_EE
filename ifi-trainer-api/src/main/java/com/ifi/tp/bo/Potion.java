package com.ifi.tp.bo;

import javax.persistence.Entity;

@Entity
public class Potion extends Item {

    private int hp_restore;
    private boolean remove_status;


    public Potion(String name, int hp_restore, int price, String img) {
        super(name, img, price);
        this.hp_restore = hp_restore;
        this.remove_status = false;
    }

    public Potion(String name, int hp_restore, int price, boolean remove_status, String img) {
        super(name, img, price);
        this.hp_restore = hp_restore;
        this.remove_status = remove_status;
    }

    public int getHp_restore() {
        return hp_restore;
    }

    public void setHp_restore(int hp_restore) {
        this.hp_restore = hp_restore;
    }

    public boolean isRemove_status() {
        return remove_status;
    }

    public void setRemove_status(boolean remove_status) {
        this.remove_status = remove_status;
    }
}
