package ua.nure.bogun.brainfuck;

public class Demo {

    public static void main(String[] args) {
        String command = (args.length > 0 && args[0] != null) ? args[0] :
                "++++++++++[>+>+++>+++++++>++++++++++<<<<-]" +
                        ">>>++++++++++++++.>+++++++++++++++++++++" +
                        ".---------.-----------.<<++.>>--.++++++++++++" +
                        ".--..------------.+++++++++++++.----------.<<" +
                        ".>>---.++++++++++++++++++.<<.>+++++++++++++.>-" +
                        ".<++++++.>+++.<++++++.--------.>-------.++++++.";
        BrainFuck brainFuck = new BrainFuck();
        Compiler compiler = new Compiler(command, brainFuck);
        compiler.execute();
    }
}
