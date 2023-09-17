import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 10;

        int totalAttempts = 0;
        int totalRounds = 0;

        while (true) {
            int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;
            totalRounds++;

            System.out.println("Round " + totalRounds);
            System.out.println("Guess the number between " + lowerLimit + " and " + upperLimit);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Sorry, you've used up all " + maxAttempts + " attempts. The correct number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();

        System.out.println("\nGame Over!");
        System.out.println("You played " + totalRounds + " rounds and took " + totalAttempts + " total attempts.");
        if (totalRounds > 0) {
            double averageAttempts = (double) totalAttempts / totalRounds;
            System.out.printf("Average attempts per round: %.2f%n", averageAttempts);
        }
    }
}

