package ua.nure.bogun.brainfuck;

public class NextCommand implements Command {
    private BrainFuck brainFuck;

    NextCommand(BrainFuck brainFuck){
        this.brainFuck = brainFuck;
    }

    @Override
    public void execute() {
        brainFuck.next();
    }
}
