package org.marsrover.UserInterface;

import org.marsrover.mission.MissionControl;

import java.util.Scanner;

public class MissionControlCLI {

    public MissionControl missionControl;

    // TODO Refactor for handling multiple missions in parallel
    public String missionName;

    private final Scanner sc;


    public MissionControlCLI() {
        System.out.println("Mission Control Loading ........");
        System.out.println();
        missionControl = new MissionControl();
        System.out.println("Mission Control Loading Complete");
        System.out.println();
        sc = new Scanner(System.in);
    }

    public void initMissionControlApp() {
        boolean newMission;
        do {
            createNewMission();
            inputMissionData();
            System.out.println();
            System.out.println("Start Another Mission?: Y / N ");
            newMission = sc.nextLine().equalsIgnoreCase("Y");
            System.out.println();
        } while (newMission);
    }

    public void createNewMission() {
        System.out.println("Please Create A New Mission");
        System.out.println();
        System.out.println("Enter Mission Name: ");
        missionName = sc.nextLine();
        missionControl.createMission(missionName);
        System.out.println("Created New Mission: "
                + missionControl.getMission(missionName).getMissionName());
        System.out.println();
    }

    public void inputMissionData() {
        boolean continueInput;

        do {
            System.out.println("Please Enter Mission Data:");
            try {
                String maxSurfaceCoords = sc.nextLine();
                String vehicleStartLocation = sc.nextLine();
                String vehicleCommands = sc.nextLine();
                missionControl.setMissionData(missionName, maxSurfaceCoords,
                        vehicleStartLocation, vehicleCommands);
            } catch (Exception e) {
                System.out.println("Error: Invalid input data or data is incomplete ");
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Continue Mission Data Input?: Y / N");
                continueInput = !sc.nextLine().equalsIgnoreCase("N");
            }

        } while (continueInput);

        missionControl.startMission(missionName);
    }

}
