package person;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

	private PersonService personService;

	@BeforeEach
	public void setUp() {
		personService = new PersonService(); // Initialisiere den PersonService vor jedem Test
	}

	@Test
	public void testCreateNaturalPerson() {
		Person person = personService.createPerson("NaturalPerson", "Thomas Slotos", "thomas.slotos@leuphana.de",
				"123456789", "Main Street", "2006-01-01");
		assertNotNull(person);
		assertTrue(person instanceof NaturalPerson);
		assertEquals("Thomas Slotos", person.getName());

		System.out.println("Erstellte NaturalPerson: ");
		System.out.println("Name: " + person.getName());
		System.out.println("Email: " + person.getEmail());
		System.out.println("Telefonnummer: " + person.getPhoneNumber());
		System.out.println("Adresse: " + person.getAddress());
		System.out.println("Personentyp: " + person.getPersonType());
		NaturalPerson naturalPerson = (NaturalPerson) person;
		System.out.println("Geburtsdatum: " + naturalPerson.getBirthDate());
		System.out.println("Ist über 18 Jahre: " + naturalPerson.isOver18());
		System.out.println();
	}

	@Test
	public void testCreateLegalPerson() {
		Person person = personService.createPerson("LegalPerson", "AAMS GmbH", "kontakt@aams.com", "00491234567",
				"Leuphana Straße", "AAMS GmbH", "123456", "1234567890123");
		assertNotNull(person);
		assertTrue(person instanceof LegalPerson);
		assertEquals("AAMS GmbH", person.getName());

		System.out.println("Erstellte LegalPerson: ");
		System.out.println("Name: " + person.getName());
		System.out.println("Email: " + person.getEmail());
		System.out.println("Telefonnummer: " + person.getPhoneNumber());
		System.out.println("Adresse: " + person.getAddress());
		System.out.println("Personentyp: " + person.getPersonType());
		LegalPerson legalPerson = (LegalPerson) person;
		System.out.println("Firmenname: " + legalPerson.getCompanyName());
		System.out.println("Registrierungsnummer: " + legalPerson.getRegistrationNumber());
		System.out.println("Steuernummer: " + legalPerson.getTaxNumber());
		System.out.println();
	}

	@Test
	public void testDeletePerson() {
		personService.createPerson("NaturalPerson", "Thomas Slotos", "thomas.slotos@leuphana.de", "123456789",
				"Main Street", "2006-01-01");
		personService.deletePerson("Thomas Slotos");
		assertTrue(personService.getPersons().isEmpty()); // Überprüft, ob die Liste leer ist
	}

	@Test
	public void testDisplayPersons() {
		personService.createPerson("NaturalPerson", "Thomas Slotos", "thomas.slotos@leuphana.de", "123456789",
				"Main Street", "2006-01-01");
		personService.createPerson("LegalPerson", "AAMS GmbH", "kontakt@aams.com", "00491234567", "Leuphana Straße",
				"AAMS GmbH", "123456", "1234567890123");

		assertEquals(2, personService.getPersons().size()); // Überprüft, ob zwei Personen erstellt wurden

		System.out.println("Aktuell gespeicherte Personen:");
		personService.displayPersons();
	}
}
