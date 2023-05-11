package com.cardgame;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand(){
        this.cards = new ArrayList<Card>();
    }

    public void deal(Card card){
        this.cards.add(card);
    }

    public int getSize(){
        return this.cards.size();
    }

    public int getValue(){
        //placeholder variable
        int value = 0;

        //loop through objects or ints or whatever looping through
        for(Card card: cards){
            card.flip();
            //take the value and add it to your placeholder
            value += card.getPointValue();
            card.flip();
        }

        //return the placeholder
        return value;
    }
}
