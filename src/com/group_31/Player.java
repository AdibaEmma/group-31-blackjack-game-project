package com.group_31;

import java.util.ArrayList;

public class Player {
    protected String name;
    protected ArrayList<Card> hand;
    protected Strategy strategy;
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<Card>();
    }


}