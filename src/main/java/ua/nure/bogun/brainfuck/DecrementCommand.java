package ua.nure.bogun.brainfuck;

public class DecrementCommand implements Command {
    private BrainFuck brainFuck;

    DecrementCommand(BrainFuck brainFuck){
        this.brainFuck = brainFuck;
    }

    @Override
    public void execute() {
        brainFuck.decrement();
    }
}
