import static java.lang.System.out;
import static java.lang.System.nanoTime;

public class example3 {
	
	@FunctionalInterface
	interface Function {
		double invoke(double a);
	}

	public static void time(Function f) {
		long start = nanoTime();
		double result = f.invoke(10.0);
		out.printf("Result: %.2f, Took: %d ns\n", result, nanoTime() - start);
	}

	public static void main(String... args) {

		final double val = 2.1;

		/*time(new Function() {

			public double invoke(double a) { return Math.pow(a, val); }

		});*/

		time( a -> Math.pow(a, val) );


		//time(a -> (a > 3) ? val * a : val + a);
	}

}