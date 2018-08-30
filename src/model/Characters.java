package model;

import ErrException.EIOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Characters {

//    public static int iter;
    int life = 100;
    int hitPoint = 0;
    int level = 0;
    int exp = 0;
    int attack = 0;
    int def = 0;
    String weap1 = "";
    String weap2 = "";
    String[][] fileData;
    String name = "";
    String type = "";
    String clan = "";

    public Characters() {}

    //set
    public void setName(String nm) {
        this.name = nm;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public void setWeap1(String weap1) {
        this.weap1 = weap1;
    }

    public void setWeap2(String weap2) {
        this.weap2 = weap2;
    }

    public void setLife(int lf) {
        this.life = lf;
    }

    public void setHitPoint(int hp) {
        this.hitPoint = hp;
    }

    public void setLevel(int lev) {
        this.level = lev;
    }

    public void setExp(int expr) {
        this.exp = expr;
    }

    public void setAttack(int att) {
        this.attack = att;
    }

    public void setDef(int df) {
        this.def = df;
    }

    //get
    public String getName() {
        return this.name;
    }

    public String getType() {
       return this.type;
    }

    public String getClan() {
        return this.clan;
    }

    public String getWeap1() {
        return this.weap1;
    }

    public String getWeap2() {
        return this.weap2;
    }

    public int getLife() {
        return this.life;
    }

    public int getHitPoint() {
        return this.hitPoint;
    }

    public int getLevel() {
        return this.level;
    }

    public int getExp() {
        return this.exp;
    }

}
