package tw.org.iii.tutor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PolerV3_1 {

    public static void main(String[] args) {
        List<String> deck = createDeck();
        shuffleDeck(deck);
        List<List<String>> players = dealCards(deck, 4);
        sortHands(players);
        printHands(players);
    }

    private static List<String> createDeck() {
        List<String> deck = new ArrayList<>();

        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + suit);
            }
        }

        return deck;
    }

    private static void shuffleDeck(List<String> deck) {
        Collections.shuffle(deck);
    }

    private static List<List<String>> dealCards(List<String> deck, int numPlayers) {
        int numCards = deck.size() / numPlayers;
        List<List<String>> players = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            List<String> hand = new ArrayList<>();
            for (int j = 0; j < numCards; j++) {
                hand.add(deck.get(i * numCards + j));
            }
            players.add(hand);
        }

        return players;
    }

    private static void sortHands(List<List<String>> players) {
        for (List<String> hand : players) {
            Collections.sort(hand);
        }
    }

    private static void printHands(List<List<String>> players) {
        int playerNum = 1;
        for (List<String> hand : players) {
            System.out.println("Player " + playerNum + " hand:");
            for (String card : hand) {
                System.out.println(card);
            }
            System.out.println();
            playerNum++;
        }
    }
}