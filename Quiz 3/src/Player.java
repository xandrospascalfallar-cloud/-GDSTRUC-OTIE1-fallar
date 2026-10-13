public class Player {
    private int id;
    private String name;
    private int rating;

    public Player(int id, String name, int rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", Name: " + name
                + ", Rating: " + rating;
    }
}