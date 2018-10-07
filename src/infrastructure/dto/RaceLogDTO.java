package infrastructure.dto;

import java.time.Duration;
import java.time.LocalTime;

public class RaceLogDTO {

    private LocalTime time;
    private String driverId;
    private String driverName;
    private Integer lapNumber;
    private Duration lapDuration;
    private Double averageSpeed;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Integer getLapNumber() {
        return lapNumber;
    }

    public void setLapNumber(Integer lapNumber) {
        this.lapNumber = lapNumber;
    }

    public Duration getLapDuration() {
        return lapDuration;
    }

    public void setLapDuration(Duration lapDuration) {
        this.lapDuration = lapDuration;
    }

    public Double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
}
