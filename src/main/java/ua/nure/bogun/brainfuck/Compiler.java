package ua.nure.bogun.brainfuck;

import java.util.ArrayList;
import java.util.List;

public class Compiler {
    private List<Command> list;
    private BrainFuck compiler;
    private char[] brainFuckCommand;

    Compiler(String command ,BrainFuck brainFuck){
        this.compiler = brainFuck;
        this.list = new ArrayList<>();
        this.brainFuckCommand = command.toCharArray();
        read();
    }
    Compiler(char[] command ,BrainFuck brainFuck){
        this.compiler = brainFuck;
        this.list = new ArrayList<>();
        this.brainFuckCommand = command;
        read();
    }
    private void read(){


        for (int i = 0; i < brainFuckCommand.length; i++) {
            char operation = brainFuckCommand[i];

            switch (operation) {
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
                case '@':
                    list.add(new PrintPointerCommand(compiler));
                    break;
                case '[':
                    int nextPoint = getEndWhile(i);
                    char[] arr = cutLoop(i,nextPoint);
                    list.add(new LoopCommand(compiler,arr));
                    i=nextPoint;
                    break;
                case ']':
                    continue;
                default:
                    System.out.println("Wrong command!");
                    break;
            }
        }

    }

    List<Command> getList(){
        return this.list;
    }
    private int getEndWhile(int start){

        int position = start;
        int count = 1;
        for(int i = start+1;i<brainFuckCommand.length && count>0;i++){
            switch(brainFuckCommand[i]){
                case '[':
                    count++;
                    break;
                case ']':
                    count--;
                    position = i;
                    break;
            }

        }
        return position;
    }


    private char[] cutLoop(int start, int end){
        int length = end - start;
        char[] loop = new char[length];
        System.arraycopy(brainFuckCommand,start+1,loop,0,length);
        return loop;
    }

    public void execute(){
        for (Command command: list) {
            command.execute();
        }
    }
}
