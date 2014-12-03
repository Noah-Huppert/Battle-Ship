package com.noahhuppert.battleship.helpers;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Noah Huppert on 12/2/2014.
 */
public class Log {
    public static ArrayList<String> MUTED_TAGS = new ArrayList<String>();

    public static String INFO_TAG = "INFO";
    public static String ERROR_TAG = "ERROR";
    public static String DEBUG_TAG = "DEBUG";

    public static void write(String tag, String location, Object message){
        if (location == null){
            location = "";
        }

        if(!MUTED_TAGS.contains(tag)){
            System.out.println("[" + tag + "] " + location + " - " + message);
        }
    }

    /* No tag */
    public static void noTag(String location, Object message){
        String locDelimeter = " - ";

        if (location == null){
            location = "";
            locDelimeter = "";
        }

        System.out.println(location + locDelimeter + message);
    }

    public static void noTag(Object message){
        noTag(null, message);
    }

    /* Info */
    public static void i(String location, Object message){
        write(INFO_TAG, location, message);
    }

    public static void i(Object message){
        i(null, message);
    }

    /* Error */
    public static void e(String location, Object message){
        write(ERROR_TAG, location, message);
    }

    public static void e(Object message){
        e(null, message);
    }

    /* Debug */
    public static void d(String location, Object message){
        write(DEBUG_TAG, location, message);
    }

    public static void d(Object message){
        d(null, message);
    }

    /* Actions */
    public static void mute(String tag){
        if(!MUTED_TAGS.contains(tag)){
            MUTED_TAGS.add(tag);
        }
    }

    public void unMute(String tag){
        MUTED_TAGS.remove(tag);
    }

    public static String readLine(String prompt) {
        String line = null;
        Console c = System.console();
        if (c != null) {
            line = c.readLine(prompt);
        } else {
            System.out.print(prompt);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                //Ignore
            }
        }
        return line;
    }
}
