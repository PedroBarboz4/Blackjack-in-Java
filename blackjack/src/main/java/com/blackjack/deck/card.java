package com.blackjack.deck;

import com.enums.suit;

public class card{
    private suit suit;
    private int rank;

    public card(suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public suit getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public void setSuit(suit suit) {
        this.suit = suit;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


}




