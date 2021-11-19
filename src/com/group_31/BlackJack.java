package com.group_31;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BlackJack {
    static List<Player> players = new ArrayList<>(List.of(new Player("Jen"), new Player("Emma"), new Player("Martina")));
    static List<Player> exemptedPlayers = new ArrayList<>();
    static List<Player> playersWithStickChoice  = new ArrayList<>();

    static Boolean endGame = false;
    static Deck playingDeck = new Deck();
    public static void main(String[] args) {

        playingDeck.createFullDeck();
        System.out.println(playingDeck.size());
        playingDeck.shuffle();
        System.out.println(playingDeck.size());
        int totalCardValue;

        // Deal two cards each to every player
        for (Player player: players) {
            player.hand.add(playingDeck.deal());
            player.hand.add(playingDeck.deal());
            totalCardValue = player.hand.stream().map(Card::getValue).reduce(0,Integer::sum);
            System.out.println(player.name + "'s hand = " +player.hand + " cards total = " + totalCardValue);
        }

        while(!endGame) {
            for(int i =0; i < players.size(); i++) {
                Player player = players.get(i);
                totalCardValue = player.hand.stream().map(Card::getValue).reduce(0, Integer::sum);
                if (totalCardValue < 17) {
                    System.out.println(player.name + ": Enter the number 1 to Hit");
                    Scanner input = new Scanner(System.in);
                    int playerChoice = input.nextInt();
                    if (playerChoice == 1) {
                        player.hand.add(playingDeck.deal());
                        player.strategy = Strategy.HIT;
                        totalCardValue = player.hand.stream().map(Card::getValue).reduce(0, Integer::sum);
                        System.out.println(player.name + "'s hand = " + player.hand + " cards total = " + totalCardValue +"\n");
                    }
                } else if ( totalCardValue < 21) {
                    System.out.println(player.name + ": Enter the number 2 to stick");
                    Scanner input = new Scanner(System.in);
                    int playerChoice = input.nextInt();
                    if (playerChoice == 2) {
                        playersWithStickChoice.add(player);
                        player.strategy = Strategy.STICK;
                        System.out.println(player.name + "'s hand = " + player.hand + " cards total = " + totalCardValue + "\n");
                    }
                } else if (totalCardValue ==  21) {
                    System.out.println(player.name + " won");
                    System.out.println("Game ended!!");
                    endGame = true;
                    return;
                } else {
                    System.out.println("go bust");
                    player.strategy = Strategy.GO_BUST;
                    exemptedPlayers.add(player);
                }
            }
            players.removeAll(exemptedPlayers);

        }


//        Scanner input = new Scanner(System.in);
//        while(!endGame) {
//            for (int i =0; i < players.size(); i++) {
//                Player player = players.get(i);
//                System.out.println(player.name + ": Enter the number 1 to Hit or 2 to Stick");
//                int playerChoice = input.nextInt();
//                if (playerChoice == 1) {
//                    player.hand.add(playingDeck.deal());
//                }
//                System.out.println(player.name + "'s hand = " + player.hand);
//                if(i == players.size() - 1) {
//                    executeConstraints();
//                    System.out.println("next round");
//                }
////                totalCardValue = player.hand.stream().map(Card::getValue).reduce(0, Integer::sum);
//
//            }
//
//            players.removeAll(exemptedPlayers);
//            if(players.size() == 1) {
//                System.out.println(players.get(0).name + " won");
//                endGame = true;
//            }
//        }
//    }
//
//    static void executeConstraints() {
//        Optional<Player> winner =  players.stream().filter(c -> c.hand.stream().map(Card::getValue).reduce(0, Integer::sum) == 21).findFirst();
//        if(winner.isPresent()) {
//            System.out.println(winner.get().name + " won");
//            endGame = true;
//            return;
//        }
//
//        for (Player player : players) {
//            int totalValue = player.hand.stream().map(Card::getValue).reduce(0, Integer::sum);
//            if (totalValue > 21) {
//                exemptedPlayers.add(player);
//                System.out.println(player.name + " is out of the game");
//            }
//
//            if (totalValue < 17) {
//                System.out.println(player.name + ": Enter the number 1 to Hit");
//                Scanner input = new Scanner(System.in);
//                int playerChoice = input.nextInt();
//                if (playerChoice == 1) {
//                    player.hand.add(playingDeck.deal());
//                    System.out.println(player.name + "'s hand = " + player.hand + " cards total = " + totalValue);
//                }
//            }
//
//            if(totalValue >= 17 && totalValue < 21) {
//                endGame = true;
//                return;
//            }
//        }
    }
}