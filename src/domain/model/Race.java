package domain.model;

import java.util.*;

public class Race {
    private List<Driver> drivers;
    private Map<String, Integer> driversPositions = new HashMap<>();

    public Race(List<Driver> drivers) {
        this.drivers = drivers;
        setDriversPositions();
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    private void setDriversPositions() {
        List<Lap> lastLaps = new ArrayList();
        for (Driver driver: drivers) {
            lastLaps.add(driver.getLastLap());
        }

        Collections.sort(lastLaps);

        for(int i = 0 ; i < lastLaps.size(); i++) {
            Integer position = Integer.valueOf(i) + Integer.valueOf(1);
            driversPositions.put(lastLaps.get(i).getDriverName(), position);
        }
    }

    public Integer getDriverPosition(String driverName) {
        return driversPositions.get(driverName);
    }

    @Override
    public String toString() {
        return "Race{" +
                "drivers=" + drivers +
                ", driversPositions=" + driversPositions +
                '}';
    }
}
