package ua.nure.bogun.brainfuck;

public class PrevCommand implements Command{
    private BrainFuck brainFuck;

    PrevCommand(BrainFuck brainFuck){
        this.brainFuck = brainFuck;
    }

    @Override
    public void execute() {
        brainFuck.prev();
    }
}
