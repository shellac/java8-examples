import static java.lang.System.out;

public class example3_1 {
	
	@FunctionalInterface
	interface String2Int {
		int invoke(String a);
	}

	public static void main(String... args) {

		String2Int valOf = Integer::valueOf;

		String2Int compare = "Foo"::compareTo;

		String2Int len = String::length;

		System.out.printf("valOf: %d, compare: %d, len: %s\n",
			valOf.invoke("123"), compare.invoke("Bar"), len.invoke("123456"));
	}

}