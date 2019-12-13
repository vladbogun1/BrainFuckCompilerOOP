package ua.nure.bogun.brainfuck;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Representing BrainFuck Compiler:");
        BrainFuck brainFuck = new BrainFuck();
        Compiler compiler = new Compiler("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.", brainFuck);
        compiler.execute();
    }
}
