package com.cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberOfPlayers = getNumberOfPlayers();
        ArrayList<Player> playersInTheGame = new ArrayList<>();

        //Let's setup the players for the game
        for(int i = 0; i < numberOfPlayers; i++){
            String playerName = askPlayerName(i + 1);
            Player player = new Player(playerName);
            playersInTheGame.add(player);
        }

        boolean gameIsInProgress = true;

        //we'll just say that the player at index 0 goes first


        while(gameIsInProgress){
            //Create the deck of cards
            Deck deck = new Deck();
            deck.shuffle();

            //This starts everyone's hands at 0 in case this is a replay.
            clearPlayerHands(playersInTheGame);

            //Deal the cards to the player
            for(Player player: playersInTheGame){ //For each player
                for(int i = 0; i < 2; i++){ //Deal them two cards
                    dealCard(deck, player.getHand(), player);
                }
            }

            //The players will go in turn
            //We'll use a for loop to reflect that because we're not sure exactly how many players there are
            for(int i = 0; i < playersInTheGame.size(); i++){
                //Get the player whose turn it is
                //We'll just say the order they are in the array list is the turn order
                Player currentPlayer = playersInTheGame.get(i);

                System.out.printf("Current Player is: %s %n", currentPlayer.getName());
                System.out.printf("%s current point total is %d %n", currentPlayer.getName(), currentPlayer.getHand().getValue());

                boolean askPlayerForAdditionalCards = true;

                while(askPlayerForAdditionalCards){
                    //askPlayerForNewCard will return true if they want one
                    if(askPlayerForNewCard()){
                        dealCard(deck, currentPlayer.getHand(), currentPlayer);
                        System.out.printf("%s current point total is %d %n", currentPlayer.getName(), currentPlayer.getHand().getValue());
                        //Did the player bust?
                        if(checkIfHandIsBust(currentPlayer.getHand().getValue())){
                            System.out.println("BUST! Your point total is over 21! Too bad!");
                            //Remove the player from the game!
                            askPlayerForAdditionalCards = false;
                        }
                    }
                    else{
                        //They don't want more cards and they haven't hit bust, exit the loop
                        askPlayerForAdditionalCards = false;
                    }
                }
            }

            ArrayList<Player> winners = decideWinner(playersInTheGame);
            displayWinners(winners);

            gameIsInProgress = playAgain();
        }
    }

    public static void clearPlayerHands(ArrayList<Player> players){
        for(Player player: players){
            player.setHand(new Hand());
        }
    }

    public static void displayWinners(ArrayList<Player> winners){
        for(Player player: winners){
            System.out.printf("%s has won the game with %d points! %n", player.getName(), player.getHand().getValue());
        }
    }

    public static ArrayList<Player> decideWinner(ArrayList<Player> playersInGame){
        //So this is an array list because what if there is a tie?
        ArrayList<Player> winningPlayers = new ArrayList<>();

        int highestTotal = 0;

        for(Player player: playersInGame){
            if(player.getHand().getValue() > 21){
                continue;
            }
            else if(player.getHand().getValue() > highestTotal){
                winningPlayers.clear();
                winningPlayers.add(player);
                highestTotal = player.getHand().getValue();
            }
            else if(player.getHand().getValue() == highestTotal){
                winningPlayers.add(player);
            }
            else{
                //don't do anything, keep moving on
                continue;
            }
        }

        return winningPlayers;
    }

    public static boolean playAgain(){
        boolean askingIfTheyWantToPlayAgain = true;

        while(askingIfTheyWantToPlayAgain){
            System.out.println("Would you like to play again (Y/N)?");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine();

            if(response.toUpperCase().equals("Y")){
                return true;
            }
            else if(response.toUpperCase().equals("N")){
                System.out.println("Thanks for playing!");
                return false;
            }
            else{
                System.out.println("That's not a thing, try again.");
            }
        }

        return true;
    }

    public static boolean checkIfHandIsBust(int points){
        if(points > 21){
            return true;
        }
        else{
            return false;
        }
    }

    public static void dealCard(Deck deck, Hand hand, Player player){
        Card card = deck.deal();
        card.flip();
        hand.deal(card);
        System.out.printf("%s was dealt: %s of %s %n", player.getName(), card.getValue(), card.getSuit());
    }

    public static boolean askPlayerForNewCard(){
        boolean isAskingForCard = true;

        while(isAskingForCard){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want another card? Y/N");
            String answer = scanner.nextLine();

            //There are three scenarios. They press Y, N, or some nonsense
            if(answer.toUpperCase().equals("Y")){
                return true;
            }
            else if(answer.toUpperCase().equals("N")){
                return false;
            }
            else{
                System.out.println("Please select Y or N");
            }
        }

        return true;
    }

    public static int getNumberOfPlayers(){
        boolean gettingNumberOfPlayers = true;
        while(gettingNumberOfPlayers){
            Scanner scanner = new Scanner(System.in);

            System.out.println("How many players are there? You can select between 2 and 7 inclusive.");

            int response = scanner.nextInt();

            //Blackjack is played with 2-7 people
            if(response < 2 || response > 7){
                System.out.println("Blackjack is played with anywhere from two to seven people. Try again.");
            }else{
                return response;
            }
        }

        //The code will never get here but I need to appease Java
        return 2;
    }

    public static String askPlayerName(int number){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("What is the name for player %d?", number);
        return scanner.nextLine();
    }
}
