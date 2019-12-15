package ua.nure.bogun.brainfuck;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class LoopCommandTest {
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
    public void executeLoop() {



        Inspect[] tests = {
                new Inspect(
                        "+-.>", new byte[]{2, 1}
                ),
                new Inspect(
                        "++.>", new byte[]{4, 3}
                ),
                new Inspect(
                        "--.>", new byte[]{0, 0}
                )

        };
        for (Inspect test : tests) {
            BrainFuck brainFuck = new BrainFuck();
            brainFuck.increment();
            brainFuck.increment();


            brainFuck.next();
            brainFuck.increment();
            brainFuck.prev();

            LoopCommand loopCommand = new LoopCommand(
                    brainFuck,
                    ((String)test.command).toCharArray()
            );
            loopCommand.execute();


            assertEquals(
                    new String((byte[]) test.expected),
                    OUTPUT_OUT.toString()
            );
            OUTPUT_OUT.reset();
        }
    }
}