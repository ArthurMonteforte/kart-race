package application.impl;

import application.RaceService;
import domain.model.Driver;
import domain.model.Race;
import infrastructure.RaceRepositoryLogImpl;
import infrastructure.helper.DurationUtils;

import java.util.Collections;
import java.util.Comparator;

public class RaceServiceImpl implements RaceService {

    @Override
    public Race obtainRaceInformation(final String fileName) {
        return RaceRepositoryLogImpl.getRace(fileName);
    }

    @Override
    public void printRaceSummary(final String fileName) {
        Race race = obtainRaceInformation(fileName);

        Collections.sort(race.getDrivers());

        for (Driver driver: race.getDrivers()) {
            System.out.println("Posição chegada: " + race.getDriverPosition(driver.getName()) +
                    ", Código Piloto: " + driver.getCode() +
                    ", Nome Piloto: " + driver.getName() +
                    ", Qtde Voltas Completadas: " + driver.getNumberOfCompletedLaps() +
                    ", Tempo Total de Prova: " + DurationUtils.convertDurationToMMSSmm(driver.getTotalTrialDuration()) +
            "\n");
        }
    }
}
