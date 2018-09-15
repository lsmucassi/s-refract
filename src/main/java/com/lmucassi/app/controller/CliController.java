package com.lmucassi.app.controller;

import com.lmucassi.app.ErrException.ErrException;
import com.lmucassi.app.model.Enemy;
import com.lmucassi.app.model.Hero;
import com.lmucassi.app.view.CliView;

import java.util.ArrayList;

public class CliController {
    Hero hero;
    Game gamePlay;
    GameStats heroStats;
    CliView swingTextView;

    public CliController(CliView swingTextView, Game gamePlay) {
        this.swingTextView = swingTextView;
        this.gamePlay = gamePlay;
    }

    private void updateHero() throws ErrException {
        this.hero.prevDirection = swingTextView.movePlayer();
        if (this.hero.prevDirection == 1)
            this.hero.setY(this.hero.getY() - 1);
        else if (this.hero.prevDirection == 2)
            this.hero.setX(this.hero.getX() + 1);
        else if (this.hero.prevDirection == 3)
            this.hero.setX(this.hero.getX() - 1);
        else if (this.hero.prevDirection == 4)
            this.hero.setY(this.hero.getY() + 1);
        else if (this.hero.prevDirection == 5)
            gamePlay.exitGame();
    }

    public void playGame() throws ErrException {
        swingTextView.startGame();
        Enemy enemy = null;
        START:
        while (true) {
            this.hero = gamePlay.initGame();
            ArrayList<Enemy> enemies = gamePlay.getEnemies();
            while (this.hero.getX() < gamePlay.getMapSize() && this.hero.getX() >= 0
                    && this.hero.getY() >= 0 && this.hero.getY() < gamePlay.getMapSize()) {
                swingTextView.clearScreen();
                swingTextView.drawMap(this.hero, enemies, gamePlay.getMapSize());
                updateHero();
                for (Enemy e :
                        enemies) {
                    if (e.getY() == this.hero.getY() && e.getX() == this.hero.getX()) {
                        heroStats = new GameStats(this.hero, e);
                        enemy = e;
                        heroStats.makeDecision();
                        if (this.hero.getHitPoints() > 0) {
                            if (enemy != null)
                                enemies.remove(enemy);
                            if (heroStats._levelUp) {
                                gamePlay.artifacts();
                                continue START;
                            }
                        }
                        break;
                    }
                }
                if (this.hero.getHitPoints() <= 0) {
                    swingTextView.gameOver(enemy, this.hero);
                    gamePlay.log(this.hero);
                    swingTextView.endSc();
                    break;
                }
            }
            if (this.hero.getHitPoints() <= 0)
                break;
        }
    }
}
