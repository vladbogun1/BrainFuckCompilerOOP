package ua.nure.bogun.brainfuck;

class Array {
    private static final int LENGTH = 65535;
    byte[] arr;
    private int pointer;

    Array() {
        arr = new byte[LENGTH];
        pointer = 0;
    }

    int getPointer() {
        return pointer;
    }

    int setPointer(int pointer) {
        if (pointer >= arr.length) {
            this.pointer = pointer - arr.length;
        } else if (pointer < 0) {
            this.pointer = arr.length + pointer;
        } else {
            this.pointer = pointer;
        }
        return this.pointer;
    }
}
