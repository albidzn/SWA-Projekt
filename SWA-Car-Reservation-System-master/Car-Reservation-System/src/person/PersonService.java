package person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
	private List<Person> persons;

	public PersonService() {
		persons = new ArrayList<>();
	}

	// UseCase createPerson
	public Person createPerson(String type, String name, String email, String phoneNumber, String address,
			String... additionalParams) {
		if ("NaturalPerson".equalsIgnoreCase(type)) {
			String birthDate = additionalParams[0];
			NaturalPerson naturalPerson = new NaturalPerson(name, email, phoneNumber, address, birthDate);
			persons.add(naturalPerson);
			return naturalPerson;
		} else if ("LegalPerson".equalsIgnoreCase(type)) {
			String companyName = additionalParams[0];
			String registrationNumber = additionalParams[1];
			String taxNumber = additionalParams[2];
			LegalPerson legalPerson = new LegalPerson(name, email, phoneNumber, address, companyName, registrationNumber,
					taxNumber);
			persons.add(legalPerson);
			return legalPerson;
		} else {
			throw new IllegalArgumentException("Unbekannter Personentyp: " + type);
		}
	}

	public void deletePerson(String name) {
		persons.removeIf(person -> person.getName().equalsIgnoreCase(name));
	}

	public void displayPersons() {
		for (Person person : persons) {
			System.out.println(person.getName() + " (" + person.getPersonType() + ")");
		}
	}

	public List<Person> getPersons() {
		return persons;
	}
}
