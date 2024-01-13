package nl.tue.assignments.automata;

public class test {
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

    String genToString(boolean[] gen) {
        // TODO 13: Copy from ABAutomaton.java
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

    void run () {
        boolean[] gen = {true};
        boolean[] ruleSequence = {true, false, true, false, true, false, true, false};
        gen = nextGen(ruleSequence, gen);
        System.out.println(genToString(gen));
    }

    public static void main(String[] args) {
        new test().run();
    }
}
