package person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private List<Person> personList = new ArrayList<>();

    public void addPerson(Person person) {
        personList.add(person);
    }

    public void deletePerson(String name) {
        personList.removeIf(person -> person.getName().equalsIgnoreCase(name));
    }

    public void displayPersons() {
        for (Person person : personList) {
            System.out.println("Type: " + person.getPersonType() + ", Name: " + person.getName() + ", Address: " + person.getAddress());
        }
    }
}
