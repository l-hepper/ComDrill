

public class CLICommands {
    public static void main(String[] args) throws Exception {
        
        while (true) {
            UserInterface.displayDecks();
            UserInterface.selectDeck();
            UserInterface.displayDeckOptions();
            UserInterface.selectDeckOption();
        }
    }

    // create a new card
    public static void createCard() {

    }
}
