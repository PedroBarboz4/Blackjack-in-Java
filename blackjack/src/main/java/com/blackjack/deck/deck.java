package com.blackjack.deck;

import com.enums.suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class deck{
    public List<card> cards;

    public deck() {
        cards = new ArrayList<>(52);
        for (suit suit : suit.values()) {
            for (int rank = 1; rank <= 13; rank++) {
                cards.add(new card(suit, rank));
            }
        }

        shuffle(cards);
    }


    private void shuffle(List<card> cards) {
        Random random = new Random();
        Collections.shuffle(cards, random);
    }

    public card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(0);
    }

    public int remainingCards() {
        return cards.size();
    }

}
