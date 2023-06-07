import java.util.List;
import java.util.Scanner;


/**
 * This class displays information to the user and processes user input.
 */
public class UserInterface {

    public static Deck selectedDeck = null;
    // TODO - does decks belong here in the userinterface class? probs not.
    public static List<String> decks = null;

    /**
     * Displays all of the user's decks on the main screen
     */
    public static void displayDecks() {

        System.out.println("\nDECKS:\n");

        decks = Database.getDeckNames();

        for (String deck: decks) {
            System.out.print(decks.indexOf(deck) + 1 + ": ");
            System.out.println(deck);
        }
        System.out.println();
    }


    /**
     * Prompts the user to choose a deck
     */
    public static void selectDeck() {

        System.out.print("Select deck: ");

        // the selects deck is retrieved from the database
        selectedDeck = Database.getDeck(decks.get(UserInputMethods.getIntInput() - 1));

    }


    /**
     * Presents the deck options to the user - drilling, reviewing, adding new cards, or deleting a deck
     */
    public static void displayDeckOptions() {

        System.out.println("\nDECK: " + selectedDeck + "\n");

        System.out.println("1. Drill cards");
        System.out.println("2. Review cards");
        System.out.println("3. Add a new card to this deck");
        System.out.println("4. Delete this deck\n");
    }


    /**
     * Prompts the user to select a deck option
     */
    public static void selectDeckOption() {

        System.out.print("Select option: ");
        int choice = UserInputMethods.getIntInput();

        switch(choice) {
            case 1: 
                selectedDeck.drillCards();
                break;
            case 2:
                selectedDeck.reviewCards();
                break;
            case 3:
                selectedDeck.addNewCard();
                break;
            case 4:
                selectedDeck.deleteDeck();
                break;
        }
    }

    

    




    
}
