package com.idtech;


public class JSONManager {

    public static final String assetsDir = "../src/main/resources/assets/" + BaseMod.MODID;


    public static String jsonName(String s) {
        StringBuilder b = new StringBuilder(s.length());
        for (char c : s.toCharArray())
            b.append(Character.isAlphabetic(c) ? Character.toLowerCase(c) : c);
        return b.toString();
    }

    public static String safeString(String s){
        StringBuilder b = new StringBuilder(s.length());
        for(char c : s.toCharArray())
            b.append(Character.isAlphabetic(c) ? c : '_');
        return b.toString();
    }





}