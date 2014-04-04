import static java.lang.System.out;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import java.util.*;
import java.util.stream.*;

public class example8 {

	public static void main(String... args) {
		
		out.println( Stream.of(asList(1,2,3), asList(4,5,6)).collect(toList()) );

		out.println( Stream.of(asList(1,2,3), asList(4,5,6)).flatMap(Collection::stream).collect(toList()) );
	}
}