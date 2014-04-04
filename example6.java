import static java.lang.System.out;
import static java.lang.System.nanoTime;
import java.util.stream.IntStream;

public class example6 {

	static double size = 2.0;
	static int res = 200;
	static int limit = 100000;

	public static void main(String... args) {

		int dCount = 0;
		for (int i = 0; i < res; i++) {
			for (int j = 0; j < res; j++) {
				Cplx num = pixelsToCplx(j, i);
				if (in(num, limit)) { out.print("."); dCount++; }
				else out.print(" ");
			}
			out.println();
		}

		long start = nanoTime();
		long count = IntStream.range(0, res * res).parallel()
			.mapToObj(z -> {
				int i = z / res; 
				int j = z % res;
				return pixelsToCplx(i, j);
			})
			//.unordered()
			.filter(c -> in(c, limit))
			.count();

		out.printf("Direct: %d, Stream: %d Took: %d\n", dCount, count, (nanoTime() - start) / 1000000);
	}









	static Cplx pixelsToCplx(int x, int y) {
		return new Cplx(pixelToNumber(x), pixelToNumber(y));
	}

	static double pixelToNumber(int px) {
		return 2.0 * (double) (px - res / 2) * size / (double) res;
	}

	static boolean in(Cplx start, int limit) {
		Cplx current = start;
		for (int i = 0; i < limit && current.magSq() < 4.0; i++) {
			current = current.mul(current).add(start);
		}
		return current.magSq() < 4.0;
	}

	static class Cplx {

		final double x, y;

		Cplx(double x, double y) { this.x = x; this.y = y; }

		Cplx add(Cplx other) { return new Cplx(x + other.x, y + other.y); }

		Cplx mul(Cplx other) {
			return new Cplx(x * other.x - y * other.y, x * other.y + y * other.x);
		}

		double magSq() { return x * x + y * y; }
	}

}