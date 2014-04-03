import static java.lang.System.out;
import java.util.*;
import java.util.stream.*;

public class example5 {

	static class Person {
		String name; Integer age;
		Person(String name, Integer age) { this.name = name; this.age = age; }
		String getName() { return name; }
		Integer getAge() { return age; }
		public String toString() { return name + " (" + age + ")"; }
	}

	public static void main(String... args) {

		List<Person> people = Arrays.asList(
			new Person("Alice", 24),
			new Person("Bob", 34),
			new Person("Carol", 81),
			new Person("Derek", 24),
			new Person("Eve", 34),
			new Person("Frank", 17)
		);

		List<String> over30 = people.stream()
			.filter(p -> p.getAge() > 30)
			.map(Person::getName)
			.collect(Collectors.toList());

		out.println(over30);

		Map<Integer, List<Person>> peopleOver30ByAge
         = people.stream()
         	.filter(p -> p.getAge() > 30)
         	.collect(Collectors.groupingBy(Person::getAge));

        out.println(peopleOver30ByAge);

        boolean allOver18 = people.stream().allMatch(p -> p.getAge() > 18);

        out.println(allOver18);

        people.stream().map(Person::getAge).sorted().distinct()
        	.forEach(age -> out.printf("- %d\n", age));

	}

}