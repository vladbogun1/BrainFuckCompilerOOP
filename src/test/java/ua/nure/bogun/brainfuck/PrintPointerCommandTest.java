package ua.nure.bogun.brainfuck;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PrintPointerCommandTest {
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
    public void executePrintPointer() {
        Inspect[] tests = {
                new Inspect(1, "1"),
                new Inspect(2, "2"),
                new Inspect(3, "3"),
                new Inspect(44, "44"),
                new Inspect(-1, "0"),
                new Inspect(65534, "65534"),
                new Inspect(65535, "0")
        };


        for (Inspect point : tests) {
            BrainFuck brainFuck = new BrainFuck();
            int n = (int) point.command;
            while (n > 0) {
                brainFuck.next();
                n--;
            }
            PrintPointerCommand printPointerCommand = new PrintPointerCommand(brainFuck);
            printPointerCommand.execute();
            assertEquals(point.expected, OUTPUT_OUT.toString());
            OUTPUT_OUT.reset();
        }
    }

}