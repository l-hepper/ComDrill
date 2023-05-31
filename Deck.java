public class Deck {

    private Card[] deck;

    public Deck() {
        this.deck = new Card[10];
    }

    public Deck(Card[] deck) {
        this.deck = deck;
    }


    // iterates over all of the cards and displays them to the screen
    public void reviewDeck(Card[] deck) {
        // this method allows the user to simply review all of the cards in the deck one by one, useful for learning

        // iterate through each card of the passed in deck
        // display each card to the user

    }
    


    // iterates over all the cards and displays them to the user, but it also requires the user to enter the correct answer from the 'back' of the card
    public void drillDeck() {
        // this method goes through the cards one by one and the user must enter the correct answer for it to count as 'correct'

        // display a card to the user
        // ask them to enter the correct answer
        // verify if the answer is correct
        // if it is correct the card is marked as 'correct'
        // if it is not correct the card is marked as 'incorrect'
    }
}
