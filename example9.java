import static java.lang.System.out;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class example9 {

	public static void main(String... args) {
		
		out.println( findPerson(2).getFaculty().getOfficeAddress().getRoad() );
	}

	static Person findPerson(long id) { return people.get(id); }

	static Faculty physics = new Faculty("PHYS", new Address("Tyndall Avenue"));
	static Faculty economics = new Faculty("ECON", new Address("Priory Road"));
	static Faculty history = new Faculty("HIST", new Address("Woodland Road"));

	static Map<Long, Person> people = Stream.of(
			new Person(1, physics),
			new Person(2, economics),
			new Person(3, history)
		).collect(Collectors.toMap(Person::getId, p -> p)); //or Function.identity()));

	static class Person {
		long id; Faculty faculty;
		Person(long id, Faculty faculty) { this.id = id; this.faculty = faculty; }
		Faculty getFaculty() { return faculty; }
		long getId() { return id; }
	}

	static class Faculty {
		String code; Address officeAddress;
		Faculty(String code, Address officeAddress) { this.code = code; this.officeAddress = officeAddress; }
		Address getOfficeAddress() { return officeAddress; }
	}

	static class Address {
		String road;
		Address(String road) { this.road = road; }
		String getRoad() { return road; }
	}

}