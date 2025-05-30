## M6 Assignment: Project 3: Turtle Graphics Interpreter, Visitor Pattern, and Framework Integration
### Quy Nguyen
### Dr. Magda Tsintsadze
### CS635 - Advanced Object-Oriented Design & Programming
### December 7, 2024

## Documentation:

### Introduction:
This project was made possible by leveraging existing frameworks, libraries, and resources online to help set a foundation
of understanding as well as providing guidance on new concepts to aid in my implementation of the turtle interpreter.
I will go over each task step by step and provide details about the process and the implementation step while also
taking into consideration the objective of this project.

* Reinforce understanding of interpretation, abstract syntax trees, and the visitor pattern in programming languages.
* Apply principles of coupling and cohesion to enhance overall design and structure of the interpreter.
* Explore and integrate relevant frameworks or libraries to improve extensibility and maintainability of the solution.
* Emphasize the importance of testing using a mock Turtle class and ensure code verification in the context of framework.

### 1. Interpreter Implementation:
Implementing an interpreter is completely new to me and after some research and from what I gathered, I found that 
interpreters are commonly comprised of three key components; a lexer, a parser, and interpreter.

* The Lexer: reads the input and converts it into tokens
* The Parser: reads the tokens and converts them into an abstract syntax tree
* The Interpreter: reads the abstract syntax tree and executes the program. 

After reading some code snippets and experimenting with ANTLR4, I felt like I was ready to create my own interpreter.
To note, in practical situations or professional settings it is highly unlikely you would create an interpreter from
scratch. Instead, leveraging available frameworks, tools, and libraries such ANTLR4, FastParse, Parsec, or other
parser combinator libraries would be the best way to go.

For this task I will create a simple interpreter for a simplified turtle graphics program. To begin we have to define
the grammar for the turtle program. The grammar is as follows:

```"fd" <distance> | "bk" <distance> | "rt" <angle> | "lt" <angle>```

An example program would look like this:

```
fd 10
rt 90
fd 5 
lt 90 
fd 15
lt 90
bk 20
rt 180
```

This turtle program interpreter will consist of the following components:

Lexer: This will read the input and convert it into tokens
Parser: This will read the tokens and convert them into an abstract syntax tree
Interpreter: This will read the abstract syntax tree and execute the program

After completing my manual implementation of the interpreter, I decided leverage ANTLR4 for the rest of the project.

To start the interpreter implementation using ANTLR4, I first had to define the grammar file, Turtle.g4. After
the grammar file was completed I generated the lexer and parser using the ANTLR4 tool. The generated files are located
in the TurtleInterpreterEnhanced/generated folder. This was a lot simpler and more efficient than my manual 
implementation. To complete task one I created a visitor class TurtleCommandVisitor that extends the TurtleBaseVisitor
class generated by ANTLR4. This visitor class will traverse the abstract syntax tree and execute the turtle program as
well. For the implementation of the visitor class, I had to override a bunch of methods to handle each type of command.
I then checked that the TurtleCommandVisitor class was working correctly by cross-referencing the output of the 
command list created by the visitor class with the turtle program I created. That concluded task one.

### 2. Visitor Pattern Integration:
The objective of task two was to create a visitor that would traverse the AST and record memento objects representing
the state of the turtle after each step. To accomplish this I created a new visitor class, TurtleMementoVisitor along
with a new class, TurtleMemento, to store the state of the turtle. The TurtleMementoVisitor class extends the
TurtleBaseVisitor class generated by ANTLR4 and overrides the methods to record the state of the turtle after each
step. The TurtleMementoVisitor class would store the memento objects in a list, which I could use to view the state of
the turtle after each program step was executed. In order for this to work I had to override several methods to handle
the calculation of the turtle's new position after each command. I then tested the TurtleMementoVisitor class by
executing the turtle program and checking the memento list to ensure the state of the turtle was being recorded
correctly. The TurtleMementoVisitor class also allows execution of the turtle program in a step-by-step manner using the
collected mementos. The TurtleMementoVisitor class is also the class that reports the net distance with the help
of the final memento object which contains the final state or position of the turtle.

### 3. Total Distance Visitor:
The objective of task three was to create a visitor that would calculate the total distance traveled by the turtle 
in a given program. To accomplish this I created a new visitor class, TurtleTotalDistanceVisitor, that extends the
TurtleBaseVisitor class generated by ANTLR4. The TurtleTotalDistanceVisitor class overrides the methods to calculate
several methods to calculate the total distance traveled by the turtle. This visitor class also creates a list that
accumulates the total distance traveled by the turtle for each step. For turns the distance was always 0, distance
is always equal to the input value for distance for moving forward and backward, and the distance when turtle is
sent to a new location using goTo is calculated using the distance formula. I tested the TurtleTotalDistanceVisitor
class by executing the turtle program and checking the total distance traveled by the turtle for each step.

