package com.cardgame;

public class Card {
    private CardSuits suit;
    private String value;
    private boolean isFaceUp;

    public Card(CardSuits suit, String value){
        this.suit = suit;
        this.value = value;
    }

    public String getSuit(){
        if(this.isFaceUp){
            return this.suit.name();
        }
        else{
            return "#";
        }
    }

    public String getValue(){
        if(this.isFaceUp){
            return this.value;
        }
        else{
            return "#";
        }
    }

    public int getPointValue(){
        switch(this.value){
            case "K":
            case "Q":
            case "J":
                return 10;
            case "A":
                return 11;
            default:
                return Integer.parseInt(this.value);
        }
    }

    public boolean isFaceUp(){
        return this.isFaceUp;
    }

    public void flip(){
        this.isFaceUp = !this.isFaceUp;
    }
}
