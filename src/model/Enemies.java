package model;

import java.util.Random;

public class Enemies extends Characters {

    public Enemies(){}

//    public int getEnyHealth() {
//    }

    String[] enemies = {"Wolfy", "Spirit Bear", "Slimy Swampy", "Giyante Drago"};

    public String getEnyName() {
        return enemies[new Random().nextInt(enemies.length)];
    }

}
