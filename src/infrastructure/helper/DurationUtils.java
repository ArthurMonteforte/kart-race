package infrastructure.helper;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class DurationUtils {

    private DurationUtils() {}

    /*
    Converte o tipo Duration para o formato MM:ss.mmm (minutos:segundos.milissegundos)
     */
    public static String convertDurationToMMSSmm(Duration duration) {
        return String.format("%d:%d.%d", duration.toMinutes(),
                duration.getSeconds() % 60,
                TimeUnit.NANOSECONDS.toMillis(duration.getNano()) % 1000);
    }
}
