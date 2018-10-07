package infrastructure;

import domain.model.Race;
import infrastructure.builder.RaceLogDTOBuilder;
import infrastructure.converter.RaceLogDTOToRaceConverter;
import infrastructure.dto.RaceLogDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RaceRepositoryLogImpl {

    public static final String TAB = "\t";
    public static final String EMPTY_SPACE = " ";
    public static final String TWO_OR_MORE_CONSECUTIVE_SPACES = " +";

    public static Race getRace(String fileName) {
        List<RaceLogDTO> raceLogs = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName)).skip(1)) {

            stream.map(line -> line.replaceAll(TAB, EMPTY_SPACE)).forEach(line -> {
                String withoutTab = line.trim().replaceAll(TWO_OR_MORE_CONSECUTIVE_SPACES, EMPTY_SPACE);
                String[] splittedWords = withoutTab.split(EMPTY_SPACE);

                RaceLogDTOBuilder raceLogDTOBuilder = new RaceLogDTOBuilder();
                RaceLogDTO raceLogDTO = raceLogDTOBuilder
                        .withTime(splittedWords[0])
                        .withDriverId(splittedWords[1])
                        .withDriverName(splittedWords[3])
                        .withLapNumber(splittedWords[4])
                        .withLapTime(splittedWords[5])
                        .withAverageSpeed(splittedWords[6])
                        .build();

                raceLogs.add(raceLogDTO);

            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return RaceLogDTOToRaceConverter.convert(raceLogs);
    }
}
