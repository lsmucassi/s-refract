package com.lmucassi.app.controller;

import com.lmucassi.app.ErrException.ErrException;
import com.lmucassi.app.model.Enemy;
import com.lmucassi.app.model.Hero;
import com.lmucassi.app.view.CliView;

import java.util.ArrayList;

public class CliController {
    Hero hero;
    Game gameMove;
    GameStats heroStats;
    CliView consoleView;

    public CliController(CliView consoleView, Game gameMove) {
        this.consoleView = consoleView;
        this.gameMove = gameMove;
    }

    public void playGame() throws ErrException {
        consoleView.startGame();
        Enemy enemy = null;
        START:
        while (true) {
            this.hero = gameMove.initGame();
            ArrayList<Enemy> enemies = gameMove.getEnemies();
            while (this.hero.getX() < gameMove.getMapSz() && this.hero.getX() >= 0
                    && this.hero.getY() >= 0 && this.hero.getY() < gameMove.getMapSz()) {
                consoleView.clearScreen();
                consoleView.drawMap(this.hero, enemies, gameMove.getMapSz());
                updateHero();
                for (Enemy e :
                        enemies) {
                    if (e.getY() == this.hero.getY() && e.getX() == this.hero.getX()) {
                        heroStats = new GameStats(this.hero, e);
                        enemy = e;
                        heroStats.playerInp();
                        if (this.hero.getHitPoints() > 0) {
                            if (enemy != null)
                                enemies.remove(enemy);
                            if (heroStats._moveLevel) {
                                gameMove.artifacts();
                                continue START;
                            }
                        }
                        break;
                    }
                }
                if (this.hero.getHitPoints() <= 0) {
                    consoleView.gameOver(enemy, this.hero);
                    gameMove.log(this.hero);
                    consoleView.endSc();
                    break;
                }
            }
            if (this.hero.getHitPoints() <= 0)
                break;
        }
    }

    private void updateHero() throws ErrException {
        this.hero.prevDir = consoleView.movePlayer();
        if (this.hero.prevDir == 1)
            this.hero.setY(this.hero.getY() - 1);
        else if (this.hero.prevDir == 2)
            this.hero.setX(this.hero.getX() + 1);
        else if (this.hero.prevDir == 3)
            this.hero.setX(this.hero.getX() - 1);
        else if (this.hero.prevDir == 4)
            this.hero.setY(this.hero.getY() + 1);
        else if (this.hero.prevDir == 5)
            gameMove.exitGame();
    }

}
