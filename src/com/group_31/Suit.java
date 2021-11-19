package com.group_31;

public enum Suit {
    HEART("♥"), DIAMOND("♦"), CLUB("♣"), SPADE("♠");
    private final String logo;
    Suit(String logo) {
        this.logo = logo;
    }
}
