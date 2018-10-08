package test;

import application.RaceService;
import application.impl.RaceServiceImpl;
import org.junit.After;
import test.scenario.RaceScenarios;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.scenario.SummaryScenarios;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class RaceServiceImplTest {

    private static final String RACE_LOG_FILENAME = "./race.log";
    private static final String ALL_LINE_TERMINATORS_FOR_CURRENT_PLATFORM = "\\r|\\n";
    private RaceService raceService;

    @Before
    public void setUp() {
        raceService = new RaceServiceImpl();
    }

    @Test
    public void obtainRaceInformationTest() {
        Assert.assertEquals(RaceScenarios.getRaceResult(), raceService.obtainRaceInformation(RACE_LOG_FILENAME).toString());
    }

    @Test
    public void printRaceSummaryTest() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        raceService.printRaceSummary(RACE_LOG_FILENAME);

        Assert.assertEquals((SummaryScenarios.getRaceSummary()).trim().replaceAll(ALL_LINE_TERMINATORS_FOR_CURRENT_PLATFORM, ""),
                os.toString().trim().replaceAll(ALL_LINE_TERMINATORS_FOR_CURRENT_PLATFORM, ""));
    }

    @After
    public void cleanUp() {
        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }
}
