package com.group_31;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public void createFullDeck() {
        for(Suit cardSuit: Suit.values()) {
            for(Rank cardRank: Rank.values()) {
                this.cards.add(new Card(cardSuit,cardRank));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder cardListOutput = new StringBuilder();
        int i = 0;
        for (Card card: this.cards) {
            cardListOutput.append("\n").append(card.toString());
            i++;
        }
        return cardListOutput.toString();
    }
}

