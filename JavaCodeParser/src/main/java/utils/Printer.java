package utils;

import data.Question;

import java.util.HashMap;

public class Printer {
    private static Boolean DEBUG = true;

    public static void println(Object context){
        if(DEBUG){
            System.out.println(context);
        }
    }

}
