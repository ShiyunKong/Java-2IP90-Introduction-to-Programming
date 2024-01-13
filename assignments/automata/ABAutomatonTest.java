package nl.tue.assignments.automata;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test ABAutomaton.
 * 
 * TODO 3: FIll in your names and student IDs
 * @author Shiyun Kong
 * @id 1920874
 * @author Xiuqi Shi
 * @id 1935526
 */
public class ABAutomatonTest {
    ABAutomaton automaton = new ABAutomaton();

    @Test
    public void testGenToString() {
        // TODO 6: 
        // Add at least 5 test cases.
        // Motivate each test case with a line comment like this.
        
        //Test all true
        boolean[] gen = {true, true, true, true};
        String expected = "****";
        String result = automaton.genToString(gen);
        assertEquals(expected, result);

        //Test all false
        boolean[] gen1 = {false, false, false, false};
        String expected1 = "    ";
        String result1 = automaton.genToString(gen1);
        assertEquals(expected1, result1);

        //Test combination of true and false
        boolean[] gen2 = {true, false};
        String expected2 = "* ";
        String result2 = automaton.genToString(gen2);
        assertEquals(expected2, result2);

        //Test very long generation
        boolean[] gen3 = {true, false, true, false, true, 
            false, true, false, true, false, true, false};
        String expected3 = "* * * * * * ";
        String result3 = automaton.genToString(gen3);
        assertEquals(expected3, result3);

        //Test correct false spacing before true
        boolean[] gen4 = {false, false, false, true, true, true};
        String expected4 = "   ***";
        String result4 = automaton.genToString(gen4);
        assertEquals(expected4, result4);
    }

    @Test
    public void testNextGenA() {
        // TODO 8: 
        // Add at least 8 test cases.
        // Motivate each test case with a line comment like this.

        // Case 1 testAllOccupied
        boolean[] gen1 = {true, true, true, true, true};
        boolean[] expected1 = {true, false, false, false, true};
        assertArrayEquals(expected1, automaton.nextGenA(gen1));

        // Case 2 testAllUnoccupied
        boolean[] gen2 = {false, false, false, false, false};
        boolean[] expected2 = {false, false, false, false, false};
        assertArrayEquals(expected2, automaton.nextGenA(gen2));

        // Case 3 testOccupiedExtremes
        boolean[] gen3 = {true, false, false, false, true};
        boolean[] expected3 = {false, true, false, true, false};
        assertArrayEquals(expected3, automaton.nextGenA(gen3));

        // Case 4 testUnoccupiedExtremes
        boolean[] ge4n = {false, true, true, true, false};
        boolean[] expecte4d = {true, true, false, true, true};
        assertArrayEquals(expecte4d, automaton.nextGenA(ge4n));

        // Case 5 testMixedOccupied
        boolean[] gen5 = {true, false, true, false, true};
        boolean[] expected5 = {false, true, false, true, false};
        assertArrayEquals(expected5, automaton.nextGenA(gen5));

        // Case 6 testMixedUnoccupied
        boolean[] gen6 = {false, true, false, true, false};
        boolean[] expected6 = {true, false, true, false, true};
        assertArrayEquals(expected6, automaton.nextGenA(gen6));

        // Case 7 testTripleTrue
        boolean[] gen7 = {true, true, true, false, false};
        boolean[] expected7 = {true, false, true, true, false};
        assertArrayEquals(expected7, automaton.nextGenA(gen7));

        // Case 8 testTripleFalse
        boolean[] gen8 = {false, false, false, true, true};
        boolean[] expected8 = {false, false, true, true, true};
        assertArrayEquals(expected8, automaton.nextGenA(gen8));

        // Case 9 TTF
        boolean[] gen9 = {true, true, true};
        boolean[] expected9 = {true, false, true};
        assertArrayEquals(expected9, automaton.nextGenA(gen9));
    }

    @Test
    public void testNextGenB() {
        // TODO 10: 
        // Add at least 8 test cases.
        // Motivate each test case with a line comment like this.

        // Case 1 testAllOccupied
        boolean[] gen1 = {true, true, true, true, true};
        boolean[] expected1 = {false, false, false, false, true};
        assertArrayEquals(expected1, automaton.nextGenB(gen1));

        // Case 2 testAllUnoccupied
        boolean[] gen2 = {false, false, false, false, false};
        boolean[] expected2 = {false, false, false, false, false};
        assertArrayEquals(expected2, automaton.nextGenB(gen2));

        // Case 3 testOccupiedExtremes
        boolean[] gen3 = {true, false, false, false, true};
        boolean[] expected3 = {true, true, false, true, true};
        assertArrayEquals(expected3, automaton.nextGenB(gen3));

        // Case 4 testUnoccupiedExtremes
        boolean[] ge4n = {false, true, true, true, false};
        boolean[] expecte4d = {true, false, false, true, true};
        assertArrayEquals(expecte4d, automaton.nextGenB(ge4n));

        // Case 5 testMixedOccupied
        boolean[] gen5 = {true, false, true, false, true};
        boolean[] expected5 = {true, false, true, false, true};
        assertArrayEquals(expected5, automaton.nextGenB(gen5));

        // Case 6 testMixedUnoccupied
        boolean[] gen6 = {false, true, false, true, false};
        boolean[] expected6 = {true, true, false, true, true};
        assertArrayEquals(expected6, automaton.nextGenB(gen6));

        // Case 7 testTripleTrue
        boolean[] gen7 = {true, true, true, false, false};
        boolean[] expected7 = {false, false, true, true, false};
        assertArrayEquals(expected7, automaton.nextGenB(gen7));

        // Case 8 testTripleFalse
        boolean[] gen8 = {false, false, false, true, true};
        boolean[] expected8 = {false, false, true, false, true};
        assertArrayEquals(expected8, automaton.nextGenB(gen8));
    }

}
