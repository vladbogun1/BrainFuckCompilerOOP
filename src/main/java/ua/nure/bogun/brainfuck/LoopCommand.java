package ua.nure.bogun.brainfuck;

public class LoopCommand implements Command {
    private BrainFuck brainFuck;
    private char[] charsArr;
    private Compiler loopCompiler;

    LoopCommand(BrainFuck brainFuck,char[] charsArr){
        this.brainFuck = brainFuck;
        this.charsArr = charsArr;
        this.loopCompiler = new Compiler(new String(charsArr),brainFuck);
    }

    @Override
    public void execute() {
        brainFuck.loop(loopCompiler.getList());
    }
}
