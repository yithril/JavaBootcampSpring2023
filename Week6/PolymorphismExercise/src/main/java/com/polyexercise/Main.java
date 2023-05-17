package com.polyexercise;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> myAssets = new ArrayList<>();

        House myMainCrib = new House("My main house", "10/21/22",
                                                700000, "123 Street",
                                            1, 10000, 20000);

        House mySummerHome = new House("My summer home", "05/01/23", 1000000, "Wherever", 2, 5000, 1000);

        Vehicle hoopdie = new Vehicle("Decrepit, ratty car", "10/12/2000", 20000, "Dodge Charger", 11, 2000000);

        myAssets.add(myMainCrib);
        myAssets.add(hoopdie);

        //Create new assets, houses and vehicles
        //add them to my ArrayList<Asset>
        //Loop through my assets
        //Print out the description of each asset, the
        //date you acquired it, how much you paid for it, and its value.
        //After that, check if its a house or a vehicle (use instanceof)
        //if its a house, show the address
        //if its a vehicle, show the make/model and year

        for(Asset asset : myAssets){
            System.out.printf("Description: %s Date Acquired: %s Paid: $%.2f Value: $%.2f %n", asset.getDescription(), asset.getDateAcquired(), asset.getOriginalCost(), asset.getValue());

            if(asset instanceof Vehicle){
                //placing a type in parenthesis in front of a variable is called casting
                //downcasting means starting at the parent but casting it as one of the children
                System.out.printf("Make/Model: %s  Year: %d %n", ((Vehicle) asset).getMakeModel(), ((Vehicle) asset).getYear());
            }

            if(asset instanceof House){
                System.out.printf("Address: %s %n", ((House) asset).getAddress());
            }
        }
    }
}
