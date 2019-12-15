package ua.nure.bogun.brainfuck;

public class PrintPointerCommand implements Command {
    private BrainFuck brainFuck;
    private int count;

    PrintPointerCommand(BrainFuck brainFuck, int count) {
        this.brainFuck = brainFuck;
        this.count = count;
    }

    @Override
    public void execute() {
        int n = count;
        while (n > 0) {
            brainFuck.printPointer();
            n--;
        }
    }

}
