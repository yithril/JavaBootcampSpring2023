package com.cardgame;

public class Main {
    public static void main(String[] args) {
        //Create our deck of 52 cards
        Deck deck = new Deck();

        Hand hand = new Hand();

        deck.shuffle();

        //I want to deal 5 cards
        for(int i = 0; i < 2; i++){
            Card card = deck.deal();
            card.flip();
            System.out.println(card.getSuit());
            System.out.println(card.getValue());
            hand.deal(card);
        }

        System.out.println("The total points of our hand is: " + hand.getValue());
    }
}
