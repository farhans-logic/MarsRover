# Mars Rover

## User Guide

1. Run the command line interface from src/main/java/org/marsrover/App.java
2. Once mission control has loaded, a mission will be created.
3. Enter the mission name when prompted.
4. Enter the mission data in the specified format, example:
    - line 1: 3 3
    - line 2: 2 2 W
    - line 3: LLRRMMRRMM
5. Once data is input, further data can be entered by answering Y/N on the prompt.
6. Each set of 3 lines of data will assign a new rover to the mission.
7. Once no more data is entered by indicating N on the prompt, the mission will start.
8. Each rover will be deployed to the surface based on the given coordinates.
9. It is assumed that the navigable surface includes the zero x-axis and y-axis points.
10. The system will not prevent the rover being deployed outside the navigable surface.
11. The system will provide an alert if a rover is deployed outside the surface and is lost.
12. The system will prevent the rover from moving outside the navigable surface once it is
successfully deployed. 
13. The final location of each rover will be displayed once a successful mission is complete.
14. Once the entire mission is complete, another mission can be started from the prompt.

- A reasonable degree of user input validation exists but some edge cases can break the control flow.
- Further improvements/enhancements are indicated in the TODOs throughout the application.
- Some extended functionality has be added but is an incomplete feature for future releases.