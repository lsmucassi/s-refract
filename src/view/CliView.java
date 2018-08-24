package view;

import controller.ContListner;
import controller.Game;
import model.Enemies;
import model.Hereos;

public class CliView {

    boolean isGameOn = true;

    public CliView() {

    }

    public void printMap(int mapSize, Hereos hero) {
//        clearScreen();
        hero.setX(mapSize / 2);
        hero.setY(mapSize / 2);

        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                if (hero.getX() == x && hero.getY() == y)
                    System.out.print("&");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
    }

    public void startSc() {
        System.out.println("  Welcome to the adventure of hereos");
        System.out.println("  You are a warrior in a land of the unknown, the king called you and gave you a task");
        System.out.println("  Over night the King's daughter, the princes was kidnapped by The Mighty Giyante Drago");
        System.out.println("  As a warrior you the King trusts that you will save his daughter ");
        System.out.println("and if you do the king will make you a knight");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t#\tLet's Begin \t#");

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t\033[33m $ This is the beginning of your journey to saving the princess\033[0m");
        System.out.println("\t\033[34m \033[34m$ You are now faced with \033[0m" /* + eny */);
    }

    public void endSc() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\033[34m $ Thank you for playing this game \033[0m");
        System.out.println("\033[34m $ Feel free to come back and play \033[0m");
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void stats() {
        System.out.println("\t\033[34m $ You are at stage: \033[0m" /* + stage*/);
        System.out.println("\t\033[34m $ You are level: \033[0m"  /* + level*/);
        System.out.println("\t\033[34m $ You have hit point: \033[0m" /* + hitPoint + "\033[34m XP\033[0m" */);
        System.out.println("\t\033[34m $ Your health is : \033[0m" /* + heroHealth */);
        System.out.println("\t\033[34m $ Your experience is \033[0m" + /* exp + */ "\033[34m XP\033[0m");
    }

    public void checkCom() {

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t\033[32mWhat would you like to do: \033[0m");
        System.out.println("\t\033[34m- 0 : Fight with \033[0m" /* + eny */);
        System.out.println("\t\033[34m- 1 : Go North\033[0m");
        System.out.println("\t\033[34m- 2 : Go East\033[0m");
        System.out.println("\t\033[34m- 3 : Go South\033[0m");
        System.out.println("\t\033[34m- 4 : Go West\033[0m");
        System.out.println("\t\033[34m- 5 : Run\033[0m");
        System.out.println("\t\033[31m- 6 : Exit\033[0m");
    }

    public void gameCli(Game game, Hereos hero, Enemies enemy, ContListner cont) {

        startSc();

        while (isGameOn) {
            if (game.getStage() == 0) {
                STAGE:
                while (enemy.getEnyHealth() > 0) {
                    checkCom();

                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println(" \033[32m$ Enter command\033[0m");
                    System.out.print("\033[32m $  \033[0m");

                    String nextIn = in.nextLine();

                    if (nextIn.equals("0")) {

                        cont.doFight();
/* check here
                        int damageMade = cont.getDamageMade();
                        int takenDamage = cont.getTakenDamage();

//                        heroHealth = cont.getHeroHealth();
                        enemyHealth = cont.getEnemyHealth();

                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You attacked \033[0m" + eny + "\033[33m with \033[0m" + damageMade);
                        System.out.println("\t \033[33m$ \033[0m" + eny + "\033[33m attacked you back with \033[0m" + takenDamage);
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[34m$ Your health is : \033[0m" + heroHealth);
                        System.out.println("\t \033[34m$ " + eny +"'s health is : \033[0m" + enemyHealth);

                        if (hero.getHeroHealth() <= 0) {
                            System.out.println("------------------------------------------------------------------------------------");
                            System.out.println("\t \033[33m$ You took in a lot of damage from \033[0m" + eny);
                            System.out.println("------------------------------------------------------------------------------------");
                            break ;

                        } else if (enemy.getEnemyHealth() <= 0) {
                            hitPoint += 1000;
                            exp += 5;
                            stage++;
                            break;
                        }

                    } else if (nextIn.equals("1")) {
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You chose to go North\033[0m");
                        System.out.println("------------------------------------------------------------------------------------");

                    } else if (nextIn.equals("2")) {
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You chose to go East\033[0m");
                        System.out.println("------------------------------------------------------------------------------------");

                    } else if (nextIn.equals("3")) {
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You chose to go South\033[0m");
                        System.out.println("------------------------------------------------------------------------------------");

                    } else if (nextIn.equals("4")) {
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You chose to go West\033[0m");
                        System.out.println("------------------------------------------------------------------------------------");

                    } else if (nextIn.equals("5")) {
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ Ey Yoh, why are you running ? huh\033[0m");
                        System.out.println("------------------------------------------------------------------------------------");

                    } else if (nextIn.equals("6")){
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You are leaving the world of the unknown\033[0m");
                        System.out.println("------------------------------------------------------------------------------------");
                        stats();
                        isGameOn = false;
                        break ;

                    } else {
                        checkErr.checkPlayErr(nextIn);
                        System.out.println("\t \033[33m $ Try values from 0 - 6 \033[0m");
                        System.out.println("------------------------------------------------------------------------------------");
                        continue STAGE;
                    }
                }
            }
            checkWin();
        }
        endSc();
    */
                    }
                }
            }
        }
    }
}