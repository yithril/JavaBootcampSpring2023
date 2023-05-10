package com.staticclasses;

public class NameFormatter {
    private NameFormatter(){

    }

    public static String format(String firstName, String lastName){
        return String.format("%s, %s", lastName, firstName);
    }

    public static String format(String prefix,
                                String firstName,
                                String middleName,
                                String lastName,
                                String suffix)
    {
        return String.format("%s %s %s %s %s", prefix, firstName, middleName, lastName, suffix);
    }

    public static String format(String fullName){
        String[] nameSplit = fullName.split(" ");

        return String.format("%s %s %s %s %s", nameSplit[3], nameSplit[0], nameSplit[1], nameSplit[2], nameSplit[4]);
    }
}
