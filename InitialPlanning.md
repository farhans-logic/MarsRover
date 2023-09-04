# Mars Rover Project - Initial Planning

## General Requirements

- Create a Mars Rover java application that accepts either of the following input methods:
  - Feed inputs into tests
  - Accept input via console application
  - Input supplied via file
- Output Rover current location after processing inputs
- Only allow one rover to move at a time

### Specification

#### Plateau

- Grid representation of Plateau with x and y co-ordinates
- Direction represented by cardinal compass points N, S, W, E
- 1 unit of movement distance is +1 of either x or y-axis,
  dependent on compass point direction

#### Rover Movement Instructions
- L = Spin 90 degrees left, co-ordinates unchanged
- R = spin 90 degrees right, co-ordinates unchanged.
- M = move one grid point/square, co-ordinates are modified

#### Program Input Requirements
- First line Input max plateau grid co-ordinates with 0,0 assumed to be min
- Subsequent lines if inputs grouped by 2 lines of instructions 
  - Fist line is rover position x, y  co-ordinates within the grid and the compass facing direction
  - Second line is the sequence of movement instructions as string of letters


### UML Diagram

![](D:\Downloads2\MarRoverUMLv1.jpg)

