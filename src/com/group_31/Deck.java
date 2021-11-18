package com.group_31;

import java.util.ArrayList;

//enum Suit {
////        ♥, ♦,♣, ♠
//    HEART, DIAMOND, CLUB, SPADE
//}

public class Deck {
    ArrayList<String> cards = new ArrayList<String>();
    String[] ranks = {"2","3","4","5","6","7","8","9","10","jack","queen","king","ace"};
    String[] suits = {"♥", "♦", "♣", "♠"};

    public ArrayList<String> getPack() {
        for(String rank : ranks) {
            for (String suit :suits) {
                cards.add(rank + suit);
            }
        }
        return cards;
    }
}
