package ua.nure.bogun.brainfuck;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DemoTest {
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
    public void doRunMain() {



        Inspect[] tests = {
                new Inspect("++++++++[>++++[>++>+++>+++>+<<<<-]" +
                        ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+" +
                        "++.------.--------.>>+.", "Hello World!"),
                new Inspect("6++++++++[>++++[>++>+++>+++>+<<<<-]" +
                        ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.++" +
                        "+.------.--------.>>+.", "Wrong command!" +
                        SEPARATOR + "Hello World!"),
                new Inspect("", ""),
                new Inspect(null, "Command can not be null!" + SEPARATOR),
                new Inspect("++++++++[>++++[>++>+++>+++>+<<<<-" +
                        ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+" +
                        "++.------.--------.>>+.", "Braces were not closed properly!" + SEPARATOR)
        };
        for (Inspect test : tests) {
            BrainFuck brainFuck = new BrainFuck();
            Compiler compiler = new Compiler((String)test.command, brainFuck);
            compiler.execute();
            assertEquals(test.expected, OUTPUT_OUT.toString());
            OUTPUT_OUT.reset();
            OUTPUT_ERR.reset();
        }
    }

}