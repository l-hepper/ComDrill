import java.sql.*;


/**
 * This class manages all interactions with the SQLite database of user flashcards
 */
public class Database {

    // url for connecting to the database
    private static final String dbURL = "jdbc:sqlite:database/flashcards.db";
 

    /**
     * Creates a new table representing a deck of flashcards as per the user's requested name
     * @param deckName the name the user would like to name the deck
     */
    public static void createDeck(String deckName) {

        // formats the name for SQLite requirements
        formatDeckName(deckName);
        
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL);
            Statement sqlStatement = connection.createStatement();

            sqlStatement.executeUpdate("CREATE TABLE " + deckName + 
                                        " (card_id INT PRIMARY KEY NOT NULL," + 
                                        "card_front TEXT NOT NULL," + 
                                        "card_back TEXT NOT NULL)");

            sqlStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void addCardToDeck(Card card) {
        
    }

    /**
     * deletes a deck from the database
     * @param deckName the deck to be deleleted
     */
    public static void deleteDeck(String deckName) {
        // formats the name for SQLite requirements
        formatDeckName(deckName);
        
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL);
            Statement sqlStatement = connection.createStatement();

            sqlStatement.executeUpdate("DROP TABLE " + deckName);
            sqlStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    /**
     * Strips away whitespace and replaces spaces with underscores
     * @param deckName the name the users wants to name the deck of flashcards
     * @return a formatted name suitable for sqlite
     */
    public static String formatDeckName(String deckName) {
        String formattedName = deckName.toLowerCase().strip().replace(" ", "_");
        System.out.println(formattedName); // for debugging
        return formattedName;
    }




    
}
