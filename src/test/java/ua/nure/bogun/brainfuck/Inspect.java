package ua.nure.bogun.brainfuck;

class Inspect {
    Object command;
    Object expected;

    Inspect(Object command, Object expected) {
        this.command = command;
        this.expected = expected;
    }
}
