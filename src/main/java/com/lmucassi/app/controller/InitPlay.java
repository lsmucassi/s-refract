package com.lmucassi.app.controller;

import com.lmucassi.app.ErrException.ErrException;
import com.lmucassi.app.model.Hero;
import com.lmucassi.app.view.CliView;
import com.lmucassi.app.view.GuiView;

public class InitPlay {
    public InitPlay() {}

    public void guiMode() {
        Hero hero = new Hero();
        GuiView guiView = new GuiView();
        GuiController guiController = new GuiController(hero, guiView);
        guiController.startGame();
    }

    public void cliMode() {
        CliView cliView = new CliView();
        Hero hero = new Hero();
        Game gamePlay = new Game(cliView, hero);
        CliController cliController = new CliController(cliView, gamePlay);
        try {
            cliController.playGame();
        } catch (ErrException err) {
            System.out.println(err.getMessage());
            System.out.println("\t \033[31;1mError: playGame() [ Coildn't play game ] \033[0m");
        }
    }
}
