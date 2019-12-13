package ua.nure.bogun.brainfuck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayTest {


    @Test
    public void getPointer() {
        Array arr = new Array();
        Inspect[] pointers = {
                new Inspect(102,102),
                new Inspect(0,0),
                new Inspect(-29,65506),
                new Inspect(65555,20)
        };

        for (Inspect pointer: pointers) {
            arr.setPointer((int)pointer.command);

            assertEquals(pointer.expected,arr.getPointer());
        }
    }

    @Test
    public void setPointer() {
        Array arr = new Array();
        Inspect[] pointers = {
                new Inspect(102,102),
                new Inspect(0,0),
                new Inspect(-29,65506),
                new Inspect(65555,20)
        };

        for (Inspect pointer: pointers) {
            assertEquals(pointer.expected, arr.setPointer((int)pointer.command));
        }
    }
}