import java.util.Scanner;
import java.util.Random;

public class HorrorGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Horror Game!");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.println("You find yourself in a dark, creepy mansion at night.");
        System.out.println("You must find a way to escape before something terrible happens.");

        boolean hasKey = false;

        while (true) {
            System.out.println("\nYou are in the main hallway. What do you want to do?");
            System.out.println("1. Explore the mansion");
            System.out.println("2. Try to exit the mansion");

            int choice = scanner.nextInt();

            if (choice == 1) {
                hasKey = exploreRoom(random, hasKey);
                if (random.nextDouble() < 0.2) {
                    scare();
                }
            } else if (choice == 2) {
                if (hasKey) {
                    System.out.println("\nCongratulations, " + playerName + "! You've escaped the haunted mansion!");
                    break;
                } else {
                    System.out.println("\nYou try to exit the mansion, but the door is locked.");
                    System.out.println("You need to find a key to unlock it.");
                }
            }
        }

        scanner.close();
    }

    public static boolean exploreRoom(Random random, boolean hasKey) {
        System.out.println("\nYou enter a dark and spooky room.");
        if (random.nextDouble() < 0.2) {
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