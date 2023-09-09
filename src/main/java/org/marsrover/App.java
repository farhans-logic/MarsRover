package org.marsrover;

import org.marsrover.UserInterface.MissionControlCLI;

public class App {

    public static void main(String[] args) {

        MissionControlCLI cli = new MissionControlCLI();
        cli.initMissionControlApp();
    }

}
