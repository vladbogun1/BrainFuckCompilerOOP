# BrainFuckCompilerOOP
Java compiler from BrainFuck code to text
<h3><b>Run</b></h3>

1. Go to <code>BrainFuckCompilerOOP/src/main/</code> directory.
2. Open CMD
3. Run command <code>brainfuck "%COMMAND%"</code> where <code>%COMMAND%</code> is your command

<h5><b>For example:</b></h5>
<code>C:\BrainFuckCompilerOOP\src\main>brainfuck "++++++++++++++++++++++++++++++++++++++."

&</code>
<h3><b>Task</b></h3>
<h5><b>Brainfuck Compiler</b></h5>

Write a Java program that runs a program written in the language
Brainfuck

Input: Brainfuck line of instructions

<code>++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.</code>
 
Output: a string containing the output of a executed program 
<code>Hello World!</code>

<h3><b>Additional requirements:</b></h3>

The implementation of the program should consist of 2 stages:

1. Compilation. An input line is used to construct a data model using the principles
OOP and design patterns.
2. Execution. To execute the program according to the constructed model, without
access to the original line.

The input command <code>,</code> does not need to be supported

Write the necessary Unіt and functional tests.

Java 8, Gradle, Github.


<h3><b>BrainFuck commands:</b></h3>


	
<code>>	increment the data pointer (to point to the next cell to the right).</code>

<code><	decrement the data pointer (to point to the next cell to the left).</code>

<code>+	increment (increase by one) the byte at the data pointer.</code>

<code>-	decrement (decrease by one) the byte at the data pointer.</code>

<code>.	output the byte at the data pointer.</code>

<code>,	accept one byte of input, storing its value in the byte at the data pointer.</code>

<code>[	if the byte at the data pointer is zero, then instead of moving the instruction pointer forward to the next command, jump it forward to the command after the matching ] command.</code>

<code>]	if the byte at the data pointer is nonzero, then instead of moving the instruction pointer forward to the next command, jump it back to the command after the matching [ command.</code>


