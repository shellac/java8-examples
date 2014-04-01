import static java.lang.System.out;

public class example4 {

	interface Ugger {

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

		new Bar().ug();

	}

}