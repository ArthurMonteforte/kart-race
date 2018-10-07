package infrastructure.builder;

import infrastructure.dto.RaceLogDTO;

import java.time.Duration;
import java.time.LocalTime;


public final class RaceLogDTOBuilder {

    private static RaceLogDTO raceLogDTO;

    public RaceLogDTOBuilder () {
        raceLogDTO = new RaceLogDTO();
    }

    public RaceLogDTOBuilder withTime(String time) {
        raceLogDTO.setTime(LocalTime.parse(time));
        return this;
    }

    public RaceLogDTOBuilder withDriverId(String driverId) {
        raceLogDTO.setDriverId(driverId);
        return this;
    }

    public RaceLogDTOBuilder withDriverName(String driverName) {
        raceLogDTO.setDriverName(driverName);
        return this;
    }

    public RaceLogDTOBuilder withLapNumber(String lapNumber) {
        raceLogDTO.setLapNumber(Integer.valueOf(lapNumber));
        return this;
    }

    public RaceLogDTOBuilder withLapTime(String lapTime) {
        raceLogDTO.setLapDuration(Duration.parse("PT" + lapTime.replace(":", "M") + "S"));
        return this;
    }

    public RaceLogDTOBuilder withAverageSpeed(String averageSpeed) {
        raceLogDTO.setAverageSpeed(Double.parseDouble(averageSpeed.replace(",", ".")));
        return this;
    }

    public RaceLogDTO build() {
        return raceLogDTO;
    }

}
