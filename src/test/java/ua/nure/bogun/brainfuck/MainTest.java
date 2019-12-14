package ua.nure.bogun.brainfuck;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayTest.class,
        BrainFuckTest.class,
        IncrementCommandTest.class,
        DecrementCommandTest.class,
        NextCommandTest.class,
        PrevCommandTest.class,
        PrintCommandTest.class,
        PrintPointerCommandTest.class,
        LoopCommandTest.class,
        CompilerTest.class,
        DemoTest.class
})

public class MainTest extends Assert {

}