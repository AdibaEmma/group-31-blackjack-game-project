package com.group_31;

import java.util.ArrayList;

public class Player {
    protected String name;
    protected ArrayList<Card> hand;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String getName() {
        return name;
    }

    protected Strategy strategy;
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<Card>();
    }


}