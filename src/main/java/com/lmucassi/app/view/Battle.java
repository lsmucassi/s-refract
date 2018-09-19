package com.lmucassi.app.view;

import com.lmucassi.app.ErrException.ErrException;

import java.util.Scanner;

public class Battle {
    private static Scanner reader = new Scanner(System.in);

    public Battle() {
    }

    public int battle() throws ErrException {
        int choice = 0;
        int cc = 1;
        System.out.println("\033[32mYou have come across an enemy, what would you like to do?\033[0m");
        System.out.println("\033[34m1 - Fight\n2 - Run\033[0m");
        System.out.println("\033[31m3 - Exit\033[0m");
        System.out.println("------------------------------------------------------------------------------------");
        enterCom();

        while (cc == 1) {
            try {
                choice = Integer.parseInt(reader.nextLine());
                if (choice >= 1 && choice < 4)
                    cc = 0;
            } catch (NumberFormatException ex) {
                System.out.println("\n\033[32m $ Available options are: Fight, Run or exit.\033[0m");
                enterCom();
            }
        }

        if (choice < 1 || choice > 3)
            throw new ErrException("\033[32mYou can either fight, run away or exit game.\033[0m");
        return (choice);
    }
    public void enterCom() {
        System.out.println("\033[32m $ Enter command \033[0m");
        System.out.print("\033[32m $  \033[0m");
    }
}
