package application;

import domain.model.Race;

public interface RaceService {
    Race obtainRaceInformation(final String fileName);
    void printRaceSummary(final String fileName);
}
