package view;

import application.impl.RaceServiceImpl;

public class Main {

    public static void main(String[] args) {
        String fileName = "./race.log";

        RaceServiceImpl raceService = new RaceServiceImpl();
        raceService.printRaceSummary(fileName);

    }
}
