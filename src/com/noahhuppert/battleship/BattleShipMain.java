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
    }
}
