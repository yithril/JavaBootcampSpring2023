package com.zork;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonWriter {
    public static void writeRoomToJsonFile(ArrayList<Room> rooms){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter("rooms.json");
            gson.toJson(rooms, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Couldn't write room data to the file");
        }
    }

    public static ArrayList<Room> readRoomsFromJsonFile(){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        ArrayList<Room> rooms = new ArrayList<>();

        try{
            FileReader reader = new FileReader("rooms.json");
            return gson.fromJson(reader, new TypeToken<List<Room>>(){}.getType());
        }
        catch(IOException e){
            System.out.println("Had a problem reading from the file.");
        }

        return rooms;
    }
}
