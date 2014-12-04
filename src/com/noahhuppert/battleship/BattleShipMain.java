package com.noahhuppert.battleship;

import com.noahhuppert.battleship.helpers.Log;
import com.noahhuppert.battleship.models.players.Player;
import com.noahhuppert.battleship.models.players.UserInputPlayer;
import com.noahhuppert.battleship.views.MainView;

/**
 * Created by block7 on 12/2/14.
 */
public class BattleShipMain{
    private static Player humanPlayer = new Player("Noah");
    private static Player computerPlayer = new Player("CPU");
    private static MainView mainView;
    private int turnNumber = 1;

    public static void main(String args[]){
        MainView mainView = new MainView();

        //mainView.getGuessTextPane().setText(humanPlayer.getGuessGrid().toString());
        //mainView.getSelfTextPane().setText(humanPlayer.getSelfGrid().toString());
    }

    public static void printHelp(){
        String out = "";

        out += "Battle Ship help\n";
        out += "    self.guessGrid - Shows your guess grid\n";
        out += "    self.selfGrid  - Shows your own grid\n";
        out += "    cpu.guessGrid  - Shows the computers guess grid\n";
        out += "    self.selfGrid  - Shows the cpu's grid\n";
        out += "    help           - Shows this help text\n\n";
        out += "Entering nothing will allow you to act for your turn";

        Log.noTag(out);
    }
}
