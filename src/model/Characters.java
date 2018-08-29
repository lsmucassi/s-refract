package model;

import ErrException.EIOException;

import java.io.*;
import java.util.Scanner;

public class Characters {

//    public static int iter;
    int life = 100;
    int hitPoint = 0;
    int level = 0;
    int exp = 0;
    int attack = 0;
    int def = 0;
    String weap1 = "";
    String weap2 = "";
//    String[] collWeap;
    String name = "";
    String type = "";
    String clan = "";

    public Characters() {}

    //set
    public void setName(String nm) {
        this.name = nm;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public void setWeap1(String weap1) {
        this.weap1 = weap1;
    }

    public void setWeap2(String weap2) {
        this.weap2 = weap2;
    }

    public void setLife(int lf) {
        this.life = lf;
    }

    public void setHitPoint(int hp) {
        this.hitPoint = hp;
    }

    public void setLevel(int lev) {
        this.level = lev;
    }

    public void setExp(int expr) {
        this.exp = expr;
    }

    public void setAttack(int att) {
        this.attack = att;
    }

    public void setDef(int df) {
        this.def = df;
    }



    //get
    public int getLife() {
        return this.life;
    }

    public int getHitPoint() {
        return this.hitPoint;
    }

    public int getLevel() {
        return this.level;
    }

    public int getExp() {
        return this.exp;
    }

    //get players
    public void loadPlayer() {
        String fileName = "src/players.txt";
        File file = new File(fileName);

        try {
            Scanner inFile = new Scanner(file);
            while (inFile.hasNext()) {
                String line = inFile.next();
                //System.out.println( line + " ->");

            }
            System.out.println("\n");
            inFile.close();

        } catch (FileNotFoundException err) {
            System.out.println("Err: Players file not found [ error loading heroes ]");
            err.printStackTrace();
        }

        Scanner creatCha = new Scanner(System.in);
        int doneCreat = 0;

        System.out.println("\t \033[34m - C : Would you like to create a hero \033[0m");
        System.out.println("\t \033[31m - S : Choose from a list \033[0m");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\033[32m $ Enter command \033[0m");
        System.out.print("\033[32m $  \033[0m");

        String nextCha = creatCha.nextLine();
        if (nextCha == "C") {
            while (doneCreat == 0) {
                //enter Hero characteristics
            }
        } else {
        }

//
//        try {
//            String fileName = "/goinfre/lmucassi/Documents/s-refract/src/players.txtplayers.txt";
//            FileInputStream fstream = new FileInputStream(fileName);
//            BufferedReader breader = new BufferedReader(new InputStreamReader(fstream));
//            String fLine;
//            int line = 1;
//            String[] splits;
//
//            while ((fLine = breader.readLine()) != null) {
//                if (line == 1)
//                    try {
//                        iter = Integer.parseInt(fLine);
//                        if (iter < 0) {
//                            System.out.println("Error: line must be an integer and must be positive");
//                            return;
//                        }
//                    } catch (NumberFormatException e) {
//                        System.out.println("Error: expected a positive integer");
//                        return;
//                    }
//                else {
//                    splits = fLine.split(" ");
//
//                    if (splits.length == 1 && splits[0].isEmpty()) continue;
//                    if (splits.length != 5)
//                        throw new Exception("Error: ["+ line +"] - must have % parameters only");
//
//                    try {
////                    aCraft.newAircraft(splits[0], splits[1], Integer.parseInt(splits[2]),
////                            Integer.parseInt(splits[3]),
////                            Integer.parseInt(splits[4])).registerTower(opTower);
//                    } catch (NumberFormatException e) {
//                        System.out.println("Error: ["+ line +"] - parameters 3 to 5 must be positive integers");
//                        return ;
//                    }
//                }
//                line++;
//            }
//            breader.close();
//        }
//        catch (EIOException e) {
//            System.out.println("Error: "+ e.getMessage());
//            return ;
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//            return ;
//        }
    }
}
