package nl.tue.assignments.automata;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Universal Automaton.
 * 
 * TODO 3: Fill in your names and student IDs
 * 
 * @author Shiyun Kong
 * @id 1920874
 * @author Xiuqi Shi
 * @id 1935526
 */
class UniversalAutomaton {
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
        // TODO 13: Copy from ABAutomaton.java
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
     * Generates the next generation of cells based on the given rule sequence 
     * and the current generation.
     * @param ruleSequence A boolean array representing the rule sequence with eight elements.
     *                     Each element corresponds to a pattern in the automaton's rules.
     *                     A value of true indicates that the pattern should produce a cell 
     *                     with the next generation, while false indicates that it should not.
     * 
     * @param gen The current generation of cells represented as a boolean array.
     *            Each element represents the state of a cell, where true indicates 
     *            an occupied cell, and false indicates an empty cell.
     * 
     * @return A boolean array representing the next generation of cells, 
     *         where each element represents the state of a cell in the next generation, 
     *         based on the provided rule sequence and current generation.
     */
    boolean[] nextGen(boolean[] ruleSequence, boolean[] gen) {
        // TODO 14
        boolean[] nextGen = new boolean[gen.length];
        for (int i = 0; i < gen.length; i++) {
            if (i == 0) { // left limit
                if (!gen[i] && !gen[i + 1]) { // pattern number 0
                    if (!ruleSequence[0]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[0]) {
                        nextGen[i] = true;
                    }
                } else if (!gen[i] && gen[i + 1]) { // pattern number 1
                    if (!ruleSequence[1]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[1]) {
                        nextGen[i] = true;
                    }
                } else if (gen[i] && !gen[i + 1]) { // pattern number 2
                    if (!ruleSequence[2]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[2]) {
                        nextGen[i] = true;
                    }
                } else if (gen[i] && gen[i + 1]) { // pattern number 3
                    if (!ruleSequence[3]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[3]) {
                        nextGen[i] = true;
                    }
                } else if (!gen[i] && !gen[i + 1]) { // pattern number 4
                    if (!ruleSequence[4]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[4]) {
                        nextGen[i] = true;
                    }
                } else if (!gen[i] && gen[i + 1]) { // pattern number 5
                    if (!ruleSequence[5]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[5]) {
                        nextGen[i] = true;
                    }
                } else if (gen[i] && !gen[i + 1]) { // pattern number 6
                    if (!ruleSequence[6]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[6]) {
                        nextGen[i] = true;
                    }
                } else if (gen[i] && gen[i + 1]) { // pattern number 7
                    if (!ruleSequence[7]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[7]) {
                        nextGen[i] = true;
                    }
                }
            } else if (i == gen.length - 1) { // right limit
                if (!gen[i - 1] && !gen[i]) { // pattern number 0
                    if (!ruleSequence[0]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[0]) {
                        nextGen[i] = true;
                    }
                } else if (!gen[i - 1] && !gen[i]) { // pattern number 1
                    if (!ruleSequence[1]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[1]) {
                        nextGen[i] = true;
                    }
                } else if (!gen[i - 1] && gen[i]) { // pattern number 2
                    if (!ruleSequence[2]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[2]) {
                        nextGen[i] = true;
                    }
                } else if (!gen[i - 1] && gen[i]) { // pattern number 3
                    if (!ruleSequence[3]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[3]) {
                        nextGen[i] = true;
                    }
                } else if (gen[i - 1] && !gen[i]) { // pattern number 4
                    if (!ruleSequence[4]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[4]) {
                        nextGen[i] = true;
                    }
                } else if (gen[i - 1] && !gen[i]) { // pattern number 5
                    if (!ruleSequence[5]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[5]) {
                        nextGen[i] = true;
                    }
                } else if (gen[i - 1] && gen[i]) { // pattern number 6
                    if (!ruleSequence[6]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[6]) {
                        nextGen[i] = true;
                    }
                } else if (gen[i - 1] && gen[i]) { // pattern number 7
                    if (!ruleSequence[7]) {
                        nextGen[i] = false;
                    } else if (ruleSequence[7]) {
                        nextGen[i] = true;
                    }
                }
            } else if (!gen[i - 1] && !gen[i] && !gen[i + 1]) { // pattern number 0
                if (!ruleSequence[0]) {
                    nextGen[i] = false;
                } else if (ruleSequence[0]) {
                    nextGen[i] = true;
                }
            } else if (!gen[i - 1] && !gen[i] && gen[i + 1]) { // pattern number 1
                if (!ruleSequence[1]) {
                    nextGen[i] = false;
                } else if (ruleSequence[1]) {
                    nextGen[i] = true;
                }
            } else if (!gen[i - 1] && gen[i] && !gen[i + 1]) { // pattern number 2
                if (!ruleSequence[2]) {
                    nextGen[i] = false;
                } else if (ruleSequence[2]) {
                    nextGen[i] = true;
                }
            } else if (!gen[i - 1] && gen[i] && gen[i + 1]) { // pattern number 3
                if (!ruleSequence[3]) {
                    nextGen[i] = false;
                } else if (ruleSequence[3]) {
                    nextGen[i] = true;
                }
            } else if (gen[i - 1] && !gen[i] && !gen[i + 1]) { // pattern number 4
                if (!ruleSequence[4]) {
                    nextGen[i] = false;
                } else if (ruleSequence[4]) {
                    nextGen[i] = true;
                }
            } else if (gen[i - 1] && !gen[i] && gen[i + 1]) { // pattern number 5
                if (!ruleSequence[5]) {
                    nextGen[i] = false;
                } else if (ruleSequence[5]) {
                    nextGen[i] = true;
                }
            } else if (gen[i - 1] && gen[i] && !gen[i + 1]) { // pattern number 6
                if (!ruleSequence[6]) {
                    nextGen[i] = false;
                } else if (ruleSequence[6]) {
                    nextGen[i] = true;
                }
            } else if (gen[i - 1] && gen[i] && gen[i + 1]) { // pattern number 7
                if (!ruleSequence[7]) {
                    nextGen[i] = false;
                } else if (ruleSequence[7]) {
                    nextGen[i] = true;
                }
            }
        }
        return nextGen;
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
        // TODO 16: Copyt from ABAutomaton.java
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

    /**
     * Reads and interprets a rule sequence from user input.
     * The rule sequence consists of eight values, each represented as "0" or "1," 
     * which correspond to patterns in the automaton's rules.
     * A "0" represents "false," and a "1" represents "true."
     * @return A boolean array representing the rule sequence with eight elements.
     *         Each element corresponds to a pattern in the automaton's rules.
     *         A value of true (1) indicates that the pattern should produce a 
     *         cell with the next generation, while false (0) indicates that it should not.
     */
    boolean[] readRuleSequence() {
        // TODO 17
        boolean[] pattern = new boolean[8];
        for (int i = 0; i < 8; i++) {
            String temp = scanner.next();
            if (temp.equals("0")) {
                pattern[i] = false;
            } else if (temp.equals("1")) {
                pattern[i] = true;
            }
        }
        return pattern;
    }

    void run() {
        // Read input to configure the universal automaton
        boolean[] ruleSequence = readRuleSequence();
        int generationLength = scanner.nextInt();
        int numberOfGenerations = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(generationLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numberOfGenerations; i++) {
            // Display the current generation0
            System.out.println(genToString(gen));
            // Determine the next generation
            gen = nextGen(ruleSequence, gen);
        }
    }

    public static void main(String[] args) {
        new UniversalAutomaton().run();
    }
}
