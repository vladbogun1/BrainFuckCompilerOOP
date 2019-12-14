package ua.nure.bogun.brainfuck;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;


import static org.junit.Assert.*;

public class BrainFuckTest {
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
    public void next() {
        Inspect[] tests = {
                new Inspect(1, "2"),
                new Inspect(2, "3"),
                new Inspect(3, "4"),
                new Inspect(44, "45"),
                new Inspect(-1, "1"),
                new Inspect(65534, "0")
        };


        for (Inspect point : tests) {
            BrainFuck brainFuck = new BrainFuck();
            int n = (int) point.command;
            while (n > 0) {
                brainFuck.next();
                n--;
            }
            brainFuck.next();
            brainFuck.printPointer();
            assertEquals(point.expected, OUTPUT_OUT.toString());
            OUTPUT_OUT.reset();
        }
    }

    @Test
    public void prev() {
        Inspect[] tests = {
                new Inspect(1, "0"),
                new Inspect(2, "1"),
                new Inspect(3, "2"),
                new Inspect(44, "43"),
                new Inspect(-1, "65534")
        };


        for (Inspect point : tests) {
            BrainFuck brainFuck = new BrainFuck();
            int n = (int) point.command;
            while (n > 0) {
                brainFuck.next();
                n--;
            }
            brainFuck.prev();
            brainFuck.printPointer();
            assertEquals(point.expected, OUTPUT_OUT.toString());
            OUTPUT_OUT.reset();
        }
    }

    @Test
    public void increment() {
        BrainFuck brainFuck = new BrainFuck();

        brainFuck.output();
        char oldItem = OUTPUT_OUT.toString().toCharArray()[0];
        OUTPUT_OUT.reset();
        brainFuck.increment();
        brainFuck.output();
        char newItem = OUTPUT_OUT.toString().toCharArray()[0];
        OUTPUT_OUT.reset();
        assertEquals(oldItem + 1, newItem);
    }

    @Test
    public void decrement() {
        BrainFuck brainFuck = new BrainFuck();

        brainFuck.increment();
        brainFuck.increment();

        brainFuck.output();
        char oldItem = OUTPUT_OUT.toString().toCharArray()[0];
        OUTPUT_OUT.reset();
        brainFuck.decrement();
        brainFuck.output();
        char newItem = OUTPUT_OUT.toString().toCharArray()[0];
        OUTPUT_OUT.reset();
        assertEquals(oldItem - 1, newItem);
    }

    @Test
    public void output() {
        String expected = " !\"#$%&'()*+,-./0123456789:;<=>" +
                "?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`" +
                "abcdefghijklmnopqrstuvwxyz{|}~";
        BrainFuck brainFuck = new BrainFuck();
        int chars = 126;
        int i = 0;
        while (i < chars) {
            brainFuck.increment();
            i++;
            if (i > 31) {
                brainFuck.output();
            }
        }
        assertEquals(expected, OUTPUT_OUT.toString());
        OUTPUT_OUT.reset();
        OUTPUT_ERR.reset();
    }

    @Test
    public void printPointer() {
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
            brainFuck.printPointer();
            assertEquals(point.expected, OUTPUT_OUT.toString());
            OUTPUT_OUT.reset();
        }

    }

    @Test
    public void loop() {
        BrainFuck brainFuck = new BrainFuck();


        Inspect[] tests = {
                new Inspect(
                        new LinkedList<>(
                                Arrays.asList(
                                        new IncrementCommand(brainFuck,1),
                                        new PrintCommand(brainFuck,1),
                                        new NextCommand(brainFuck,1)
                                )
                        ), new byte[]{3,2}
                ),
                new Inspect(
                        new LinkedList<>(
                                Arrays.asList(
                                        new DecrementCommand(brainFuck,1),
                                        new PrintCommand(brainFuck,1),
                                        new NextCommand(brainFuck,1)
                                )
                        ), new byte[]{1,0}
                ),
                new Inspect(
                        new LinkedList<>(), new byte[]{}
                )

        };
        for (Inspect test: tests) {
            brainFuck.increment();
            brainFuck.increment();



            brainFuck.next();
            brainFuck.increment();
            brainFuck.prev();
            LinkedList<Command> loop = (LinkedList)test.command;
            brainFuck.loop(loop);


            assertEquals(
                    new String((byte[])test.expected),
                    OUTPUT_OUT.toString()
            );
            OUTPUT_OUT.reset();
        }
    }


}