### 4. Geometry and Location Computation:
The objective of task four was to understand and implement geometric calculations to determine the new location of the
turtle based on its current position, heading, and distance traveled. The geometric calculations are implemented in
several of the visitor classes as well as the Mock Turtle class where needed.

### 5. Coupling and Cohesion Emphasis:
In my project I believe the coupling between modules is relatively low and the cohesion is relatively high.
I have seperated the visitor classes so that they were only responsible for specific tasks. TurtleCommandVisitor
is solely responsible for traversing the AST and recording all the commands in the program with the added functionality
of executing the program. TurtleMementoVisitor is responsible for traversing the AST and recording the state of the
turtle after each step. TurtleTotalDistanceVisitor is responsible for traversing the AST has sole responsibility for
calculating the total distance traveled by the turtle. The use of the Turtle interface along with MockTurtle for
testing purposes aids in reducing coupling with the use of an interface. Also leveraging ANTLR4 for the lexer and
parser greatly reduced the coupling the parser logic.

My project also shows high cohesion for each of the visitor classes. Each visitor class has a single responsibility and
within those classes each method has specific tasks that they are intended for. The TurtleCommandVisitor class is and
its methods are primarily responsible for recording the commands in the program. The TurtleMementoVisitor class and
its methods are primarily responsible for recording the state of the turtle after each step along with a method to
report the net distance of the turtle. The TurtleTotalDistanceVisitor class and its methods are primarily responsible
for calculating the total distance traveled by the turtle throughout the program. The MockTurtle class is responsible
for mimicking the behavior of a real turtle class and is used for testing purposes.

The design decisions in regard to how I decided to implement the visitor classes, the mock turtle class, and use of
ANTLR4 impacted the overall structure of the interpreter and the interactions between components greatly. By thinking
about how to create highly cohesive modules as well as thinking of how to keep coupling at a minimum or very loose
it allowed me to leverage other solid principles such as dependency inversion with the use of the Turtle interface
and MockTurtle class.

### 6. Framework Integration:
Leveraging frameworks in my project was a key component in the success of this project. 
ANTLR4 greatly influenced the code organization, maintainability, and over system architecture for the better. It is
very modular and easy to understand and maintain. The use of ANTLR4 significantly increased the organization and
maintainability of code by allowing changes to be made a lot easier and its ability to autogenerate the lexer and parser
files is terrific. During the testing phase I found that I overlooked the inclusion of negative integers in the grammar
file and experienced a lot of test failures. I was able to quickly fix this by making a small adjustment in the
grammar file and regenerating the lexer and parser files. I could only imagine what I would have to go through if I 
had to manually change it. I have also left my attempt at a manual implementation of the interpreter in the project
and as you can see the implementation with ANTLR4 is a lot more organized and easier to understand.

### 7. Mock Turtle Class:
MockTurtle class was implemented along with a Turtle interface to mimic the behavior of a real turtle class. The mock
performs a majority of the functions that a real turtle class would, excluding the drawing on the screen. The MockTurtle
class was used to test the interpreter, visitor pattern, and framework integration without relying on graphical output.

```
This is the composite list of commands, mementos, and distances:
Command: Turtle 10 10 90 | Memento - (10,10,90) | Distance: 0.0
Command: Forward 100 | Memento - (10,110,90) | Distance: 100.0
Command: Right 90 | Memento - (10,110,0) | Distance: 100.0
Command: Forward 90 | Memento - (100,110,0) | Distance: 190.0
Command: Left 90 | Memento - (100,110,90) | Distance: 190.0
Command: Backward 50 | Memento - (100,60,90) | Distance: 240.0
Command: Forward 50 | Memento - (100,110,90) | Distance: 290.0
Command: Goto 0 0 | Memento - (0,0,90) | Distance: 290.0
Command: Goto 100 0 | Memento - (100,0,90) | Distance: 390.0
Command: Goto 0 0 | Memento - (0,0,90) | Distance: 490.0
Command: SetHeading 180 | Memento - (0,0,180) | Distance: 490.0
Command: Backward 50 | Memento - (50,0,180) | Distance: 540.0
Command: Forward 50 | Memento - (0,0,180) | Distance: 590.0
Command: Backward 50 | Memento - (50,0,180) | Distance: 640.0
Command: SetHeading 90 | Memento - (50,0,90) | Distance: 640.0
Command: Forward 50 | Memento - (50,50,90) | Distance: 690.0
Command: Right 180 | Memento - (50,50,270) | Distance: 690.0
Command: Forward 50 | Memento - (50,0,270) | Distance: 740.0
This is the total and net distance traveled by the turtle
Total distance traveled: 740.0
Net distance traveled: 50.0
```

<img src="CodeCoverage.png">


#### Special Thanks to:
https://www.antlr.org/

https://www.doc.ic.ac.uk/~phjk/Compilers/Exercises/Ex1-TurtleInterpreter/Ex1-TurtleInterpreter.html

https://craftinginterpreters.com/

https://www.toptal.com/scala/writing-an-interpreter

https://ruslanspivak.com/lsbasi-part7/