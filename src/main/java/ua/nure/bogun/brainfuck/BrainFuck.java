package ua.nure.bogun.brainfuck;
import java.util.List;

class BrainFuck {
    private Array memory;

    BrainFuck() {
        this.memory = new Array();
    }

    void next() {
        memory.setPointer(memory.getPointer() + 1);
    }

    void prev() {
        memory.setPointer(memory.getPointer() - 1);
    }

    void increment() {
        memory.arr[memory.getPointer()]++;
    }

    void decrement() {
        if (memory.arr[memory.getPointer()] > 0) {
            memory.arr[memory.getPointer()]--;
        }
    }

    void output() {
        System.out.print((char) memory.arr[memory.getPointer()]);
    }

    void printPointer(){
        System.out.print(memory.getPointer());
    }

    void loop(List<Command> commands) {
        if(!commands.isEmpty()) {
            while (memory.arr[memory.getPointer()] > 0) {
                for (Command command : commands) {
                    command.execute();
                }
            }
        }
    }
}
