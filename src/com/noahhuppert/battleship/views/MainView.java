package com.noahhuppert.battleship.views;

import com.noahhuppert.battleship.BattleShipMain;
import com.noahhuppert.battleship.helpers.Log;
import com.noahhuppert.battleship.models.Ship;
import com.noahhuppert.battleship.models.players.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private ArrayList<Ship> ships;

    public MainView() {
        //Setters
        setHumanPlayer(new Player("Noah"));
        setComputerPlayer(new Player("CPU"));
        setShips(new ArrayList<Ship>());

        //Add ships
        addShip(new Ship(2));
        addShip(new Ship(3));
        addShip(new Ship(4));
        addShip(new Ship(5));

        //Gui
        setListeners();

        setupGUI();

        draw();

        getInputField().setVisible(false);
        getMessageLabel().setVisible(false);

        //Place ships
        int currentPlacingShipIndex = 0;
        int lastShipPlacedIndex = -1;

        placeShipsInputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO Place ship
            }
        });

        while(lastShipPlacedIndex <= getShips().size() - 1){
            if(lastShipPlacedIndex < currentPlacingShipIndex){
                getPlaceShipsMessageLabel().setText("Place ship with size " + getShipByIndex(currentPlacingShipIndex).getSize());
            }
        }

        getPlaceShipsInputField().setVisible(false);
        getPlaceShipsMessageLabel().setVisible(false);

        getInputField().setVisible(true);
        getMessageLabel().setVisible(true);
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
            }
        });
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

    public ArrayList<Ship> getShips(){
        return ships;
    }

    public Ship getShipByIndex(int index){
        return getShips().get(index);
    }

    /* Setters */
    public void setHumanPlayer(Player humanPlayer){
        this.humanPlayer = humanPlayer;
    }

    public void setComputerPlayer(Player computerPlayer){
        this.computerPlayer = computerPlayer;
    }

    public void setShips(ArrayList<Ship> ships){
        this.ships = ships;
    }

    public void setShipByIndex(int index, Ship ship){
        getShips().set(index, ship);
    }

    public void addShip(Ship ship){
        getShips().add(ship);
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
