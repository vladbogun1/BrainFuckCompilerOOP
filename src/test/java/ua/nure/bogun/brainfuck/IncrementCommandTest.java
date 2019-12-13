package ua.nure.bogun.brainfuck;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class IncrementCommandTest {

    private final ByteArrayOutputStream OUTPUT_OUT = new ByteArrayOutputStream();
    private final ByteArrayOutputStream OUTPUT_ERR = new ByteArrayOutputStream();
    private final PrintStream ORIGIN_OUT = System.out;
    private final PrintStream ORIGIN_ERR = System.err;



    @Before
    public void setUp() {
        System.setOut(new PrintStream(OUTPUT_OUT));
        System.setErr(new PrintStream(OUTPUT_ERR));
    }

    @After
    public void tearDown() {
        System.setOut(ORIGIN_OUT);
        System.setErr(ORIGIN_ERR);
    }

    @Test
    public void executeIncrement() {
        BrainFuck brainFuck = new BrainFuck();
        IncrementCommand incrementCommand = new IncrementCommand(brainFuck);
        incrementCommand.execute();

        brainFuck.output();
        char oldItem = OUTPUT_OUT.toString().toCharArray()[0];
        OUTPUT_OUT.reset();
        brainFuck.increment();
        brainFuck.output();
        char newItem = OUTPUT_OUT.toString().toCharArray()[0];
        OUTPUT_OUT.reset();
        assertEquals(oldItem+1,newItem);
    }
}