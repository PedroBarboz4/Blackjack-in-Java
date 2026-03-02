package com.blackjack;

import com.blackjack.game.blackjack;
import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        blackjack game = new blackjack();

        boolean keepPlaying = true;
        while (keepPlaying) {
            if (!game.canStartRound()) {
                System.out.println("Deck does not have enough cards for a new round.");
                System.out.println("Cards remaining: " + game.getRemainingCards());
                break;
            }

            game.startRound();
            while (!game.isRoundOver()) {
                System.out.println("Cards remaining in deck: " + game.getRemainingCards());
                System.out.println("Player value: " + game.getPlayer().calculatehandValue());
                System.out.println("Dealer visible value: " + game.getDealer().getHand().get(0).getRank());
                System.out.print("Choose action (hit/stand): ");

                String action = scanner.nextLine().trim().toLowerCase();
                if ("hit".equals(action)) {
                    game.playerHit();
                } else if ("stand".equals(action)) {
                    game.playerStand();
                } else {
                    System.out.println("Invalid action. Type 'hit' or 'stand'.");
                }
            }

            System.out.println("Cards remaining in deck: " + game.getRemainingCards());
            System.out.println("Player value: " + game.getPlayer().calculatehandValue());
            System.out.println("Dealer value: " + game.getDealer().calculatehandValue());
            System.out.println("Result: " + game.getWinnerMessage());
            System.out.print("Play another round? (yes/no): ");

            String answer = scanner.nextLine().trim().toLowerCase();
            keepPlaying = "yes".equals(answer) || "y".equals(answer);
        }

        scanner.close();
    }
}
