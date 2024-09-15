package person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private List<Person> persons;

    public PersonService() {
        persons = new ArrayList<>();
    }

    public Person createPerson(FactoryPerson factory, String fname, String lname, String email, String phoneNumber, String address, String... additionalParams) {
        Person person = factory.createPerson(fname, lname, email, phoneNumber, address, additionalParams);
        persons.add(person);
        return person;
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
