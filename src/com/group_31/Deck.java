package com.group_31;

import java.util.ArrayList;
import java.util.Random;

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

    public void shuffle() {
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i ++) {
            // Generate Random Index
            randomCardIndex = random.nextInt((this.cards.size() - 1) + 1);
            tmpDeck.add(this.cards.get(randomCardIndex));
            // Remove from original deck
            this.cards.remove(randomCardIndex);
        }
        this.cards = tmpDeck;
    }

    public Card deal() {
        return this.cards.remove(cards.size() - 1 );
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

    public int size() {
        return cards.size();
    }
}

