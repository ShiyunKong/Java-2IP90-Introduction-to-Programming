package nl.tue.assignments.automata;

public class testab {
    boolean[] nextGenA(boolean[] gen) {
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
                } else if (gen[i + 1]) {
//                    only left
                    genB[i] = false;
                }
            } else if (!gen[i]) {
                // if not occupied
                genB[i] = false;
                if ((i - 1) < 0) {
//                    extreme case left
                    if (gen[i + 1]) {
                        genB[i] = true;
                    }
                } else if ((i + 1) >= gen.length) {
//                     extreme case right
                    if (gen[i - 1]) {
                        genB[i] = true;
                    }
                } else if ((gen[i - 1] || gen[i + 1]) && !(gen[i - 1] && gen[i + 1])) {
//                    exclusive OR
                    genB[i] = true;
                }
            }
        }
        return genB;
    }

    String genToString(boolean[] gen) {
        // TODO 5
        String[] line = new String[gen.length];
        for (int i = 0; i < gen.length; i++) {
            if (!gen[i]) {
                line[i] = "false, ";
            } else {
                line[i] = "true, ";
            }
        }
        StringBuilder result = new StringBuilder();
        for (String placement : line) {
            result.append(placement); // Add a space between elements
        }
        return result.toString();
    }

    void run() {
        boolean[] gen = {false, false, false, true, true};
        System.out.println(genToString(nextGenA(gen)));
    }
    public static void main(String[] args) {
        new testab().run();
    }
}