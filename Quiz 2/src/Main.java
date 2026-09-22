public class Main {
    public static void main(String[] args) {
        PlayerLinkedList playerList = new PlayerLinkedList();

        playerList.add(new Player(1, "Goku", 500));
        playerList.add(new Player(2, "Saitama", 999));
        playerList.add(new Player(3, "Sakamoto", 10));

        playerList.printList();

        System.out.println("\nSize: " + playerList.size());

        Player removed = playerList.remove();
        System.out.println("Removed: " + removed);

        System.out.println("Size: " + playerList.size());
    }
}