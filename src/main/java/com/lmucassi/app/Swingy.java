package com.lmucassi.app;

import com.lmucassi.app.ErrException.ErrException;
import com.lmucassi.app.controller.CliController;
import com.lmucassi.app.controller.Game;
import com.lmucassi.app.controller.GuiController;
import com.lmucassi.app.model.Hero;
import com.lmucassi.app.view.CliView;
import com.lmucassi.app.view.GuiView;

public class Swingy {
    public static void guiMode() {
        Hero hero = new Hero();
        GuiView swingGUIView = new GuiView();
        GuiController guiController = new GuiController(hero, swingGUIView);

        guiController.startGame();
    }

    public static void cliMode() {
        CliView swingTextView = new CliView();
        Hero hero = new Hero();
        Game gamePlay = new Game(swingTextView, hero);

        CliController textModeController = new CliController(swingTextView, gamePlay);
        try {
            textModeController.playGame();
        } catch (ErrException err) {
            System.out.println(err.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            if (args[0].equals("console"))
                cliMode();
            else if (args[0].equals("gui"))
                guiMode();
            else
                System.out.println("\t \033[31;1mInvalid option [ Choose between console and gui ] \033[0m");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("\t \033[31;1mInvalid Input [ Command Not Found ] \033[0m");
        }
    }
}
