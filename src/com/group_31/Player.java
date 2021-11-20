package com.group_31;

import java.util.ArrayList;
import java.util.Comparator;

public class Player   {
    protected String name;
    protected ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<Card>();
    }

    public int getValue(){
        return hand.stream().map(Card::getValue).reduce(0, Integer::sum);
    }
}