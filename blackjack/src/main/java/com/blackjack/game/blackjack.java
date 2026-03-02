package com.blackjack.game;

import com.blackjack.deck.deck;

public class blackjack {
    private final deck gameDeck;
    private final player player;
    private final dealer dealer;
    private boolean roundOver;
    private String winnerMessage;

    public blackjack() {
        this.gameDeck = new deck();
        this.player = new player();
        this.dealer = new dealer();
        this.roundOver = false;
        this.winnerMessage = "";
    }

    public void startRound() {
        if (!canStartRound()) {
            this.roundOver = true;
            this.winnerMessage = "Not enough cards to start a new round";
            return;
        }

        this.player.resetTurn();
        this.dealer.resetTurn();
        this.roundOver = false;
        this.winnerMessage = "";

        player.hit(gameDeck);
        dealer.hit(gameDeck);
        player.hit(gameDeck);
        dealer.hit(gameDeck);

        checkImmediateBlackjack();
    }

    public void playerHit() {
        if (roundOver || player.isStanding()) {
            return;
        }

        player.hit(gameDeck);
        if (player.isBust()) {
            roundOver = true;
            winnerMessage = "Dealer wins (player bust)";
        }
    }

    public void playerStand() {
        if (roundOver) {
            return;
        }

        player.stand();
        dealer.playTurn(gameDeck);
        finishRound();
    }

    public player getPlayer() {
        return player;
    }

    public dealer getDealer() {
        return dealer;
    }

    public boolean isRoundOver() {
        return roundOver;
    }

    public String getWinnerMessage() {
        return winnerMessage;
    }

    public boolean canStartRound() {
        return gameDeck.remainingCards() >= 4;
    }

    public int getRemainingCards() {
        return gameDeck.remainingCards();
    }

    private void checkImmediateBlackjack() {
        int playerValue = player.calculatehandValue();
        int dealerValue = dealer.calculatehandValue();

        if (playerValue == 21 && dealerValue == 21) {
            roundOver = true;
            winnerMessage = "Push (both blackjack)";
        } else if (playerValue == 21) {
            roundOver = true;
            winnerMessage = "Player wins (blackjack)";
        } else if (dealerValue == 21) {
            roundOver = true;
            winnerMessage = "Dealer wins (blackjack)";
        }
    }

    private void finishRound() {
        int playerValue = player.calculatehandValue();
        int dealerValue = dealer.calculatehandValue();

        roundOver = true;
        if (dealerValue > 21) {
            winnerMessage = "Player wins (dealer bust)";
        } else if (playerValue > dealerValue) {
            winnerMessage = "Player wins";
        } else if (dealerValue > playerValue) {
            winnerMessage = "Dealer wins";
        } else {
            winnerMessage = "Push";
        }
    }
}
