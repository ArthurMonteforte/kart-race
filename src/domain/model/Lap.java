package domain.model;

import java.time.Duration;
import java.time.LocalTime;

public class Lap implements Comparable {
    private String driverName;
    private LocalTime endingTime;
    private Integer lapNumber;
    private Duration duration;
    private Double averageSpeed;

    public Lap(String driverName, LocalTime endingTime, Integer lapNumber, Duration duration, Double averageSpeed) {
        this.driverName = driverName;
        this.endingTime = endingTime;
        this.lapNumber = lapNumber;
        this.duration = duration;
        this.averageSpeed = averageSpeed;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public Integer getLapNumber() {
        return lapNumber;
    }

    public Duration getDuration() {
        return duration;
    }

    public Double getAverageSpeed() {
        return averageSpeed;
    }

    public String getDriverName() {
        return driverName;
    }

    @Override
    public int compareTo(Object o) {
        Lap lap = (Lap) o;

        if (this.lapNumber > lap.lapNumber) return -1;
        if (this.lapNumber < lap.lapNumber) return 1;

        return this.endingTime.compareTo(lap.endingTime);
    }

    @Override
    public String toString() {
        return "Lap{" +
                "driverName='" + driverName + '\'' +
                ", endingTime=" + endingTime +
                ", lapNumber=" + lapNumber +
                ", duration=" + duration +
                ", averageSpeed=" + averageSpeed +
                '}';
    }
}
