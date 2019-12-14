package ua.nure.bogun.brainfuck;

public class PrintCommand implements Command {
    private BrainFuck brainFuck;
    private int count;

    PrintCommand(BrainFuck brainFuck, int count) {
        this.brainFuck = brainFuck;
        this.count = count;
    }

    @Override
    public void execute() {
        int n = count;
        while (n > 0) {
            brainFuck.output();
            n--;
        }
    }

}
