package nl.tue.assignments.automata;

import java.util.ArrayList; 
import java.util.Scanner;

/**
 * Automatons A and B.
 * 
 * TODO 3: FIll in your names and student IDs:
 * 
 * @author Shiyun Kong
 * @id 1920847
 * @author Xiuqi Shi
 * @id 1935526
 */

class ABAutomaton {
    Scanner scanner = new Scanner(System.in);

    /**
     * Converts a boolean array representing a generation into a string representation.
     * This method replaces 'true' values with '*' and 'false' values with ' ' (space) to create
     * a visual representation of the generation.
     *
     * @param gen The boolean array representing the generation.
     * @return A string representation of the generation with '*' for 'true' and ' ' for 'false'.
     */
    String genToString(boolean[] gen) {
        // TODO 5
        String[] line = new String[gen.length];
        for (int i = 0; i < gen.length; i++) {
            if (!gen[i]) {
                line[i] = " ";
            } else {
                line[i] = "*";
            }
        }
        StringBuilder result = new StringBuilder();
        for (String placement : line) {
            result.append(placement); // Add a space between elements
        }
        return result.toString();
    }

    /**
     * with input of "A"
     * Computes the next generation of a cellular automaton based on a given generation.
     * This method applies a specific rule to determine the state of 
     * each cell in the next generation based on the state of 
     * neighboring cells in the current generation.
     * 
     * @param gen The boolean array representing the current generation of cells.
     * @return A boolean array representing the next generation of cells.
     */
    boolean[] nextGenA(boolean[] gen) {
        // TODO 7
        boolean[] genA = new boolean[gen.length];
        for (int i = 0; i < gen.length; i++) {
            if (gen[i]) { // if occupied
                genA[i] = false;
                if ((i - 1) < 0) { // extreme case left
                    if (gen[i + 1]) {
                        genA[i] = true;
                    }
                } else if ((i + 1) >= gen.length) { // extreme case right
                    if (gen[i - 1]) {
                        genA[i] = true;
                    }
                } else if ((gen[i - 1] || gen[i + 1]) && !(gen[i - 1] && gen[i + 1])) { 
                    // exclusive OR
                    genA[i] = true;
                }
            } else if (!gen[i]) { // if not occupied
                genA[i] = false;
                if ((i - 1) < 0) { // extreme case left
                    if (gen[i + 1]) {
                        genA[i] = true;
                    }
                } else if ((i + 1) >= gen.length) { // extreme case right
                    if (gen[i - 1]) {
                        genA[i] = true;
                    }
                } else if (gen[i - 1] || gen[i + 1]) { // inclusive OR
                    genA[i] = true;
                }
            }

        }
        return genA;
    }

    /**
     * with input of "B"
     * Computes the next generation of a cellular automaton based on 
     * a given generation using a different rule.
     * This method applies a specific rule to determine the 
     * state of each cell in the next generation
     * based on the state of neighboring cells in the current generation. 
     * The rule applied in this method differs from the rule in the previous `nextGenA` method.
     * @param gen The boolean array representing the current generation of cells.
     * @return A boolean array representing the next generation of cells.
     */
    boolean[] nextGenB(boolean[] gen) {
        // TODO 9
        boolean[] genB = new boolean[gen.length];
        for (int i = 0; i < gen.length; i++) {
            if (gen[i]) { // if occupied
                genB[i] = true;
                if ((i - 1) < 0) { // extreme case left
                    if (gen[i + 1]) {
                        genB[i] = false;
                    }
                } else if ((i + 1) >= gen.length) { // extreme case right
                    if (gen[i - 1]) {
                        genB[i] = true;
                    }
                } else if (gen[i + 1]) { // only left
                    genB[i] = false;
                }
            } else if (!gen[i]) {
                // if not occupied
                genB[i] = false;
                if ((i - 1) < 0) { // extreme case left
                    if (gen[i + 1]) {
                        genB[i] = true;
                    }
                } else if ((i + 1) >= gen.length) { // extreme case right
                    if (gen[i - 1]) {
                        genB[i] = true;
                    }
                } else if ((gen[i - 1] || gen[i + 1]) && !(gen[i - 1] && gen[i + 1])) { 
                    // exclusive OR
                    genB[i] = true;
                }
            }
        }
        return genB;
    }

    /**
     * Reads and interprets the initial generation of cells from user input based on a given length.
     * This method expects a specific input format to specify the positions of cells in the 
     * initial generation. The input should start with "init_start," 
     * followed by one or more positive integers, and ends with "init_end."
     * These integers designate the position of the cells in the initial generation, 
     * with the first cell having position 1. Any positions greater than the specified 
     * generation length (L) are ignored, and all other cells are initially empty (false).
     * @param length The length of the generation to be initialized.
     * @return A boolean array representing the initial generation of cells.
     */
    boolean[] readInitalGeneration(int length) {
        // TODO 11
        // The string init start followed by one or more positive integers, followed by the string
        // init end. These integers designate the position of the cells in the initial generation. 
        // Note: The first cell in a generation has position 1. 
        // All cells that aren’t specified are initially empty. 
        // When an integer is higher than the generation length L, that number should be ignored.
        boolean trigger = scanner.next().equals("init_start");
        ArrayList<String> initialPoint = new ArrayList<String>();
        while (trigger) {
            String temp = scanner.next();
            if (temp.equals("init_end")) {
                trigger = false;
            } else {
                initialPoint.add(temp);
            }
        }
        boolean[] gen = new boolean[length];
        for (int i = 0; i < length; i++) {
            gen[i] = false;
            for (int j = 0; j < initialPoint.size(); j++) {
                if (i == (Integer.parseInt(initialPoint.get(j)) - 1)) {
                    gen[i] = true;
                }
            }
        }
        return gen;
    }

    void run() {
        // Read input to configure the automaton
        String automaton = scanner.next();
        int genLength = scanner.nextInt();
        int numOfGens = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(genLength);
        // Run the automaton
        boolean[] gen = initGen;
        for (int i = 0; i < numOfGens; i++) {
            // Display the current generation
            System.out.println(genToString(gen));

            // And determine the next generation
            if ("A".equals(automaton)) {
                gen = nextGenA(gen);
            } else {
                // B
                gen = nextGenB(gen);
            }
        }
    }

    public static void main(String[] args) {
        new ABAutomaton().run();
    }
}
