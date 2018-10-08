package infrastructure.converter;

import domain.model.Driver;
import domain.model.Lap;
import domain.model.Race;
import infrastructure.dto.RaceLogDTO;

import java.util.*;

public class RaceLogDTOToRaceConverter {

    public static Race convert(List<RaceLogDTO> raceLogDTOList) {
        Map<Driver, List<Lap>> map = new HashMap<>();

        raceLogDTOList.stream().forEach(raceLogDTO -> {
            Driver driver = new Driver(raceLogDTO.getDriverId(), raceLogDTO.getDriverName());
            map.put(driver, new ArrayList<>());
        });

        raceLogDTOList.stream().forEach(raceLogDTO -> {
                    Driver driver = new Driver(raceLogDTO.getDriverId(), raceLogDTO.getDriverName());
                    Lap lap = new Lap(raceLogDTO.getDriverName(), raceLogDTO.getTime(), raceLogDTO.getLapNumber(), raceLogDTO.getLapDuration(), raceLogDTO.getAverageSpeed());
                    map.get(driver).add(lap);
        });

        List<Driver> drivers = new ArrayList<>();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Driver driver =(Driver) pair.getKey();
            driver.setLaps(map.get(driver));
            drivers.add((Driver) pair.getKey());
        }

        return new Race(drivers);
    }
}
