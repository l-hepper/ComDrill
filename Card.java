public class Card {

    String front;
    String back;

    public Card(String front, String back) {
        this.front = front;
        this.back = back;
    }

    protected String getFront() {
        return this.front;
    }

    protected String getBack() { // to where you once belonged
        return this.back;
    }
    
}
