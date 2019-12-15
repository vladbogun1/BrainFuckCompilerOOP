package ua.nure.bogun.brainfuck;

public class LoopCommand implements Command {
    private BrainFuck brainFuck;
    private Compiler loopCompiler;

    LoopCommand(BrainFuck brainFuck,char[] charsArr){
        this.brainFuck = brainFuck;
        this.loopCompiler = new Compiler(charsArr,brainFuck);
    }

    @Override
    public void execute() {
        brainFuck.loop(loopCompiler.getList());
    }
}
