import java.util.Random; // For Scanner, Random, etc.
import java.util.Scanner; // For Scanner, Random, etc.


/** 
 * Number guessing game for humans.
 * 
 * Usage:
 * This program is a number guessing game designed for humans. 
 * In this game, you need to guess an integer number between 
 * 0 and 99 that the computer has randomly selected. 
 * You have a maximum of seven tries to guess the correct number. 
 * After the game is finished, the program will show you an overview of 
 * what happened during the game.
 * 
 * Enter a seed number, and the computer will think of a number between 0 and
 * 99 that you have to guess in at most seven tries. Afterwards, you see your
 * guessing history, so you can learn to better play the game.
 * 
 * TODO: Documentation
 * The purpose of this program is to allow a user to 
 * play a number guessing game where the computer generates 
 * a random number between 0 and 99 (inclusive), 
 * and the user has to guess the generated number within seven attempts.
 * Here are the specific input requirements for the program:
 * The user is asked to enter an arbitrary number as a seed for the random number generator. 
 * This seed will determine the sequence of random numbers generated during the game.
 * The user can make up to seven guesses to identify the randomly generated code.
 * The user is expected to input integer numbers as guesses.
 * The program will provide feedback for each guess:
        If the guess is higher than the generated code, it will print "lower."
        If the guess is lower than the generated code, it will print "higher."
        If the guess is correct, it will print "Good guess! You won."
        If the user exhausts all seven attempts without guessing correctly, 
        the program will print "No more guesses, you lost."

 * After the game concludes, the program will display a guessing history, 
 * showing how close each guess was to the actual code. 
 * It uses "X" to represent the user's guess, "|" to represent the code, 
 * and dots to fill the remaining positions in a line of 100 characters.
 * The program will repeat the game if needed or terminate based on user interaction.
 * The program begins by asking the user for a seed, generates a random code, 
 * and then proceeds with the guessing game, taking user input and providing feedback 
 * until a win or loss condition is met.
 * END TODO
 * 
 * @author Shiyun Kong 
 * @id     1920874
 * @author Xiuqi Shi
 * @id     1935526
 * @date   16 sep 2021
 */
public class HumanGame {
    /**
     * Write a program to let a user play a simple number guessing game.    
     * After the game is finished, the program
     * shows an overview of what happened in the game.
     */
    Scanner sc = new Scanner(System.in);
    Random randomGenerator;
    
    /**
     * Executes the number guessing game.
     * 
     * <p> This method implements a number guessing game where the user tries to guess a randomly
     * generated code within a limited number of attempts. The user provides integer guesses,
     * and the program provides feedback for each guess, indicating if it's higher or lower
     * than the target code. After the game ends, it displays the guessing history.
     * 
     * Input: seed The input seed for random number generator; 
     * Input: guess The guessed numbers;
     * Output: low or high of the guesses, and success / failure indication
     */
    void run() {
        // TODO: Implementation
        // Your program should ask the user first to enter this seed.
        // The first line of output is:
        System.out.println("Type an arbitrary number");
        final long seed = sc.nextLong(); // actually read from input
        randomGenerator = new Random(seed);
        // The user gets a maximum of seven guesses.
        final int chances = 7;
        // To generate a random number,
        // call the method nextInt(n) on randomGenerator.
        // This method nextInt(n) returns
        // a random number between 0 (included)
        // and n (excluded).
        final int maxInteger = 100;
        // This code is randomly chosen by the computer.
        final int code = randomGenerator.nextInt(maxInteger);
        // Then the game starts with the line:
        // The program asks the user to guess an integer number between 0 and 99, called the code.
        System.out.println("Start guessing!");
        int[] values = new int[chances + 1]; 
        // Create an array to store n(chances) values
        for (int i = 0; i < chances + 1; i++) {
            // Furthermore, the user inputs their
            // guesses as integer numbers.
            // You may assume that the input is
            // in compliance with this description.
            // Thus, when you expect the user to input an integer number,
            // you don’t have to check if the input
            // is actually an integer number or not.
            final int guess = sc.nextInt();
            // store guess
            values[i] = guess;
            // The program replies to each guess:
            if (i == 7) {
                // Furthermore, when the maximum number of seven (7) guesses
                // has been reached without a
                // good guess, your program prints:
                System.out.println("No more guesses, you lost.");
                // Afterwards, the guessing history is printed.
                System.out.println(i + " guesses:");
                for (int l = 0; l < i; l++) {
                    // For each guess, a line that shows how close your guess was.
                    for (int j = 0; j < maxInteger; j++) {
                        // The line consists of 100
                        // characters: 98 or 99 dots,
                        // an X at the position of the guess,
                        // and a | at the position of the
                        // code.
                        if (values[l] == j) {
                            System.out.print("X");
                        } else if (code == j) {
                            System.out.print("|");
                        } else {
                            System.out.print(".");
                        }
                    }
                    System.out.print("\n");
                }
                break;
            }  else {
                if (guess > code) {
                    // When the guess is higher than the code:
                    System.out.println("lower");
                }  else if (guess < code) {
                    // When the guess is lower than the code:
                    System.out.println("higher");
                } else if (guess == code) {
                    // When the player guesses right:
                    System.out.println("Good guess! You won.");
                    // Afterwards, the guessing history is printed.
                    System.out.println(i + 1 + " guesses:");
                    for (int l = 0; l < i + 1; l++) {
                        // For each guess, a line that shows how close your guess was.
                        for (int j = 0; j < maxInteger; j++) {
                            // The line consists of 100
                            // characters: 98 or 99 dots,
                            // an X at the position of the guess,
                            // and a | at the position of the
                            // code.
                            if (values[l] == j) {
                                System.out.print("X");
                            } else if (code == j) {
                                System.out.print("|");
                            } else {
                                System.out.print(".");
                            }
                        }
                        System.out.print("\n");
                    }
                    break;
                }
            }
        }
        // END TODO
    }

    public static void main(String[] args) {
        new HumanGame().run();
    }
}
