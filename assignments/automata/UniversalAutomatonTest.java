import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test UniversalAutomaton.
 * 
 * TODO 3: Fill in your names and student IDs
 * 
 * @author Shiyun Kong
 * @id 1920874
 * @author Xiuqi Shi
 * @id 1935526
 */
public class UniversalAutomatonTest {
    UniversalAutomaton automaton = new UniversalAutomaton();

    @Test
    public void testGenToString() {
        // TODO 13:
        // Copy your test cases from ABAutomatonTest.java
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
    public void testNextGen() {
        // TODO 15:
        // Motivate each test case with a line comment like this.
        // Test All False
        boolean[] ruleSequence = {false, false, false, false, false, false, false, false};
        boolean[] gen = {false, false, false, false, false, false, false, false};
        boolean[] expected = {false, false, false, false, false, false, false, false};
        assertArrayEquals(expected, automaton.nextGen(ruleSequence, gen));
        
        // Test All True
        boolean[] ruleSequence1 = {true, true, true, true, true, true, true, true};
        boolean[] gen1 = {true, true, true, true, true, true, true, true};
        boolean[] expected1 = {true, true, true, true, true, true, true, true};
        assertArrayEquals(expected1, automaton.nextGen(ruleSequence1, gen1));
        
        // Test Alternating True and False
        boolean[] ruleSequence2 = {true, false, true, false, true, false, true, false};
        boolean[] gen2 = {true, false, true, false, true, false, true, false};
        boolean[] expected2 = {true, false, true, false, true, false, true, true};
        assertArrayEquals(expected2, automaton.nextGen(ruleSequence2, gen2));

        // Test Custom Rule and Gen
        boolean[] ruleSequence3 = {false, true, false, true, false, true, false, true};
        boolean[] gen3 = {true, false, true, false, true, false, true, false};
        boolean[] expected3 = {false, true, false, true, false, true, false, false};
        assertArrayEquals(expected3, automaton.nextGen(ruleSequence3, gen3));
        
        // Test Custom Rule and Gen (Partially True)
        boolean[] ruleSequence4 = {false, true, false, true, false, true, false, true};
        boolean[] gen4 = {true, true, true, true, true, true, true, true};
        boolean[] expected4 = {true, true, true, true, true, true, true, false};
        assertArrayEquals(expected4, automaton.nextGen(ruleSequence4, gen4));
        
        // Test Custom Rule and Gen (Partially False)
        boolean[] ruleSequence5 = {false, true, false, true, false, true, false, true};
        boolean[] gen5 = {false, false, false, false, false, false, false, false};
        boolean[] expected5 = {false, false, false, false, false, false, false, false};
        assertArrayEquals(expected5, automaton.nextGen(ruleSequence5, gen5));

        // Test Single True in the Middle
        boolean[] ruleSequence6 = {true, true, true, true, true, true, true, true};
        boolean[] gen6 = {false, false, false, true, false, false, false, false};
        boolean[] expected6 = {true, true, true, true, true, true, true, true};
        assertArrayEquals(expected6, automaton.nextGen(ruleSequence6, gen6));

        // Test Single True at the Edges
        boolean[] ruleSequence7 = {true, true, true, true, true, true, true, true};
        boolean[] gen7 = {true, false, false, false, false, false, false, true};
        boolean[] expected7 = {true, true, true, true, true, true, true, true};
        assertArrayEquals(expected7, automaton.nextGen(ruleSequence7, gen7));

        // Test Random Pattern
        boolean[] ruleSequence8 = {true, false, true, false, true, false, true, false};
        boolean[] gen8 = {false, true, false, false, true, true, false, true};
        boolean[] expected8 = {false, true, true, false, false, true, false, true};
        assertArrayEquals(expected8, automaton.nextGen(ruleSequence8, gen8));

        // Test Empty Gen
        boolean[] ruleSequence9 = {true, false, true, false, true, false, true, false};
        boolean[] gen9 = {};
        boolean[] expected9 = {};
        assertArrayEquals(expected9, automaton.nextGen(ruleSequence9, gen9));

        // Test Large Gen
        boolean[] ruleSequence10 = {true, false, true, false, true, false, true, false};
        boolean[] gen10 = {true, false, true, false, true, false, true, false, true, false};
        boolean[] expected10 = {true, false, true, false, true, false, true, false, true, true};
        assertArrayEquals(expected10, automaton.nextGen(ruleSequence10, gen10));

        // Test Rule with No True
        boolean[] ruleSequence11 = {false, false, false, false, false, false, false, false};
        boolean[] gen11 = {true, true, true, true, true, true, true, true};
        boolean[] expected11 = {false, false, false, false, false, false, false, false};
        assertArrayEquals(expected11, automaton.nextGen(ruleSequence11, gen11));

        // Test Rule with No False
        boolean[] ruleSequence12 = {true, true, true, true, true, true, true, true};
        boolean[] gen12 = {false, false, false, false, false, false, false, false};
        boolean[] expected12 = {true, true, true, true, true, true, true, true};
        assertArrayEquals(expected12, automaton.nextGen(ruleSequence12, gen12));
    }

}