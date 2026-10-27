public class Main {
    public static void main(String[] args) {
        SimpleHashtable hashtable = new SimpleHashtable();

        Player player1 = new Player("Alex");
        Player player2 = new Player("John");
        Player player3 = new Player("Mark");

        hashtable.put("Alex", player1);
        hashtable.put("John", player2);
        hashtable.put("Mark", player3);

        System.out.println("Original Hashtable:");
        hashtable.printHashtable();

        System.out.println("\nGetting Alex:");
        System.out.println(hashtable.get("Alex"));

        System.out.println("\nRemoving John:");
        hashtable.remove("John");

        System.out.println("\nHashtable After Removal:");
        hashtable.printHashtable();

        System.out.println("\nGetting John:");
        System.out.println(hashtable.get("John"));
    }
}