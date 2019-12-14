package ua.nure.bogun.brainfuck;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PrevCommandTest {
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
    public void executePrev() {
        Inspect[] arr = {
                new Inspect(74, "KJ"),
                new Inspect(82, "SR"),
                new Inspect(99, "dc"),
                new Inspect(115, "ts"),
                new Inspect(64, "A@"),

        };


        for (Inspect com : arr) {
            BrainFuck brainFuck = new BrainFuck();
            brainFuck.next();

            PrevCommand prevCommand = new PrevCommand(brainFuck,1);
            int n = (int) com.command;
            while (n > 0) {
                brainFuck.increment();
                n--;
            }
            prevCommand.execute();
            n = (int) com.command + 1;
            while (n > 0) {
                brainFuck.increment();
                n--;
            }
            brainFuck.output();
            brainFuck.next();
            brainFuck.output();
            assertEquals(com.expected, OUTPUT_OUT.toString());
            OUTPUT_OUT.reset();
        }
    }

}