package com.lmucassi.app.view;

import com.lmucassi.app.ErrException.ErrException;
import com.lmucassi.app.model.Enemy;
import com.lmucassi.app.model.Hero;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Scanner;

@Getter
public class CliView {
    private String choice;
    private static Scanner scanner = new Scanner(System.in);

    public CliView() {
    }

    public void startGame() {
        clearScreen();
        System.out.println("\n\033[32m###################################################################\033[0m");
        System.out.println(" \t\t\tWelcome to the adventure of heroes");
        System.out.println("\033[32m###################################################################\033[0m");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t \033[34m - 1 - Create hero  \033[0m");
        System.out.println("\t \033[32m - 2 - Select a hero \033[0m");
        System.out.println("\t \033[31m - X : Exit \033[0m");
        System.out.println("------------------------------------------------------------------------------------");
        enterCom();
        this.choice = scanner.nextLine();
    }

    public void startSc()  {
        System.out.println("\n\033[32m#########################################################################\033[0m");
        System.out.println("  You are a warrior in a land of the unknown, You are faced with a lot of monsters in the Valley");
        System.out.println("  It is your duty to protect the village before this monsters attack, day and night you must keep watch and patrol");
        System.out.println("  Fight or Flee, it's all up to you hero");
        System.out.println("  a lot of rewards awaits those eho serves the village right, may the spirit of all heroes be with you");
        System.out.println("\033[32m#########################################################################\033[0m");
        System.out.println("\n");
    }

    public String getHeroName() {
        clearScreen();
        System.out.println("\033[32m$ Enter hero name:");
        enterCom();
        return (scanner.nextLine().trim());
    }

    public String getHeroClass() {
        clearScreen();
        System.out.println("\033[32m$ Enter hero's class: ");
        enterCom();
        return (scanner.nextLine().trim());
    }

    public int getAttack(String weapon) {
        int i = 0;
        String[] weapons = {"Short sword", "Dagger", "Falchion", "Katana", "Long Bow", "Long sword"};
        int[] attack = {12, 25, 32, 45, 50, 68};
        for (String w : weapons) {
            if (w.toLowerCase().equals(weapon.toLowerCase())) {
                return (attack[i]);
            }
            i++;
        }
        return (0);
    }

    public int getDefense(String _armor) {
        int i = 0;
        String[] armor = {"Mining armor", "Steel armor", "Rich Mahogany armor", "Ebonwood armor"
                , "Shadewood armor", "Leather armor"};
        int[] defense = {63, 57, 42, 35, 22, 10};

        for (String a : armor) {
            if (a.toLowerCase().equals(_armor.toLowerCase())) {
                return (defense[i]);
            }
            i++;
        }
        return (0);
    }

    public void displayDetails(Hero hero) {
        startSc();
        System.out.println("\033[32m $ Name: ".concat(hero.getName()));
        System.out.println("\033[32m $ Class: ".concat(hero.getHeroClass()));
        System.out.println("\033[32m $ Level: ".concat(Integer.toString(hero.getLevel())));
        System.out.println("\033[32m $ Experience: ".concat(Integer.toString(hero.getExp()).concat(" XP")));
        System.out.println("\033[32m $ Attack: ".concat(Integer.toString(hero.getAttack())));
        System.out.println("\033[32m $ Defence: ".concat(Integer.toString(hero.getDefense())));
        System.out.println("\033[32m $ Weapon: ".concat(hero.getWeapon()));
        System.out.println("\033[32m $ Armor: ".concat(hero.getArmor()));
        System.out.println("\n\033[32m $ Continue... [ press any key ]\033[0m");
        enterCom();
        while (scanner.nextLine() == null) ;
    }

    public ArrayList<String> battleWon(int level) {
        ArrayList<String> artifacts = new ArrayList<>();
        String[] armor = {"Leather armor", "Ebonwood armor", "Rich Mahogany armor"
                , "Shadewood armor", "Mining armor", "Steel armor"};
        String[] weapons = {"Dagger", "Short sword", "Falchion", "Katana"
                , "Long Bow", "Long sword"};

        System.out.println("\n\n\033[32m!YOU'VE WON THE FIGHT!\nYour rewards are: \033[0m"
                .concat(weapons[level]));
        artifacts.add(weapons[level]);
        System.out.println("And armor: "
                .concat(armor[level]));
        System.out.println("\n\033[32m $ Continue to the next level... [ press any key ]\033[0m");
        enterCom();
        artifacts.add(armor[level]);
        scanner.nextLine();
        return (artifacts);
    }

    public void gameOver(Enemy enemy, Hero hero) {
        clearScreen();
        System.out.println("\t\033[31mGAME OVER!!!\033[0m");
        System.out.println("\t\033[34m-Hero: \033[0m".concat(hero.getName()
                .concat("\t\033[34m- Killed by: \033[0m").concat(enemy.getName())));
        System.out.println("\t\033[34m-XP: \033[0m".concat(Integer.toString(hero.getExp())
                .concat("\t\033[34m- Level: \033[0m").concat(Integer.toString(hero.getLevel()))));
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private Enemy getEnemy(int x, int y, ArrayList<Enemy> enemies) {
        for (Enemy e :
                enemies) {
            if (e.getX() == x && e.getY() == y)
                return (e);
        }
        return (null);
    }

    public void drawMap(Hero hero, ArrayList<Enemy> enemies, int mapSize) {
        Enemy e;
        System.out.print(" \033[34mLife: \033[0m".concat(Integer.toString(hero.getHitPoints()).concat("\t\t")));
        System.out.println(" \033[34mLevel: \033[0m".concat(Integer.toString(hero.getLevel())));
        System.out.println(" \033[34mLevel: \033[0m".concat(Integer.toString(hero.getExp())));
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                e = getEnemy(x, y, enemies);
                if (x == hero.getX() && y == hero.getY())
                    System.out.print(" \033[32m§\033[0m");
                else if (e != null) {
                    System.out.print("\033[31m O\033[0m");
                } else
                    System.out.print(" .");
            }
            System.out.println();
        }
    }

    public int movePlayer() throws ErrException {
        int cc = 1, move = 0;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t\033[32m $ What would you like to do: \033[0m");
        System.out.println("\t\033[34m- 1 : Go North \t[ UP ]\033[0m");
        System.out.println("\t\033[34m- 2 : Go East \t[ RIGHT ]\033[0m");
        System.out.println("\t\033[34m- 3 : Go West \t[ LEFT ]\033[0m");
        System.out.println("\t\033[34m- 4 : Go South\t[ DOWN ]033[0m");
        System.out.println("\t\033[31m- 5 : Exit <-\033[0m");
        enterCom();
        while (cc == 1) {
            try {
                move = Integer.parseInt(scanner.nextLine());
             if  (move >= 1 && move <= 5)
                 cc = 0;

            } catch (NumberFormatException ex) {
                System.out.println("\n\033[32m $ Available options are: North, East, West and South or exit.\033[0m");
                enterCom();
            }
        }

        if (move < 1 || move > 5)
            throw new ErrException("\n\033[32m $ Available options are: North, East, West and South or exit.\033[0m");
        return (move);
    }

    public void endSc() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\033[34m $ Thank you for tryng out this game \033[0m");
        System.out.println("\033[34m $ Feel free to come back and play again\033[0m");
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void enterCom() {
        System.out.println("\033[32m $ Enter command \033[0m");
        System.out.print("\033[32m $  \033[0m");
    }
}
