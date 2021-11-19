package com.group_31;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>(List.of(new Player("Jen"), new Player("Emma"), new Player("Martina")));

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        System.out.println(playingDeck.size());
        playingDeck.shuffle();
        System.out.println(playingDeck.size());
        int totalCardValue = 0;
        for (Player player: players) {
            player.hand.add(playingDeck.deal());
            player.hand.add(playingDeck.deal());
            totalCardValue = player.hand.stream().map(Card::getValue).reduce(0,Integer::sum);
            System.out.println(player.name + "'s hand = " +player.hand + " cards total = " + totalCardValue);

        }

        for (Player player : players) {
            totalCardValue = player.hand.stream().map(Card::getValue).reduce(0, Integer::sum);
            if (totalCardValue < 17) {
                System.out.println(player.name + ": Enter the number 1 to Hit");
                Scanner input = new Scanner(System.in);
                int playerChoice = input.nextInt();
                if (playerChoice == 1) {
                    player.hand.add(playingDeck.deal());
                    totalCardValue = player.hand.stream().map(Card::getValue).reduce(0, Integer::sum);
                    System.out.println(player.name + "'s hand = " + player.hand + " cards total = " + totalCardValue);
                }
            } else if (totalCardValue >= 17 && totalCardValue < 21) {
                System.out.println(player.name + ": Enter the number 2 to stick");
                Scanner input = new Scanner(System.in);
                int playerChoice = input.nextInt();
                if (playerChoice == 1) {
                    System.out.println(player.name + "'s hand = " + player.hand + " cards total = " + totalCardValue);
                }
            } else if (totalCardValue ==  21) {
                System.out.println(player.name + "won");
            } else {
                System.out.println("go bust");
                players.remove(player);
            }
        }
    }
}