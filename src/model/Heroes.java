package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Heroes extends Characters{

    int X, Y;

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }


    private Heroes getHero(String details) {
        Heroes hero = new Heroes();
        String[] detail = details.split(",");

        hero.setName(detail[0]);

        return (hero);
    }

    //list players
    public  void listPlayers(Scanner ls) {
        ArrayList<Heroes> players = new ArrayList<>();

         while (ls.hasNext()) {
            players.add(getHero(ls.next()));
        }
        hero = players.get(3);
        for (Heroes h:
             players) {
            System.out.println(h.getName());
        }
    }

    //get players
    public void loadPlayer() {
        String fileName = "src/players.txt";
        File file = new File(fileName);

        try {
            Scanner inFile = new Scanner(file);

            listPlayers(inFile);
//
//            while (inFile.hasNext()) {
//                String line = inFile.next();
//                  //System.out.println( line + " ->");
//
//            }

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
