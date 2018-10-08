package domain.model;

import java.time.Duration;
import java.util.*;

public class Driver implements  Comparable{
    private String code;
    private String name;
    private List<Lap> laps;


    public Driver(String code, String name) {
        this.code = code;
        this.name = name;
        this.laps = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setLaps(List<Lap> laps) {
        this.laps = laps;
    }

    public Lap getLastLap() {
        Lap lastLap = null;

        for (Lap lap: laps) {
            if(lastLap == null) lastLap = lap;
            if(lap.getLapNumber() > lastLap.getLapNumber()) lastLap = lap;
        }

        return lastLap;
    }

    public Integer getNumberOfCompletedLaps() {
        return laps.size();
    }

    public Duration getTotalTrialDuration() {
        Duration totalTrialDuration = Duration.ZERO;

        for (Lap lap: laps) {
            totalTrialDuration = totalTrialDuration.plus(lap.getDuration());
        }

        return totalTrialDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(code, driver.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code);
    }

    @Override
    public int compareTo(Object o) {
        Driver driver = (Driver) o;
        return this.getTotalTrialDuration().compareTo(driver.getTotalTrialDuration());
    }

    @Override
    public String toString() {
        return "Driver{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", laps=" + laps +
                '}';
    }
}
