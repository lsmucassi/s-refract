package model;

import java.util.Random;

public class Enemies extends Characters {

    public Enemies(){}

//    public int getEnyHealth() {
//    }

    String[] enemies = {"Wolfy", "Spirit Bear", "Slimy Swampy", "Giyante Drago"};

    public String getEnyName() {

        String eny = enemies[new Random().nextInt(enemies.length)];
        return eny;
    }

}
