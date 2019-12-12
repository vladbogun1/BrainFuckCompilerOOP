package ua.nure.bogun.brainfuck;

public class IncrementCommand implements Command {
    private BrainFuck brainFuck;

    IncrementCommand(BrainFuck brainFuck){
        this.brainFuck = brainFuck;
    }

    @Override
    public void execute() {
        brainFuck.increment();
    }
}
