package person;

public class LegalPersonFactory extends FactoryPerson {
    @Override
    public Person createPerson(String fname, String lname, String email, String phoneNumber, String address, String... additionalParams) {
        return new LegalPerson(fname, lname, email, phoneNumber, address, additionalParams[0], additionalParams[1], additionalParams[2]);
    }
}
