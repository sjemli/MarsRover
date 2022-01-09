<h1> MARS ROVER </h1>
Version: 1.4, Last updated: 2021-02-02

Author : Seif JEMLI

<hr>
<h2> Description :</h2>
The application simulates controlling the movement of a Rover by applying commands.
The inputs are the initial position of the rover (x, y, direction) and the set of commands to apply.

<h2> Technologies Used : </h2>

Jdk version = java 11

Maven version = 3.6.3

<h2> Running the project</h2>

To launch the application, you need to import it to your IDE and run the class MarsRoverApp that contains the main() method. 
You can also build the project using the following commands :

```
cd MarsRover
mvn clean install
cd target
java -jar MarsRover-1.0-SNAPSHOT.jar
```

<hr>
<h2> Solution Explanation</h2>

**Main** class : It is the entry class for the application. It uses the InputReader class to collect the user input, instantiates 
the Rover and passes the commands to the Rover.

**InputReader** class : contains the methods used to read and validate the user input
(Rover initial coordinates, Rover initial direction, commands list to apply) from the command line.

Two Enumerations :
- **Command** : contains the list of possible commands (F, B, L, R). Each enum has an attribute called "sens". 
  It is useful for making the nextCoordinate() algorithm more generic.
  
  F => sens = 1;
  
  B => sens = -1;
  
  R,L => sens = 0;
  
- **Direction** : contains the possible directions (NORTH, SOUTH, EAST, WEST). 
  It also contains two methods : 
    * rotateLeft : the direction that results from a 90 degrees rotation to the left.
    * rotateRight : the direction that results from a 90 degrees rotation to the right.


**Rover** class : it represents the Rover. 
It has two attributes. The direction and the coordinate. 

It has a method applyCommands that has as input a commands string.


The method nextCoordinate() returns the next point based on the current coordinate, the direction and the command.


**Coordinate** class : it represents a point described by  its x and y.
