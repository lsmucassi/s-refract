package com.lmucassi.app;

import com.lmucassi.app.ErrException.ErrException;
import com.lmucassi.app.controller.CliController;
import com.lmucassi.app.controller.Game;
import com.lmucassi.app.controller.GuiController;
import com.lmucassi.app.controller.InitPlay;
import com.lmucassi.app.model.Hero;
import com.lmucassi.app.view.CliView;
import com.lmucassi.app.view.GuiView;

public class Swingy {
    public  static InitPlay init = new InitPlay();

    public static void main(String[] args) {
        try {
            if (args[0].equals("console"))
                init.cliMode();
            else if (args[0].equals("gui"))
                init.guiMode();
            else if (args.length == 0)
                System.out.println("\t \033[31;1mUsage: $java -jar swingy.jar [ console | gui ]\n[ Choose between console and gui ] \033[0m");
            else {
                System.out.println("\t \033[31;1mInvalid option [ Choose between console and gui ] \033[0m");
                System.out.println("\t \033[31;1mUsage: $java -jar swingy.jar [ console | gui ]\n\t[ Choose between console and gui ] \033[0m");
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("\t \033[31;1mInvalid Input [ Command Not Found ] \033[0m");
            System.out.println("\t \033[31;1mUsage: $java -jar swingy.jar [ console | gui ]\n\t[ Choose between console and gui ] \033[0m");
        }
    }


}
