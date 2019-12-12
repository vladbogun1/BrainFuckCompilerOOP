package ua.nure.bogun.brainfuck;

public class Array {
    private static final int LENGTH = 65535;
    public byte[] arr;
    private int pointer;
    Array(){
        arr = new byte[LENGTH];
        pointer = 0;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        if(pointer>=arr.length) {
            this.pointer = 0;
        } else if(pointer<0) {
            this.pointer = arr.length - 1;
        } else {
            this.pointer = pointer;
        }

    }
}
