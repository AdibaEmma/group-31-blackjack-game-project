package com.group_31;

import java.util.HashMap;

public class BlackJack {

    public static void main(String[] args) {
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        System.out.println(playingDeck);
    }
}