package com.noahhuppert.battleship.views;

import com.noahhuppert.battleship.BattleShipMain;
import com.noahhuppert.battleship.helpers.Log;
import com.noahhuppert.battleship.models.players.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Noah Huppert on 12/2/2014.
 */
public class MainView extends JFrame{
    private Player humanPlayer = new Player("Noah");
    private Player computerPlayer = new Player("CPU");

    private JPanel mainPanel;
    private JTextPane selfTextPane;
    private JTextPane guessTextPane;
    private JTextField inputField;
    private JButton helpButton;
    private JLabel selfGridLabel;
    private JLabel guessGridLabel;

    public MainView() {
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Log.i("Print help");
            }
        });

        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                humanPlayer.act(computerPlayer, inputField.getText());

                inputField.setText("");

                draw();
            }
        });


        JFrame frame = new JFrame("Battle Ship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(getMainPanel());
        frame.pack();

        frame.setVisible(true);

        draw();
    }

    /* Actions */
    public void draw(){
        getGuessTextPane().setText(humanPlayer.getGuessGrid().toString());
        getSelfTextPane().setText(humanPlayer.getSelfGrid().toString());
    }

    /* Getters */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextPane getSelfTextPane() {
        return selfTextPane;
    }

    public JTextPane getGuessTextPane() {
        return guessTextPane;
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JButton getHelpButton() {
        return helpButton;
    }

    /* Setters */
    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setSelfTextPane(JTextPane selfTextPane) {
        this.selfTextPane = selfTextPane;
    }

    public void setGuessTextPane(JTextPane guessTextPane) {
        this.guessTextPane = guessTextPane;
    }

    public void setInputField(JTextField inputField) {
        this.inputField = inputField;
    }

    public void setHelpButton(JButton helpButton) {
        this.helpButton = helpButton;
    }
}
