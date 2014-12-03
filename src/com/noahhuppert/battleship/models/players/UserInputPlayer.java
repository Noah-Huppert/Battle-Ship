package com.noahhuppert.battleship.models.players;

import com.noahhuppert.battleship.helpers.Log;

/**
 * Created by Noah Huppert on 12/2/2014.
 */
public class UserInputPlayer extends Player {
    public UserInputPlayer(String name){
        super(name);
    }

    @Override
    public String choose(){
        String choice = Log.readLine("Pick a tile to shoot at\n");

        while(  choice.length() > 3 ||//Wrong length
                choice.length() < 2 ||//Wrong length
                'A' - Character.toUpperCase(choice.charAt(0)) > 0 ||//Not letter of alphabet
                'A' - Character.toUpperCase(choice.charAt(0)) < 0 ||//Not letter of alphabet
                (choice.length() == 3 && Integer.parseInt("" + choice.charAt(1) + choice.charAt(2)) -1 < 0) ||//Column is less than 0
                (choice.length() == 2 && Integer.parseInt("" + choice.charAt(1)) -1 < 0)){//Column is less than 0
            choice = Log.readLine("Please pick a valid choice");
        }

        return choice;
    }
}
