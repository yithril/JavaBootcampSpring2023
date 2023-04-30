package com.example.storytime;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Storytime {
    public static void main(String args[]){
        try{
            File storyText = new File("C:\\Bootcamps\\JavaBootcampSpring2023\\Week3\\Exercise1-BedtimeStories\\src\\main\\resources\\goldilocks.txt");
            Scanner scanner = new Scanner(storyText);
            int lineNumber = 1;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(lineNumber + ". " + line);
                lineNumber++;
            }
        }
        catch(IOException ex){
            System.out.println("That file does not exist.");
        }
    }
}
