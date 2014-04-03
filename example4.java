import static java.lang.System.out;

public class example4 {

	interface Ugger {

		static void og() {
			out.println("Og!");
		}

		default void ug() {
			out.println("Default ug!");
		}

	}

	static class Bar implements Ugger {

		/*@Override
		public void ug() {
			out.println("Overriden!");
		}*/

	}

	public static void main(String... args) {

		Bar.og();

		new Bar().ug();

	}

}