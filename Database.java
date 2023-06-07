import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
        String formattedName = formatDeckName(deckName);
        
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL);
            Statement sqlStatement = connection.createStatement();

            sqlStatement.executeUpdate("CREATE TABLE " + formattedName + 
                                        " (card_id INT PRIMARY KEY NOT NULL," + 
                                        "card_front TEXT NOT NULL," + 
                                        "card_back TEXT NOT NULL)");

            sqlStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    public static void addCardToDeck(Card card, String deckName) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL);
            Statement sqlStatement = connection.createStatement();

            sqlStatement.executeUpdate("INSERT INTO " + deckName + 
                                        " VALUES (" + card.getid() + ", '" + card.getFront() + "', '" + card.getBack() + "')");

            sqlStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * This method returns a Deck object consisting of all the cards in the selected deck.
     * @param deckName the requested deck of cards
     */
    public static Deck getDeck(String deckName) {
        Connection connection = null;

        List<Card> cards = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(dbURL);
            Statement sqlStatement = connection.createStatement();

            ResultSet results = sqlStatement.executeQuery("SELECT * FROM " + deckName);

            while(results.next()) {
                cards.add(new Card(Integer.valueOf(results.getString(1)), results.getString(2), results.getString(3)));
            }

            sqlStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return new Deck(deckName, cards);
    }


    /**
     * deletes a deck from the database
     * @param deckName the deck to be deleleted
     */
    public static void deleteDeck(String deckName) {
        // formats the name for SQLite requirements
        String formattedName = formatDeckName(deckName);
        
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL);
            Statement sqlStatement = connection.createStatement();

            sqlStatement.executeUpdate("DROP TABLE " + formattedName);
            sqlStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    /**
     * this queries the database for a list of the user's stored decks
     * @return a string list of the names of the decks in the database
     */
    public static List<String> getDeckNames() {

        Connection connection = null;
        List<String> decks = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(dbURL);
            Statement sqlStatement = connection.createStatement();

            ResultSet results = sqlStatement.executeQuery("SELECT name FROM sqlite_schema WHERE type='table'");

            while(results.next()) {
                decks.add(results.getString(1));
            }

            sqlStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return decks;
    }


    /**
     * Strips whitespace and replaces spaces with underscores
     * @param deckName the name the users wants to name the deck of flashcards
     * @return a formatted name suitable for sqlite
     */
    public static String formatDeckName(String deckName) {
        String formattedName = deckName.toLowerCase().strip().replace(" ", "_");
        return formattedName;
    }






    
}
