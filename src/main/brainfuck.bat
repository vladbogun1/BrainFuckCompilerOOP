@echo off
cd java/
set arg1=%1
javac ua\nure\bogun\brainfuck\*.java
java -cp . ua.nure.bogun.brainfuck.Demo %arg1%
del ua\nure\bogun\brainfuck\*.class
cd ../
