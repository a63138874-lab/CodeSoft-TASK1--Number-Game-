import java.util.Random;
import java.util.Scanner;

public class numberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        boolean playAgain = true;

        System.out.println("=== Welcome to Number Guessing Game ===");

        while (playAgain) {
            int number = rand.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println(" Correct! You guessed the number in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1); // scoring logic
                    guessedCorrectly = true;
                    break;
                } else if (guess < number) {
                    System.out.println(" Too low!");
                } else {
                    System.out.println(" Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println(" You ran out of attempts! The number was: " + number);
            }

            System.out.println(" Your current score: " + score);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n Final Score: " + score);
        System.out.println(" Thanks for playing!");
        sc.close();
    }
}