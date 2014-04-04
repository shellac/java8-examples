import static java.lang.System.out;
import java.util.*;
import java.util.stream.*;

public class example7 {

	public static void main(String... args) {
		Optional<Integer> found = Stream.of(1,2,3,4,5,6,7).filter(i -> i > 5).findAny();

		out.println(found);

		found = Stream.of(1,2,3,4,5,6,7).filter(i -> i > 7).findAny();

		out.println(found);

		Integer num = found.orElse(99);

		out.println(num);
	}

}