package ua.nure.bogun.brainfuck;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PrintCommandTest {
    private final ByteArrayOutputStream OUTPUT_OUT = new ByteArrayOutputStream();
    private final ByteArrayOutputStream OUTPUT_ERR = new ByteArrayOutputStream();
    private final PrintStream ORIGIN_OUT = System.out;
    private final PrintStream ORIGIN_ERR = System.err;
    private final String SEPARATOR = System.lineSeparator();


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
    public void executePrint() {
        Inspect[] arr = {
                new Inspect(74, "J"),
                new Inspect(82, "R"),
                new Inspect(99, "c"),
                new Inspect(115, "s"),
                new Inspect(64, "@"),

        };


        for (Inspect com : arr) {
            BrainFuck brainFuck = new BrainFuck();
            PrintCommand printCommand = new PrintCommand(brainFuck,1);
            int n = (int) com.command;
            IncrementCommand incrementCommand = new IncrementCommand(brainFuck,n);
            incrementCommand.execute();

            printCommand.execute();
            assertEquals(com.expected, OUTPUT_OUT.toString());
            OUTPUT_OUT.reset();
        }


    }
}