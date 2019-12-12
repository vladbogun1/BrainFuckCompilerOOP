package ua.nure.bogun.brainfuck;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Representing BrainFuck Compiler:");
        Compiler compiler = new Compiler(">+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.>++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.");
        compiler.execute();
    }
}
