package person;

public class NaturalPersonFactory extends FactoryPerson {
    @Override
    public Person createPerson(String fname, String lname, String email, String phoneNumber, String address, String... additionalParams) {
        return new NaturalPerson(fname, lname, email, phoneNumber, address, additionalParams[0]);
    }
}
