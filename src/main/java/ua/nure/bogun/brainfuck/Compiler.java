package ua.nure.bogun.brainfuck;

import java.util.ArrayList;
import java.util.List;

public class Compiler {
    private List<Command> list;
    private char[] brainFuckCommand;
    private BrainFuck compiler;

    Compiler(String command){
        this.compiler = new BrainFuck();
        this.list = new ArrayList<>();
        this.brainFuckCommand = command.toCharArray();
        read();
    }

    private void read(){
        for (char command: brainFuckCommand) {
            switch (command){
                case '>':
                    list.add(new NextCommand(compiler));
                    break;
                case '<':
                    list.add(new PrevCommand(compiler));
                    break;
                case '+':
                    list.add(new IncrementCommand(compiler));
                    break;
                case '-':
                    list.add(new DecrementCommand(compiler));
                    break;
                case '.':
                    list.add(new PrintCommand(compiler));
                    break;
                default:
                    System.out.println("Wrong command!");
                    break;
            }
        }

    }
    public void execute(){
        for (Command command: list) {
            command.execute();
        }
    }
}
