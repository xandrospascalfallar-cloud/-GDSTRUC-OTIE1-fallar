import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        ArrayQueue queue = new ArrayQueue(10);

        int playerID = 1;
        int gamesMade = 0;

        while (gamesMade < 10) {
            System.out.println("\n========== MATCHMAKING ==========");
            System.out.println("Games made: " + gamesMade + "/10");
            System.out.println("Players in queue: " + queue.size());

            System.out.print("Press Enter to start the next turn...");
            input.nextLine();

            int x = rand.nextInt(7) + 1;

            System.out.println("\nAdding " + x + " players to the queue:");

            for (int i = 0; i < x; i++) {
                Player player = new Player(
                        playerID,
                        "Player " + playerID,
                        rand.nextInt(1000) + 1
                );

                queue.enqueue(player);
                System.out.println("Enqueued: " + player);

                playerID++;
            }

            System.out.println("\nCurrent Queue:");
            queue.printQueue();

            while (queue.size() >= 5 && gamesMade < 10) {
                gamesMade++;

                System.out.println("\n========== GAME " + gamesMade + " ==========");
                System.out.println("Match found! The following players will play:");

                for (int i = 0; i < 5; i++) {
                    System.out.println(queue.dequeue());
                }

                System.out.println("Game " + gamesMade + " successfully created!");
                System.out.println("Players remaining in queue: " + queue.size());
            }
        }

        System.out.println("\n=================================");
        System.out.println("Matchmaking complete!");
        System.out.println("Total games created: " + gamesMade);
        System.out.println("Players remaining in queue: " + queue.size());

        input.close();
    }
}