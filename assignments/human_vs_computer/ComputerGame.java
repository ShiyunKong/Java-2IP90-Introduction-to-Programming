import java.util.Scanner;

/**
 * Simple number guessing game for computers.
 * 
 * Usage:
 * Think of a number and type "go". Your computer starts guessing
 * your number. Reply "lower" when the guess is too high, "higher" 
 * when it is too low, and "guessed" when the computer guessed
 * your number correctly.
 * 
 * TODO: Documentation
 * <p> The purpose of this program is to implement a simple number 
 * guessing game for computers. In this game, 
 * the computer attempts to guess an integer number 
 * between 0 and 999 that the user is thinking of. 
 * The user interacts with the computer by providing feedback after each guess. 
 * The user can respond with "higher" if the computer's guess is too low, 
 * "lower" if it's too high, 
 * and "guessed" if the computer has guessed the correct number. 
 * The game continues until one of the following conditions is met: 
 * the user reveals the correct number, the computer gives up after 10 attempts, 
 * or there is no more input available from the user.
 * END TODO
 * 
 * @author Shiyun Kong
 * @id     1920874
 * @author Xiuqi Shi
 * @id     1935526
 * @date   16 sep 2021
 */
public class ComputerGame {
    /**
     * Write a program that lets the computer play a simple number guessing game. The program asks
     * the user to think of an integer number between 0 and 999 (yes, 999, not 99), and the computer
     * tries to guess it.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * This method implements a number guessing game where the computer attempts to guess
     * an integer number between 0 and 999 that the user is thinking of. The user provides feedback
     * to each guess, responding with "higher" if the computer's guess is too low, "lower" 
     * if it's too high, and "guessed" if the computer guessed correctly. The game continues 
     * until the user reveals the correct number, the computer gives up after 10 attempts, 
     * or there is no more input available from the user.
     * 
     * Input a secret number not smaller than 0 and not greater than 999.
     * Input The user should type 'go' to start the game
     * Input "higher" if the computer's guess is too low.
     * Input "lower" if the computer's guess is too high.
     * Input "guessed" if the computer has guessed the correct number.
     * Output: computer guessed numbers.
     */
    void run() {
        // TODO: Implementation
        //The first line of the output is:
        System.out.println("Think of a secret number not " 
            + "smaller than 0 and not greater than 999. " 
            + "Type 'go' when you have one.");
        final String signal = sc.nextLine();
        int minInt = 0;
        int maxInt = 1000;
        final int chances = 10;
        int guess = 0;
        String[] hints = new String [chances + 3];
        int [] records = new int [chances + 3];
        //Once the user had thought of a number to guess,
        //again called the code, they input the text “go”.
        if (signal.equals("go")) {
            for (int i = 0; i < chances + 1; i++) {
                guess = (maxInt - minInt) / 2 + minInt;
                System.out.println(guess);
                records[i + 2] = guess;
                String response = sc.nextLine();
                hints[0] = "what";
                hints[1] = "what";
                hints[i + 2] = response;
                if ("guessed".equals(response)) {
                    break;
                } else if (i + 1 == 10) {
                    System.out.println("I give up");
                    break;
                } else {
                    //first layer
                    if ("higher".equals(response)) {
                        if (hints[i + 1].equals("lower")) {
                            if (hints[i].equals("lower")) {
                                maxInt = records[i + 1];
                                minInt = records[i + 2];
                            } else if (hints[i].equals("higher")) {
                                maxInt = records[i + 1];
                                minInt = records[i + 2];
                            } else {
                                maxInt = records[i + 1];
                                minInt = records[i + 2];
                            }
                            //hints[i+1].equals("higher") or none
                        } else {
                            if (hints[i].equals("lower")) {
                                minInt = records[i + 2];
                            } else if (hints[i].equals("higher")) {
                                minInt = records[i + 2];
                            } else {
                                minInt += (maxInt - minInt) / 2;
                            }
                        }
                        //first layer
                    } else if ("lower".equals(response)) {
                        if (hints[i + 1].equals("higher")) {
                            if (hints[i].equals("higher")) {
                                maxInt = records[i + 2];
                                minInt = records[i + 1];
                            } else if (hints[i].equals("lower")) {
                                maxInt = records[i + 2];
                                minInt = records[i + 1];
                            } else {
                                maxInt = records[i + 2];
                                minInt = records[i + 1];
                            }
                            //hints[i+1].equals("lower") or none
                        } else {
                            if (hints[i].equals("higher")) {
                                maxInt = records[i + 2];
                            } else if (hints[i].equals("lower")) {
                                maxInt = records[i + 2];
                            }  else {
                                maxInt /=  2;
                            }
                        }
                    }
                }
            }
        }


        // END TODO
    }

    public static void main(String[] args) {
        new ComputerGame().run();
    }
}
