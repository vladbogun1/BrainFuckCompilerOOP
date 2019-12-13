package ua.nure.bogun.brainfuck;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

//    @Test
//    public void next() {
//        int[] pointers = {1,2,3,44,5555,0,-1,65535};
//        BrainFuck brainFuck = new BrainFuck();
//        for (int point : pointers) {
//            int n = point;
//            while(n>0){
//                brainFuck.next();
//                n++;
//            }
//
//            assertEquals(point+1, brainFuck.getPointer());
//        }
//    }

//    @Test
//    public void prev() {
//        int[] pointers = {1,2,3,44,5555,0,-1,65535};
//        BrainFuck brainFuck = new BrainFuck();
//        for (int point : pointers) {
//            int n = point;
//            while(n>0){
//                brainFuck.prev();
//                n++;
//            }
//            assertEquals(point-1, brainFuck.getPointer());
//        }
//    }

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
        assertEquals(oldItem+1,newItem);
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
        assertEquals(oldItem-1,newItem);
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
    public void loop() {
    }
}