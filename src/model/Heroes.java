package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Heroes extends Characters{

    int X, Y;

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    private Heroes getHero(String details) {
        Heroes hero = new Heroes();
        String[] detail = details.split(",");

        hero.setName(detail[0]);
        hero.setType(detail[1]);
        hero.setLevel(Integer.parseInt((detail[2])));
        hero.setExp(Integer.parseInt((detail[3])));
        hero.setClan(detail[4]);
        hero.setAttack(Integer.parseInt((detail[5])));
        hero.setDef(Integer.parseInt((detail[5])));
        hero.setWeap1(detail[6]);
        hero.setWeap2(detail[7]);
        hero.setHitPoint(Integer.parseInt(detail[8]));
        return (hero);
    }

    //list players
    public  void listPlayers(Scanner ls) {
        ArrayList<Heroes> players = new ArrayList<>();

        while (ls.hasNext()) {
            players.add(getHero(ls.next()));
        }
//        hero = players.get(3);
        for (Heroes h:
                players) {
            System.out.println(h.getName()
                    + " - The " + h.getType()
                    + " - level " + h.getLevel());
        }
    }
}
