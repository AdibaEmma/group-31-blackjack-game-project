package com.group_31;

import java.util.Arrays;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return this.suit.toString() + " of " + this.rank.toString();
    }

    public Rank getValue() {
        return this.rank;
    }
}
