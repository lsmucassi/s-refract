package com.lmucassi.app.controller;

import com.lmucassi.app.ErrException.ErrException;
import com.lmucassi.app.model.Enemy;
import com.lmucassi.app.model.Hero;
import com.lmucassi.app.view.Battle;

public class GameStats {
    public Hero hero;
    public Enemy enemy;
    public boolean _levelUp = false;
    public boolean _flightSuccessful = false;


    public GameStats(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    public void playerInp() throws ErrException {
        Battle battle = new Battle();
        int decision = battle.battle();
        if (decision == 1) {
            fight();
        } else if (decision == 2) {
            run();
        } else if (decision == 3) {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("\t \033[31mExited \033[0m");
            System.out.println("-----------------------------------------------------------------------------------");
            System.exit(0);
        }
    }

    private void fight() {
        while (this.hero.getHitPoints() > 0 && this.enemy.getHitPoints() > 0) {
            this.hero.setHitPoints(this.hero.getHitPoints() - attackHero());
            this.enemy.setHitPoints(this.enemy.getHitPoints() - attackEnemy());
        }
        if (this.hero.getHitPoints() > 0) {
            this.hero.setExp(((int) (this.hero.getLevel() * 1000 + Math.pow(this.hero.getLevel() - 1, 2) * 450)));
            if (moveLevel() == 1)
                this._levelUp = true;
        }
    }

    private void run() {
        if (this.hero.getDefense() > this.enemy.getAttack()) {
            this._flightSuccessful = true;
        } else
            fight();
    }

    private int attackHero() {
        int defense = this.hero.getDefense();
        int ret = 0;
        while (defense > 0) {
            if (this.enemy.getAttack() > defense) {
                ret = (defense > 0) ? (this.enemy.getAttack() - defense) : this.enemy.getAttack();
                break;
            }
            defense -= this.enemy.getAttack();
        }
        return ret;
    }

    private int attackEnemy() {
        int defense = this.enemy.getDefense();
        int ret = 0;
        while (defense > 0) {
            if (this.hero.getAttack() > defense) {
                ret = (defense > 0) ? (this.hero.getAttack() - defense) : this.hero.getAttack();
                break;
            }
            defense -= this.hero.getAttack();
        }
        return ret;
    }

    public int moveLevel() {

        if (this.hero.getExp() >=  1000) { //1000
            this.hero.setLevel(2);
            return (1);
        } else if (this.hero.getExp() >= 2450) { //2450
            this.hero.setLevel(3);
            return (1);
        } else if (this.hero.getExp() >=  4800 ) { //4800
            this.hero.setLevel(4);
            return (1);
        } else if (this.hero.getExp() >=  8050) { //8050
            this.hero.setLevel(5);
            return (1);
        } else if (this.hero.getExp() >= 8050 ) { // 12200
            this.hero.setLevel(6);
            return (1);
        } else return (0);
    }
}
