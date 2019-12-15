package ua.nure.bogun.brainfuck;

import java.util.ArrayList;
import java.util.List;

public class Compiler {
    private List<Command> list;
    private BrainFuck compiler;
    private char[] brainFuckCommand;

    Compiler(String command, BrainFuck brainFuck) {
        this.compiler = brainFuck;
        this.list = new ArrayList<>();
        try {
            this.brainFuckCommand = command.toCharArray();
        } catch (NullPointerException e) {
            System.out.println("Command can not be null!");
            this.brainFuckCommand = "".toCharArray();
        }
        read();
    }

    Compiler(char[] command, BrainFuck brainFuck) {
        this.compiler = brainFuck;
        this.list = new ArrayList<>();
        this.brainFuckCommand = command;
        read();
    }

    private void read() {

        int counter = 1;
        for (int i = 0; i < brainFuckCommand.length; i++) {
            char operation = brainFuckCommand[i];
            if (i+1 <brainFuckCommand.length && operation == brainFuckCommand[i + 1]){
                counter++;
            }
            else {
                switch (operation) {
                    case '>':
                        list.add(new NextCommand(compiler,counter));
                        break;
                    case '<':
                        list.add(new PrevCommand(compiler,counter));
                        break;
                    case '+':
                        list.add(new IncrementCommand(compiler,counter));
                        break;
                    case '-':
                        list.add(new DecrementCommand(compiler,counter));
                        break;
                    case '.':
                        list.add(new PrintCommand(compiler,counter));
                        break;
                    case '@':
                        list.add(new PrintPointerCommand(compiler,counter));
                        break;
                    case '[':
                        int nextPoint = getEndWhile(i);
                        if (nextPoint != -1) {
                            char[] arr = cutLoop(i, nextPoint);
                            list.add(new LoopCommand(compiler, arr));
                            i = nextPoint;
                        } else {
                            System.out.println("Braces were not closed properly!");
                            brainFuckCommand = "".toCharArray();
                        }
                        break;
                    case ']':
                        continue;
                    default:
                        System.out.println("Wrong command!");
                        break;
                }
                counter=1;
            }
        }

    }

    List<Command> getList() {
        return this.list;
    }

    private int getEndWhile(int start) {
        int position = -1;
        int count = 1;
        for (int i = start + 1; i < brainFuckCommand.length && count > 0; i++) {
            switch (brainFuckCommand[i]) {
                case '[':
                    count++;
                    break;
                case ']':
                    count--;
                    if (count == 0) {
                        position = i;
                    }
                    break;
            }
        }
        return position;
    }

    private char[] cutLoop(int start, int end) {
        int length = end - start;
        char[] loop = new char[length];
        System.arraycopy(brainFuckCommand, start + 1, loop, 0, length);
        return loop;
    }

    public void execute() {
        for (Command command : list) {
            command.execute();
        }
    }
}
