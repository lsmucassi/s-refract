package controller;

import model.Enemies;
import model.Hereos;
import view.CliView;

public class ContListner {

    CliView _cli;
    Hereos _hero;

    public ContListner(CliView cli, Hereos hero) {
        this._cli = cli;
        this._hero = hero;

    }

    public void startGame() {
        _cli.gameCli();
    }

    public void doFight() {
        _cli.printMap((1-1)*5+10-(1%2), _hero);
//        takenDamage = rand.nextInt(enemy.getEnyDamage());
//        damageMade = rand.nextInt(hero.getAttackDamage());
//
//        heroHealth -= takenDamage;
//        enemyHealth -= damageMade;
//
//        if (heroHealth <= 1 && enemyHealth <= 1) {
//            if (takenDamage < damageMade) {
//                heroHealth = 1;
//            } else
//                enemyHealth = 1;
//        }
//
//        if (heroHealth <= 0) { heroHealth  = 0; }
//        if (enemyHealth <= 0) { enemyHealth = 0; }

    }

    public void playExit() {
        System.out.println("\t \033[34m - A : Play again \033[0m");
        System.out.println("\t \033[31m - X : Exit \033[0m");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\033[32m $ Enter command \033[0m");
        System.out.print("\033[32m $  \033[0m");

        String nextIn = in.nextLine();

        if (nextIn.equals("A") || nextIn.equals("a")) {
            checkErr.checkMovErr(nextIn);
        } else if (nextIn.equals("X") || nextIn.equals("x")) {
            checkErr.checkMovErr(nextIn);
        } else {
            checkErr.checkMovErr(nextIn);
        }
    }

    public void checkWin(Hereos hero, Enemies enemy) {

        if (hero.getHeroHealth() < 1) {
            checkErr.checkMovErr("d");
            playExit();
        } else if (enemy.getEnemyHealth() < 1) {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("\t\033[32m#########################################################################\033[0m");
            System.out.println("\t\033[33m$ You defeated \033[0m" + eny +
                    "\033[33m, you can now go to the next level\033[0m ");
            System.out.println("\t\033[32m#########################################################################\n\033[0m");
            hero.getLevel()++;
            hero.getStats();
            System.out.println("------------------------------------------------------------------------------------");
            playExit();
        }
    }
}
