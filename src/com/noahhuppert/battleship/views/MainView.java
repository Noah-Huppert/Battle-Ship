package com.noahhuppert.battleship.views;

import com.noahhuppert.battleship.BattleShipMain;
import com.noahhuppert.battleship.helpers.Log;
import com.noahhuppert.battleship.models.Grid;
import com.noahhuppert.battleship.models.GridSquare;
import com.noahhuppert.battleship.models.Ship;
import com.noahhuppert.battleship.models.players.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Noah Huppert on 12/2/2014.
 */
public class MainView extends JFrame{
    private Player humanPlayer;
    private Player computerPlayer;

    private JPanel mainPanel;
    private JTextPane selfTextPane;
    private JTextPane guessTextPane;
    private JTextField inputField;
    private JButton helpButton;
    private JLabel selfGridLabel;
    private JLabel guessGridLabel;
    private JLabel messageLabel;
    private JLabel placeShipsMessageLabel;
    private JTextField placeShipsInputField;

    public MainView() {
        //Setters
        setHumanPlayer(new Player("Noah"));
        setComputerPlayer(new Player("CPU"));

        //Add ships
        Ship ship2 = new Ship(2);
        Ship ship3 = new Ship(3);
        Ship ship4 = new Ship(4);
        Ship ship5 = new Ship(5);

        getHumanPlayer().getSelfGrid().getGridSquareByXY(1, 1).setShip(ship2);
        getHumanPlayer().getSelfGrid().getGridSquareByXY(1, 2).setShip(ship2);

        getHumanPlayer().getSelfGrid().getGridSquareByXY(4, 0).setShip(ship3);
        getHumanPlayer().getSelfGrid().getGridSquareByXY(5, 0).setShip(ship3);
        getHumanPlayer().getSelfGrid().getGridSquareByXY(6, 0).setShip(ship3);

        getHumanPlayer().getSelfGrid().getGridSquareByXY(5, 6).setShip(ship4);
        getHumanPlayer().getSelfGrid().getGridSquareByXY(5, 7).setShip(ship4);
        getHumanPlayer().getSelfGrid().getGridSquareByXY(5, 8).setShip(ship4);
        getHumanPlayer().getSelfGrid().getGridSquareByXY(5, 9).setShip(ship4);

        getHumanPlayer().getSelfGrid().getGridSquareByXY(5, 3).setShip(ship5);
        getHumanPlayer().getSelfGrid().getGridSquareByXY(6, 3).setShip(ship5);
        getHumanPlayer().getSelfGrid().getGridSquareByXY(7, 3).setShip(ship5);
        getHumanPlayer().getSelfGrid().getGridSquareByXY(8, 3).setShip(ship5);
        getHumanPlayer().getSelfGrid().getGridSquareByXY(9, 3).setShip(ship5);

        //Comp player choices
        Ship cpuShip2 = new Ship(2);
        Ship cpuShip3 = new Ship(3);
        Ship cpuShip4 = new Ship(4);
        Ship cpuShip5 = new Ship(5);

        getComputerPlayer().getSelfGrid().getGridSquareByXY(1, 1).setShip(cpuShip2);
        getComputerPlayer().getSelfGrid().getGridSquareByXY(2, 1).setShip(cpuShip2);

        getComputerPlayer().getSelfGrid().getGridSquareByXY(0, 4).setShip(cpuShip3);
        getComputerPlayer().getSelfGrid().getGridSquareByXY(0, 5).setShip(cpuShip3);
        getComputerPlayer().getSelfGrid().getGridSquareByXY(0, 6).setShip(cpuShip3);

        getComputerPlayer().getSelfGrid().getGridSquareByXY(6, 5).setShip(cpuShip4);
        getComputerPlayer().getSelfGrid().getGridSquareByXY(7, 5).setShip(cpuShip4);
        getComputerPlayer().getSelfGrid().getGridSquareByXY(8, 5).setShip(cpuShip4);
        getComputerPlayer().getSelfGrid().getGridSquareByXY(9, 5).setShip(cpuShip4);

        getComputerPlayer().getSelfGrid().getGridSquareByXY(3, 5).setShip(cpuShip5);
        getComputerPlayer().getSelfGrid().getGridSquareByXY(3, 6).setShip(cpuShip5);
        getComputerPlayer().getSelfGrid().getGridSquareByXY(3, 7).setShip(cpuShip5);
        getComputerPlayer().getSelfGrid().getGridSquareByXY(3, 8).setShip(cpuShip5);
        getComputerPlayer().getSelfGrid().getGridSquareByXY(3, 9).setShip(cpuShip5);

        //Gui
        setListeners();

        setupGUI();


        //Super win hax
        /*for(int x = 0; x < getComputerPlayer().getSelfGrid().getSizeX(); x++){
            for(int y = 0; y < getComputerPlayer().getSelfGrid().getSizeY(); y++){
                String auto = "" + ((char)('A'+x)) + "" + (y + 1);
                Log.i(auto);
                String status = humanPlayer.act(computerPlayer, auto);
            }
        }*/

        draw();
    }

    /* Actions */
    public void draw(){
        getGuessTextPane().setText(humanPlayer.getGuessGrid().toString());
        getSelfTextPane().setText(humanPlayer.getSelfGrid().toString());
    }

    public void setListeners(){
        getInputField().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String status = humanPlayer.act(computerPlayer, getInputField().getText());

                getInputField().setText("");
                getMessageLabel().setText(status);

                draw();

                if(gameOverFor(getHumanPlayer().getSelfGrid())){
                    Log.i("You Loose :(");
                }

                if(gameOverFor(getComputerPlayer().getSelfGrid())){
                    Log.i("You Win :)");
                }
            }
        });
    }

    public boolean gameOverFor(Grid grid){
        boolean gameOver = true;

        for(int x = 0; x < grid.getSizeX(); x++){
            for(int y = 0; y < grid.getSizeY(); y++){
                GridSquare square = grid.getGridSquareByXY(x, y);

                if(square.getShip() != null && square.getShip().getSize() != 0){
                    gameOver = false;
                }
            }
        }

        return gameOver;
    }

    public void setupGUI(){
        JFrame frame = new JFrame("Battle Ship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(getMainPanel());
        frame.pack();

        frame.setVisible(true);
    }

    /* Getters */
    public Player getHumanPlayer(){
        return humanPlayer;
    }

    public Player getComputerPlayer(){
        return computerPlayer;
    }

    /* Setters */
    public void setHumanPlayer(Player humanPlayer){
        this.humanPlayer = humanPlayer;
    }

    public void setComputerPlayer(Player computerPlayer){
        this.computerPlayer = computerPlayer;
    }

    /* Gui Getters */
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

    public JLabel getMessageLabel() {
        return messageLabel;
    }

    public JLabel getPlaceShipsMessageLabel() {
        return placeShipsMessageLabel;
    }

    public JTextField getPlaceShipsInputField() {
        return placeShipsInputField;
    }

    /* Gui Setters */
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

    public void setMessageLabel(JLabel messageLabel) {
        this.messageLabel = messageLabel;
    }

    public void setPlaceShipsMessageLabel(JLabel placeShipsMessageLabel) {
        this.placeShipsMessageLabel = placeShipsMessageLabel;
    }

    public void setPlaceShipsInputField(JTextField placeShipsInputField) {
        this.placeShipsInputField = placeShipsInputField;
    }
}
