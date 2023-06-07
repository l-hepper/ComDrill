public class Card {

    private int id;
    private String front;
    private String back;

    public Card(int id, String front, String back) {
        this.id = id;
        this.front = front;
        this.back = back;
    }

    public Card(String front, String back) {

    }

    public int getid() {
        return this.id;
    }

    public String getFront() {
        return this.front;
    }

    public String getBack() {
        return this.back;
    }
    
}
