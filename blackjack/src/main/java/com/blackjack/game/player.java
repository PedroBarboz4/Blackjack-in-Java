package com.blackjack.game;

import com.blackjack.deck.card;
import com.blackjack.deck.deck;

public class player extends participant {
    private boolean standing;

    public player() {
        super();
        this.standing = false;
    }


    public card hit(deck gameDeck) {
        card drawnCard = gameDeck.drawCard();
        addCard(drawnCard);
        return drawnCard;
    }

    public void stand() {
        this.standing = true;
    }

    public boolean isStanding() {
        return this.standing;
    }

    public void resetTurn() {
        this.standing = false;
        clearHand();
    }
}
