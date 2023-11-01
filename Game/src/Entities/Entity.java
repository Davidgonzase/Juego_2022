package Entities;

import Hability.Habilities;
import Hability.hab;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Actor will be the mother class to all the subclasses of the program
 * being the mother class it will be abstract
 */

// modificar parametros
public abstract class Entity {
    public ArrayList<Float> stats=new ArrayList<>();
    private String type;
    private String name;
    private float health;
    private float healths;

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public float getFisdam() {
        return fisdam;
    }

    public void setFisdam(float fisdam) {
        this.fisdam = fisdam;
    }

    public float getFisres() {
        return fisres;
    }

    public void setFisres(float fisres) {
        this.fisres = fisres;
    }

    public float getMagdam() {
        return magdam;
    }

    public void setMagdam(float magdam) {
        this.magdam = magdam;
    }

    private float fisdam;
    private float fisres;
    private float magdam;

    public float getMagres() {
        return magres;
    }

    public void setMagres(float magres) {
        this.magres = magres;
    }

    private float magres;
    private float velocity;
    public void setType(String type) {
        this.type = type;
    }

    public String gettype(){return type;}

    public void setName(String name) {
        this.name = name;
    }

    public String getname(){return name;}
    public void setname(String name){this.name=name;}


    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }
    public float getHealths() {
        return healths;
    }

    public void setHealths(float healths) {
        this.healths = healths;
    }

    private BufferedImage bufferedImage;

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
    public void change_health(float mod){
        health+=mod;
    }

    public ArrayList<Habilities> getHabilities() {
        return habilities;
    }

    public void addHabilities(Habilities habilities) {
        this.habilities.add(habilities);
    }
    //se almacenan por poliformismo
    private ArrayList<Habilities> habilities=new ArrayList<Habilities>();
}


