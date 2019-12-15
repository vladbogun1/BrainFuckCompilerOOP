package ua.nure.bogun.brainfuck;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class NextCommandTest {
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
    public void executeNext() {

        Inspect[] arr = {
                new Inspect(74, "KJ"),
                new Inspect(82, "SR"),
                new Inspect(99, "dc"),
                new Inspect(115, "ts"),
                new Inspect(64, "A@"),

        };


        for (Inspect com : arr) {
            BrainFuck brainFuck = new BrainFuck();
            NextCommand nextCommand = new NextCommand(brainFuck,1);
            int n = (int) com.command;
            IncrementCommand  incrementCommand = new IncrementCommand(brainFuck,n);
            incrementCommand.execute();
            nextCommand.execute();
            n = (int) com.command + 1;
            incrementCommand = new IncrementCommand(brainFuck,n);
            incrementCommand.execute();
            brainFuck.output();
            brainFuck.prev();
            brainFuck.output();
            assertEquals(com.expected, OUTPUT_OUT.toString());
            OUTPUT_OUT.reset();
        }
    }


}