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
        // Verwenden der NaturalPersonFactory zur Erstellung der Person
        FactoryPerson factory = new NaturalPersonFactory();
        Person person = personService.createPerson(factory, "Thomas", "Slotos", "thomas.slotos@leuphana.de",
                "123456789", "Main Street", "2006-01-01");
        assertNotNull(person);
        assertTrue(person instanceof NaturalPerson);
        assertEquals("Thomas", person.getFname());
        assertEquals("Slotos", person.getLname());

        // Ausgeben der Details der NaturalPerson
        System.out.println("Erstellte NaturalPerson: ");
        System.out.println("Vorname: " + person.getFname());
        System.out.println("Nachname: " + person.getLname());
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
        // Verwenden der LegalPersonFactory zur Erstellung der Person
        FactoryPerson factory = new LegalPersonFactory();
        Person person = personService.createPerson(factory, "Ariansch", "Kakkar", "kontakt@aams.com", "00491234567",
                "Leuphana Straße", "AAMS GmbH", "123456", "1234567890123");
        assertNotNull(person);
        assertTrue(person instanceof LegalPerson);
        assertEquals("Ariansch", person.getFname());
        assertEquals("Kakkar", person.getLname());

        // Ausgeben der Details der LegalPerson
        System.out.println("Erstellte LegalPerson: ");
        System.out.println("Vorname: " + person.getFname());
        System.out.println("Nachname: " + person.getLname());
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
        // Verwenden der NaturalPersonFactory zur Erstellung der Person
        FactoryPerson factory = new NaturalPersonFactory();
        personService.createPerson(factory, "Thomas", "Slotos", "thomas.slotos@leuphana.de",
                "123456789", "Main Street", "2006-01-01");
        personService.deletePerson("Thomas", "Slotos");
        assertTrue(personService.getPersons().isEmpty()); // Überprüft, ob die Liste leer ist
    }

    @Test
    public void testDisplayPersons() {
        // Verwenden der Factories zur Erstellung der Personen
        FactoryPerson naturalFactory = new NaturalPersonFactory();
        FactoryPerson legalFactory = new LegalPersonFactory();

        personService.createPerson(naturalFactory, "Thomas", "Slotos", "thomas.slotos@leuphana.de",
                "123456789", "Main Street", "2006-01-01");
        personService.createPerson(legalFactory, "Ariansch", "Kakkar", "kontakt@aams.com", "00491234567",
                "Leuphana Straße", "AAMS GmbH", "123456", "1234567890123");

        assertEquals(2, personService.getPersons().size()); // Überprüft, ob zwei Personen erstellt wurden

        System.out.println("Aktuell gespeicherte Personen:");
        personService.displayPersons();
    }
}
