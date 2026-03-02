package com.blackjack.game;

import com.blackjack.deck.card;
import com.blackjack.deck.deck;

public class dealer extends participant {
    public dealer(){
        super();
    }

    public card hit(deck gameDeck) {
        card drawnCard = gameDeck.drawCard();
        addCard(drawnCard);
        return drawnCard;
    }

    public void playTurn(deck gameDeck) {
        while (calculatehandValue() < 17) {
            hit(gameDeck);
        }
    }

    public void resetTurn() {
        clearHand();
    }
}
