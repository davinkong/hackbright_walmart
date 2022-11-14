import java.util.*;

public class GuessingGame {
    public GuessingGame() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the guessing game!");
        System.out.println("Enter your name: ");
        String name = scan.nextLine();
        System.out.println(name + ", I'm thinking of a number between 1 and 100.");
        System.out.println("Try to guess my number.");

        //generate random number from 1 - 100
        Random rand = new Random();

        int randomNum = 1 + rand.nextInt(100);

        int guessNum = 0;
        int count = 0;
        while (guessNum != randomNum) {
            count++;
            try {
                guessNum = scan.nextInt();
            } catch (InputMismatchException e) {
                String badInput = scan.nextLine();
                System.out.println("That's not an integer, try again.");
                continue;
            }
            if (guessNum < 1 || guessNum > 100) {
                System.out.println("Number needs to be between 1 - 100");
                continue;
            }
            if (guessNum == randomNum) {
                System.out.println(randomNum);
                System.out.println("Well done, " + name + "! You found my number" + " in " + count + " tries!\n");
            } else if (guessNum < randomNum) {
                System.out.println("Your guess is too low, try again.");
            } else if (guessNum > randomNum) {
                System.out.println("Your guess is too high, try again.");
            }


        }
    }
}
