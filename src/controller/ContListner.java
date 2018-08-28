package controller;

import ErrException.EIOException;
import model.Enemies;
import model.Heroes;
import view.CliView;

import java.util.Scanner;

public class ContListner {

    CliView _cli ;
    Heroes _hero ;
    Enemies enemy = new Enemies();

    String eny = enemy.getEnyName();
    Scanner in = new Scanner(System.in);

    public ContListner(CliView cli, Heroes hero) {
        this._cli = cli;
        this._hero = hero;

    }

    public void startGame() {
        _hero.loadPlayer();
        _cli.gameCli(enemy, _hero);
    }

    //players stats
    public void getStats() {
//      System.out.println("\t\033[34m $ You are at stage: \033[0m" + _hero.getStage());
        System.out.println("\t\033[34m $ You are level: \033[0m"   + _hero.getLevel());
        System.out.println("\t\033[34m $ You have hit point: \033[0m" + _hero.getHitPoint() + "\033[34m XP\033[0m" );
        System.out.println("\t\033[34m $ Your health is : \033[0m" + _hero.getLife());
        System.out.println("\t\033[34m $ Your experience is \033[0m" + _hero.getExp() + "\033[34m XP\033[0m");
    }



    public void playExit(EIOException err) {
        System.out.println("\t \033[34m - A : Play again \033[0m");
        System.out.println("\t \033[31m - X : Exit \033[0m");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\033[32m $ Enter command \033[0m");
        System.out.print("\033[32m $  \033[0m");

        String nextIn = in.nextLine();

        if (nextIn.equals("A") || nextIn.equals("a")) {
            err.checkMovErr(nextIn);
        } else if (nextIn.equals("X") || nextIn.equals("x")) {
            err.checkMovErr(nextIn);
        } else {
            err.checkMovErr(nextIn);
        }
    }

    public void checkWin(Heroes hero, Enemies enemy, EIOException err) {

        if (hero.getLife() < 1) {
            err.checkMovErr("d");
            playExit(err);
        } else if (enemy.getLife() < 1) {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("\t\033[32m#########################################################################\033[0m");
            System.out.println("\t\033[33m$ You defeated \033[0m" + eny +
                    "\033[33m, you can now go to the next level\033[0m ");
            System.out.println("\t\033[32m#########################################################################\n\033[0m");
//            hero.getLevel()++;
            getStats();
            System.out.println("------------------------------------------------------------------------------------");
            playExit(err);
        }
    }
}
