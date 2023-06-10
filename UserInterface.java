import java.util.List;

/**
 * This class displays information to the user and processes user input.
 */
public class UserInterface {

    public static Deck selectedDeck = null;
    // TODO - does decks belong here in the userinterface class? probs not.
    public static List<String> deckNames = DeckDAO.getDeckNames();


    /**
     * Displays all of the user's decks on the main screen
     */
    public static void displayDecks() {

        System.out.println("\nDecks:\n");

        System.out.println("0: Add New Deck");
        for (int i = 0; i < deckNames.size(); i++) {
            System.out.print((i + 1) + ": ");
            System.out.println(deckNames.get(i));
        }
        System.out.println();

        // decks are displayed, prompt user for their selection
        selectDeck();
    }


    /**
     * Prompts the user to choose a deck
     */
    public static void selectDeck() {

        System.out.print("Select deck: ");
        int userSelection = UserInputMethods.getIntInput();

        if (userSelection == 0) {
            // this selection indicates the user wants to add a new deck to the collection
            addNewDeck();
            return;
        } else {
            // the selected deck is retrieved from the database
            selectedDeck = DeckDAO.getDeck(deckNames.get(userSelection - 1));
        }

        // deck has been selected, display deck options
        displayDeckOptions();
    }


    /**
     * Presents the deck options to the user - drilling, reviewing, adding new cards, or deleting a deck
     */
    public static void displayDeckOptions() {

        System.out.println("\nDECK: " + selectedDeck + "\n");

        System.out.println("1. Drill cards");
        System.out.println("2. Review cards");
        System.out.println("3. Add a new card to this deck");
        System.out.println("4. Delete this deck");
        System.out.println("5. MAIN MENU\n");

        // deck options displayed, prompt user for their selection of what to do with the deck
        selectDeckOption();
    }


    /**
     * Prompts the user to select a deck option which is then called from the deck class
     */
    public static void selectDeckOption() {

        System.out.print("Select option: ");
        int choice = UserInputMethods.getIntInput();
        System.out.println();


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
            case 5:
                displayDecks();
                return;
        }

        // after interactions with the deck are completed, the interface returns to the deck options menu
        displayDeckOptions();
    }



    public static void addNewDeck() {

        System.out.println("Enter name of new deck: ");
        String deckName = UserInputMethods.getStringInput();

        DeckDAO.createDeck(deckName);

        deckNames = DeckDAO.getDeckNames();
        displayDecks();
    }

    

    




    
}
