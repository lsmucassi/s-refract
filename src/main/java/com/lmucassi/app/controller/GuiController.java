package com.lmucassi.app.controller;

import com.lmucassi.app.ErrException.ErrException;
import com.lmucassi.app.model.Hero;
import com.lmucassi.app.view.CliView;
import com.lmucassi.app.view.GuiView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiController implements ActionListener {
    private GuiView swingGUIView;
    private Game gamePlay;
    private CliView swingTextView;
    private Hero hero;

    public GuiController(Hero hero, GuiView swingGUIView) {
        this.hero = hero;
        this.swingGUIView = swingGUIView;
        swingTextView = new CliView();
        this.gamePlay = new Game(swingTextView, this.hero);
    }

    public void startGame() {
        swingGUIView.setVisible(true);
        swingGUIView.getComponent().getNewGame().addActionListener(this);
        swingGUIView.getComponent().getLoadGame().addActionListener(this);
        swingGUIView.getComponent().getExit().addActionListener(this);
        swingGUIView.getDetails().addActionListener(this);
        swingGUIView.getCreateButton().addActionListener(this);

        swingGUIView.getComponent().getSelect().addActionListener(this);
        swingGUIView.getComponent().getDirections().addActionListener(this);
        swingGUIView.getComponent().getFight().addActionListener(this);
        swingGUIView.getComponent().getRun().addActionListener(this);
    }

    private void selectHero() throws ErrException {
        this.hero = this.gamePlay.getHeroes_().get(swingGUIView.getHeroList().getSelectedIndex());
        this.hero.setDefense(this.swingTextView.getDef(this.hero.getArmor()));
        this.hero.setAttack(this.swingTextView.getAtt(this.hero.getWeapon()));
        this.hero.setHitPoints(100);
        gamePlay.setGameInPlay(true);
        this.hero = gamePlay.initGame();
    }

    public void playGame() {
        this.swingGUIView.gameMode(this.hero);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == swingGUIView.getComponent().getNewGame())
            swingGUIView.createPlayer();
        else if (e.getSource() == swingGUIView.getComponent().getLoadGame()) {
            try {
                this.gamePlay.getHeroes();
            } catch (Exception ex) {
                System.out.println("Hero data incomplete.");
            }
            swingGUIView.loadPlayers(this.gamePlay.getHeroes_());
        } else if (e.getSource() == swingGUIView.getComponent().getExit())
            System.exit(0);

        if (e.getSource() == swingGUIView.getCreateButton())
            swingGUIView.create();
        if (e.getSource() == swingGUIView.getDetails())
            swingGUIView.displayDetails(this.gamePlay.getHeroes_());

        if (e.getSource() == swingGUIView.getComponent().getSelect()) {
            try {
                selectHero();
                playGame();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        //Controls during game play
        if (e.getSource() == swingGUIView.getComponent().getDirections()) {
            if (swingGUIView.getComponent().getDirections().getSelectedIndex() == 0) {
                System.out.println(this.hero.getY());
                this.hero.setY(this.hero.getY() - 1);
                System.out.println(this.hero.getY());
            } else if (swingGUIView.getComponent().getDirections().getSelectedIndex() == 1) {
                this.hero.setX(this.hero.getX() + 1);
            } else if (swingGUIView.getComponent().getDirections().getSelectedIndex() == 2) {
                this.hero.setX(this.hero.getX() - 1);
            } else if (swingGUIView.getComponent().getDirections().getSelectedIndex() == 3) {
                this.hero.setY(this.hero.getY() + 1);
            }
        }
    }
}
