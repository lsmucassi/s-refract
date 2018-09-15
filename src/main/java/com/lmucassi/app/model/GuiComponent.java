package com.lmucassi.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class GuiComponent {
    //Menu components
    private JButton newGame;
    private JButton loadGame;
    private JButton exit;
    private JPanel menuPanel;
    private JPanel createPanel;
    private JPanel loadPanel;

    //Game play components
    private JPanel gamePanel;
    private JLabel lifeLabel;
    private JLabel levelLabel;
    private JLabel xpLabel;
    private JLabel locationLabel;
    private JComboBox<String> directions;
    private JButton fight;
    private JButton run;
    private JScrollPane map;

    private JTextField heroName;
    private JLabel nameLabel;
    private JLabel classLabel;
    private JTextField heroClass;
    private JButton select;
}
