package ua.nure.bogun.brainfuck;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CompilerTest {
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
    public void getList() {
        BrainFuck brainFuck = new BrainFuck();
        Inspect[] tests = {
                new Inspect("++",
                        new ArrayList<>(
                                Arrays.asList(
                                        new IncrementCommand(brainFuck),
                                        new IncrementCommand(brainFuck)
                                )
                        )
                ),
                new Inspect("-+",
                        new ArrayList<>(
                                Arrays.asList(
                                        new DecrementCommand(brainFuck),
                                        new IncrementCommand(brainFuck)
                                )
                        )
                ),
                new Inspect("",
                        new ArrayList<>()
                )

        };
        for (Inspect test : tests) {

            Compiler compiler = new Compiler((String) test.command, brainFuck);
            List output = compiler.getList();

            for (int i = 0; i < ((ArrayList) test.expected).size(); i++) {
                assertEquals(
                        ((ArrayList) test.expected).get(i).getClass(),
                        output.get(i).getClass()
                );
            }

        }
    }

    @Test
    public void executeCompiler() {
        Inspect[] tests = {
                new Inspect("++++++++[>++++[>++>+++>+++>+<<<<-]" +
                        ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+" +
                        "++.------.--------.>>+.", "Hello World!"),
                new Inspect("6+++++++@+[>++++[>++>+++>+++>+<<<<-]" +
                        ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.++" +
                        "+.------.--------.>>+.", "Wrong command!" +
                        SEPARATOR + "0Hello World!"),
                new Inspect("", ""),
                new Inspect(null, "Command can not be null!" + SEPARATOR),
                new Inspect("++++++++[>++++[>++>+++>+++>+<<<<-" +
                        ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+" +
                        "++.------.--------.>>+.", "Braces were not closed properly!" + SEPARATOR)
        };
        for (Inspect test : tests) {
            BrainFuck brainFuck = new BrainFuck();
            Compiler compiler = new Compiler((String) test.command, brainFuck);
            compiler.execute();
            assertEquals(test.expected, OUTPUT_OUT.toString());
            OUTPUT_OUT.reset();
            OUTPUT_ERR.reset();
        }

    }
}