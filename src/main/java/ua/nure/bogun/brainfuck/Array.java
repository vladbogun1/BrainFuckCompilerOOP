package ua.nure.bogun.brainfuck;

class Array {
    private static final int LENGTH = 65535;
    byte[] arr;
    private int pointer;
    Array(){
        arr = new byte[LENGTH];
        pointer = 0;
    }

    int getPointer() {
        return pointer;
    }

    void setPointer(int pointer) {
        if(pointer>=arr.length) {
            this.pointer = 0;
        } else if(pointer<0) {
            this.pointer = arr.length - 1;
        } else {
            this.pointer = pointer;
        }

    }
}
