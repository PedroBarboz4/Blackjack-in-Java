package com.blackjack.game;

import java.util.ArrayList;
import java.util.List;
import com.blackjack.deck.card;

public class participant{
    private List<card> hand;
    private int handValue;

    public participant(List<card> cards){
        this.hand = new ArrayList<>(cards);
    }

    public participant(){
        this.hand = new ArrayList<>();
    }

    public List<card> getHand(){
        return this.hand;
    }

    public void addCard(card newCard) {
        this.hand.add(newCard);
    }

    public void clearHand() {
        this.hand.clear();
    }

    public int calculatehandValue(List<card> hand){
        handValue = 0;
        int aces = 0;

        for (card currentCard : hand) {
            int rank = currentCard.getRank();

            if (rank == 1) {
                handValue += 11;
                aces++;
            } else if (rank >= 10) {
                handValue += 10;
            } else {
                handValue += rank;
            }
        }

        while (handValue > 21 && aces > 0) {
            handValue -= 10;
            aces--;
        }

        return handValue;
    }

    public int calculatehandValue() {
        return calculatehandValue(this.hand);
    }

    public boolean isBust() {
        return calculatehandValue() > 21;
    }
}
