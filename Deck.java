import java.util.List;
import java.util.Scanner;

public class Deck {

    private String name;
    private List<Card> deck;

    public Deck(String name) {
        this.name = name;
    }

    public Deck(String name, List<Card> cards) {
        this.name = name;
        this.deck = cards;
    }

    public Deck(List<Card> deck) {
        this.deck = deck;
    }

    public void drillCards() {
        // functionality for 'drilling' cards by entering the answer manually
    }

    public void reviewCards() {
        // iterate through the deck of cards displaying the front and back of each card
    }


    /**
     * This method enters a loop, adding new cards to the deck as the user provides information for the front and back
     */
    public void addNewCard() {

        System.out.println("in addNewCard(), the deck size is " + this.deck.size());

        // loop adds new cards back on the user's provided data
        while (true) {
            
            System.out.print("Add card front: ");
            String cardFront = UserInputMethods.getStringInput();

            System.out.print("Add card back: ");
            String cardBack = UserInputMethods.getStringInput();

            Card newCard = new Card(deck.size(), cardFront, cardBack);
            Database.addCardToDeck(newCard, this.name);
            this.deck.add(newCard);

            System.out.println("Card added to deck");

            // ask if the user wants to add another card
            System.out.print("Add another? Y/N: ");
            String userChoice = UserInputMethods.getStringInput();
            if (userChoice.equals("N") || userChoice.equals("n")) {
                break;
            }
        }
    }

    public void deleteDeck() {
        // functionality for deleting the entire deck of cards
    }

    public String toString() {
        return this.name;
    }
}
