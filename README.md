# Mars Rover Mission Control

The Mars Rover Mission Control application is designed to control and manage missions for Mars rovers. This application
allows users to create and manage missions, deploy rovers, and issue commands to navigate the rovers on the Martian
surface.

## Table of Contents

- [Introduction](#introduction)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Components](#components)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Mars Rover Mission Control application is a Java-based program that simulates the control and operation of Mars
rovers on the Martian surface. It includes several classes and components to handle various aspects of mission control,
rover movement, and surface navigation.

## Getting Started

### Prerequisites

Before running the Mars Rover Mission Control application, ensure you have the following prerequisites installed:

- Java Development Kit (JDK) 8 or higher

## Usage

The Mars Rover Mission Control application provides a command-line interface (CLI) for interacting with the system.
Follow these steps to use the application:

1. Launch the application by running `org.marsrover.App`.

2. Create a new mission by entering a mission name.

3. Enter the maximum exploratory coordinates for the mission in the format `X Y`, e.g., `10 10`.

4. Deploy a rover by specifying its initial location in the format `X Y H`, where `X` and `Y` are coordinates, and `H`
   is the heading (N, W, S, or E).

5. Issue commands to the rover using a sequence of letters (L, R, and M) to rotate left, rotate right, and move forward,
   respectively.

6. View the current location of the rover after executing commands.

7. Optionally continue commanding the vehicle or create new missions.

8. Exit the application when done.

## Components

The Mars Rover Mission Control application is structured into several packages, each containing related classes:

- `org.marsrover`: Contains the main application class (`App`) for launching the program.

- `org.marsrover.vehicle`: Contains classes related to Mars rovers and their movement.

- `org.marsrover.location`: Contains classes for handling coordinates, headings, and rover locations.

- `org.marsrover.surface`: Contains classes for defining the Martian surface and handling obstacles.

- `org.marsrover.mission`: Contains classes for managing missions, mission data, and mission control.

- `org.marsrover.UserInterface`: Contains the CLI interface for interacting with the application.

## Contributing

Contributions to the Mars Rover Mission Control application are welcome. If you would like to contribute to the project,
please follow these steps:

1. Fork the repository.

2. Create a new branch for your feature or bug fix.

3. Make your changes and commit them.

4. Push your changes to your fork.

5. Create a pull request to merge your changes into the main repository.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
