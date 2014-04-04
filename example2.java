import static java.lang.System.out;
import static java.lang.System.nanoTime;

public class example2 {
	
	@FunctionalInterface
	interface Executable { void exec(); }

	public static void time(Executable e) {
		long start = nanoTime();
		e.exec();
		out.printf("Took: %d ns\n", nanoTime() - start);
	}

	public static void main(String... args) {

		String message = "hello";

		Executable e;

		/*e = new Executable() {

			public void exec() { out.println(message); }

		};*/

		e = () -> { out.println(message); };

		time(e);
	}
}