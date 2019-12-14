package ua.nure.bogun.brainfuck;

public class PrintPointerCommand implements Command {
    private BrainFuck brainFuck;

    PrintPointerCommand(BrainFuck brainFuck){
        this.brainFuck = brainFuck;
    }

    @Override
    public void execute() {
        brainFuck.printPointer();
    }

}
