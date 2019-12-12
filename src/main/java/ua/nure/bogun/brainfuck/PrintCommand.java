package ua.nure.bogun.brainfuck;

public class PrintCommand implements Command {
    private BrainFuck brainFuck;

    PrintCommand(BrainFuck brainFuck){
        this.brainFuck = brainFuck;
    }

    @Override
    public void execute() {
        brainFuck.output();
    }

}
