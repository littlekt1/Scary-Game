import java.util.Scanner;
import java.util.Random;

public class HorrorGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean hasKey = false;
        int health = 100; // Initialize player's health

        System.out.println("Welcome to the Horror Game!");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.println("You find yourself in a dark, creepy mansion at night.");
        System.out.println("You must find a way to escape before something terrible happens.");

        while (health > 0) {
            System.out.println("\nYou are in the main hallway. What do you want to do?");
            System.out.println("1. Explore the mansion, searching a random room.");
            System.out.println("2. Try to exit the mansion through the spooky front door.");
            System.out.println("3. Take off your shoes, let the dogs out (your toes) and go sit on the dusty couch and watch tv.");

            int choice = scanner.nextInt();

            if (choice == 1) {
                hasKey = exploreRoom(random, hasKey, health);
                if (random.nextDouble() < 0.2) {
                    health -= 20; // Losing health during a scare event
                    scare();
                }
            } else if (choice == 2) {
                if (hasKey) {
                    System.out.println("\nCongratulations, " + playerName + "! You've escaped the haunted mansion!");
                    break;
                } else {
                    System.out.println("\nYou try to exit the mansion, but the door is locked. You hear a spooky laugh in the distance.");
                    System.out.println("You need to find a key to unlock it.");
                }
            } else if (choice == 3) {
                health -= 100; // Losing health during a scare event
                System.out.println("\nThe ghost eats your toes! And he doesn't have cable! YOU DIED!");
                break; // End the game immediately when the player chooses option 3
            }

            System.out.println("Your health: " + health);
        }

        if (health <= 0) {
            System.out.println("You've succumbed to the horrors of the mansion. Game over!");
        }


        scanner.close();
    }

    public static boolean exploreRoom(Random random, boolean hasKey, int health) {
        System.out.println("\nYou enter a dark and spooky room.");
        if (random.nextDouble() < 0.2) {
            health -= 30; // Losing health during a scare event
            scare();
        } else {
            System.out.println("You find an old key while exploring.");
            hasKey = true;
        }
        return hasKey;
    }

    public static void scare() {
        System.out.println("\nA terrifying ghost suddenly appears and chases you!");
        System.out.println("You run away in panic!");
    }
}
