import static java.lang.System.out;
import java.time.*;
import java.time.temporal.*;

public class example1_1 {

	public static void main(String... args) {
		LocalDate today = LocalDate.now();
		LocalDate payday = today.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);

		out.printf("Payday is %s\n", payday);
	}
}