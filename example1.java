import static java.lang.System.out;
import java.util.*;

public class example1 {

	public static void main(String... args) {
		Collection<String> items = Arrays.asList("foo", "bar", "baz");
		
		out.println(String.join(":", items));

		StringJoiner sj = new StringJoiner( ":", "[", "]" );

		sj.add("foo").add("bar").add("baz");

		out.println(sj.toString());
	}
}