package person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
	private List<Person> persons;

	public PersonService() {
		persons = new ArrayList<>();
	}

	// UseCase createPerson
	public Person createPerson(String type, String fname, String lname, String email, String phoneNumber, String address,
			String... additionalParams) {
		if ("NaturalPerson".equalsIgnoreCase(type)) {
			String birthDate = additionalParams[0];
			NaturalPerson naturalPerson = new NaturalPerson(fname, lname, email, phoneNumber, address, birthDate);
			persons.add(naturalPerson);
			return naturalPerson;
		} else if ("LegalPerson".equalsIgnoreCase(type)) {
			String companyName = additionalParams[0];
			String registrationNumber = additionalParams[1];
			String taxNumber = additionalParams[2];
			LegalPerson legalPerson = new LegalPerson(fname, lname, email, phoneNumber, address, companyName, registrationNumber,
					taxNumber);
			persons.add(legalPerson);
			return legalPerson;
		} else {
			throw new IllegalArgumentException("Unbekannter Personentyp: " + type);
		}
	}

	public void deletePerson(String fname, String lname) {
		persons.removeIf(person -> person.getFname().equalsIgnoreCase(fname) && person.getLname().equalsIgnoreCase(lname));
	}

	public void displayPersons() {
		for (Person person : persons) {
			System.out.println(person.getFname() + " " + person.getLname() + " (" + person.getPersonType() + ")");
		}
	}

	public List<Person> getPersons() {
		return persons;
	}
}
