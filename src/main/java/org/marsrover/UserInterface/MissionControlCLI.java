package org.marsrover.UserInterface;

import org.marsrover.mission.MissionControl;
import org.marsrover.mission.MissionData;

import java.util.Scanner;

public class MissionControlCLI {

    public MissionControl missionControl;
    public MissionData missionData;
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
            System.out.println("Would You Like To Start Another Mission?: Yes / No");
            System.out.println("Enter Any Key For Yes or 'N' for No");
            newMission = sc.nextLine().equalsIgnoreCase("Y");
            System.out.println();
        } while (newMission);
    }

    public void createNewMission() {
        System.out.println("Please Create A New Mission");
        System.out.println();
        System.out.println("Enter Mission Name: ");
        String missionName = sc.nextLine();
        missionData = new MissionData();
        missionData.setMissionName(missionName);
        missionControl.createNewMission(missionData);
        System.out.println("Created New Mission: "
                + missionControl.getMission().getMissionName());
        System.out.println();
    }

    public void inputMissionData() {
        boolean continueInput;

        do {
            try {
                if (!missionControl.isMissionStarted()) {
                    System.out.println("Enter Max Explorable Coordinates For Mission: (Example format '22 33'");
                    missionData.setMaxSurFaceCoordinates(sc.nextLine());
                    missionControl.startMission(missionData);
                    missionControl.addMissionRover();
                }

                System.out.println("Enter The Vehicle Deploy Location Coordinates: (Example format '11 19 N'");
                missionData.setLocation(sc.nextLine().toUpperCase());
                missionControl.deployVehicleToLocation();

                System.out.println("Enter Commands To Move The Vehicle: (Example format 'LLMMRR'");
                missionData.setMissionCommands(sc.nextLine().toUpperCase());
                missionControl.issueVehicleCommands();

                System.out.println();
                System.out.println("Vehicle Location is : "
                        + missionControl.showCurrentVehicleLocation().toString());
                System.out.println();

            } catch (Exception e) {
                System.out.println("Error: Invalid input data or data is incomplete ");
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Would You Like To Issue More Commands To The Vehicle?: Yes / No");
                System.out.println("Enter Any Key For Yes or 'N' for No");
                continueInput = !sc.nextLine().equalsIgnoreCase("N");
            }

        } while (continueInput);

    }
}
