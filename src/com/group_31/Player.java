package com.group_31;

import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<Card> hand = new ArrayList<>();


    public Player(String name) {
        this.name = name;

    }

    public Integer hit() {
        Integer cardTotalValue = hand.stream().map(cards -> cards.getValue()).reduce(0, (subtotal, element) -> subtotal + element);
        if (hand.size() > 1 && cardTotalValue < 17) {
            return ;
        }
    }

    @Override
    public String toString() {
        return "Players{" +
                "name='" + name + '\'' +
                '}';
    }

}