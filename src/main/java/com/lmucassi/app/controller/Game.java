package com.lmucassi.app.controller;

import com.lmucassi.app.ErrException.ErrException;
import com.lmucassi.app.Interface.IModes;
import com.lmucassi.app.model.Enemy;
import com.lmucassi.app.model.Hero;
import com.lmucassi.app.view.CliView;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Getter
public class Game implements IModes {
    private int mapSize;
    private Hero hero;
    private CliView swingTextView;
    @Setter
    private boolean gameInPlay = false;
    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Hero> heroes_ = new ArrayList<>();
    File inFile = new File("players.txt");
    private static Scanner scanner = new Scanner(System.in);

    public Game(CliView swingTextView, Hero hero) {
        this.hero = hero;
        this.swingTextView = swingTextView;
    }

    public Hero initGame() throws ErrException {
        boolean parsed = true;
        if (!this.gameInPlay) {
            if (swingTextView.getChoice().equals("1")) createHero();
            else if (swingTextView.getChoice().equals("2")) {
                int i = 0;
                getHeroes();
                for (Hero _hero : this.heroes_)
                    System.out.println(Integer.toString(++i).concat(" - ".concat(_hero.getName())));
                try {
                    hero = this.heroes_.get(Integer.parseInt(scanner.nextLine()) - 1);
                } catch (Exception ex) {
                    parsed = false;
                }
                if (!parsed) throw new ErrException("\t \033[31m\nInvalid input.\033[0m");
                hero.setAttack(swingTextView.getAttack(hero.getWeapon()));
                hero.setDefense(swingTextView.getDefense(hero.getArmor()));
                hero.setHitPoints(100);
            }
            else if (swingTextView.getChoice().equals("x") || swingTextView.getChoice().equals("X")) {
                exitGame();
            } else
                throw new ErrException("\n\t\033[31mInvalid Selection. Select 1 or 2 or X / x\033[0m");
            this.gameInPlay = true;
            swingTextView.displayDetails(hero);
        }
        this.mapSize = ((hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2));
        hero.setX(this.mapSize / 2);
        hero.setY(this.mapSize / 2);
        getEnemyList(hero);
        return (hero);
    }

    public void artifacts() {
        ArrayList<String> winnings = swingTextView.battleWon(this.hero.getLevel() - 1);
        this.hero.setArmor(winnings.get(0));
        this.hero.setWeapon(winnings.get(1));
    }

    public void getEnemyList(Hero hero) {
        Random rand = new Random();
        int size = ((this.mapSize / 2) - ((this.mapSize / 2) % 2)) + 4;
        String[] name = {"Wolfy", "Spirit Bear", "Slimy Swampy", "Giyante Drago", "Hydrofalcon"
                , "Omnispark", "Scarlet Scimtar"};
        while (this.enemies.size() < size) {
            Enemy enemy = new Enemy();
            enemy.setDefense(rand.nextInt(10 * hero.getLevel()) + 2);
            enemy.setAttack(rand.nextInt(10 * hero.getLevel()) + 5);
            enemy.setHitPoints(100);
            enemy.setX(rand.nextInt(this.mapSize));
            enemy.setY(rand.nextInt(this.mapSize));
            enemy.setName(name[rand.nextInt(7)]);
            this.enemies.add(enemy);
        }
    }

    private String stringyfy(Hero hero) {
        String data, name, _class, level, xp, weapon, armor;
        name = hero.getName().concat(",");
        _class = hero.getHeroClass().concat(",");
        level = Integer.toString(hero.getLevel()).concat(",");
        xp = Integer.toString(hero.getExperience()).concat(",");
        weapon = hero.getWeapon();
        armor = hero.getArmor().concat(",");

        data = name.concat(_class.concat(level.concat(xp.concat(armor.concat(weapon)))));
        return (data);
    }

    @Override
    public void createHero() {
        hero.setName(swingTextView.getHeroName());
        hero.setHeroClass(swingTextView.getHeroClass());
        hero.setExperience(500);
        hero.setWeapon("Dagger");
        hero.setArmor("Ebonwood armor");
        hero.setAttack(swingTextView.getAttack(hero.getWeapon()));
        hero.setDefense(swingTextView.getDefense(hero.getArmor()));
        hero.setHitPoints(100);
    }

    @Override
    public void getHeroes() throws ErrException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                String[] stats = trimmedLine.split(",");
                if (stats.length < 6)
                    throw new ErrException("\n\t\033[31mHero data is incomplete.\033[0m");
                hero = new Hero();
                hero.setName(stats[0]);
                hero.setHeroClass(stats[1]);
                hero.setLevel(Integer.parseInt(stats[2]));
                hero.setExperience(Integer.parseInt(stats[3]));
                hero.setWeapon(stats[4]);
                hero.setArmor(stats[5]);
                this.heroes_.add(hero);
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void log(Hero hero) {
        FileWriter fileWriter;
        Path path = FileSystems.getDefault().getPath(inFile.getPath());

        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(path, StandardCharsets.UTF_8));
            int i;
            for (i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).contains(hero.getName())) {
                    fileContent.set(i, stringyfy(hero));
                    break;
                }
            }
            if (i == fileContent.size()) {
                fileWriter = new FileWriter(inFile, true);
                fileWriter.write(stringyfy(hero));
                fileWriter.flush();
            } else
                Files.write(path, fileContent, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void exitGame() {
        swingTextView.endSc();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\t \033[31mExited \033[0m");
        System.out.println("-----------------------------------------------------------------------------------");
        System.exit(0);
    }
}
