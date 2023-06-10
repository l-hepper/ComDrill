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


    /**
     * This method iterates through all of the cards in the deck, prompting the user for the correct answer on the BACK of the card
     */
    public void drillCards() {
        // functionality for 'drilling' cards by entering the answer manually

        for (Card card: this.deck) {
            System.out.println("FRONT: " + card.getFront() + "\n");

            System.out.print("ANSWER: ");
            String answer = UserInputMethods.getStringInput();

            if (answer.equals(card.getBack())) {
                System.out.println("\nCorrect.\n");
            } else {
                System.out.println("INCORRECT. ANSWER IS: " + card.getBack());
            }
        }

        System.out.println("\nEND OF DECK\n"); // for debugging
    }

    /**
     * This methods iterates through each of the cards both front and back
     */
    public void reviewCards() {

        for (Card card: this.deck) {
            System.out.println("FRONT: " + card.getFront() + "\n");

            System.out.println("BACK: " + card.getBack() + "\n");

            System.out.print("Next? ENTER");
            UserInputMethods.getStringInput();
            System.out.println();
        }

        System.out.println("\nEND OF DECK\n");
    }


    /**
     * This method enters a loop, adding new cards to the deck as the user provides information for the front and back
     */
    public void addNewCard() {

        System.out.println("in addNewCard(), the deck size is " + this.deck.size());

        // loop adds new cards back on the user's provided data
        while (true) {
            
            System.out.print("Add card front: ");
            String front = UserInputMethods.getStringInput();

            System.out.print("Add card back: ");
            String back = UserInputMethods.getStringInput();

            Card newCard = new Card(front, back);

            // this DeckDAO will actually be a 'CardDAO'
            DeckDAO.addCardToDeck(newCard, this.name);
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


    /**
     * This method deletes the deck from the database, along with all of its cards.
     */
    public void deleteDeck() {

        // delete the deck and cards from the database
        DeckDAO.deleteDeck(this.toString());

        // refresh the deck names and display the main menu
        UserInterface.deckNames = DeckDAO.getDeckNames();
        UserInterface.displayDecks();
    }

    public String toString() {
        return this.name;
    }
}
