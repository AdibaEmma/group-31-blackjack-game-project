package com.group_31;

enum Suits {
//    "♥", "♦", "♣", "♠"
    HEART, DIAMOND, CLUB, SPADE
}
public class Card {
    private final String cardName;
    private final Integer value;

    public Card(String cardName, Integer value) {
        this.cardName = cardName;
        this.value = value;
    }


}
