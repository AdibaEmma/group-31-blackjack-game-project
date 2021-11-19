package com.group_31;

import java.util.Arrays;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return this.rank.toString() + " of " + this.suit.toString();
    }

    public int getValue() {
        return this.rank.value;
    }
}
