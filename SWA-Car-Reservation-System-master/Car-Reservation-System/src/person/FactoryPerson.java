package person;

public abstract class FactoryPerson {
    // Factory Method
    public abstract Person createPerson(String fname, String lname, String email, String phoneNumber, String address, String... additionalParams);
}

// Concrete Factory für NaturalPerson
class NaturalPersonFactory extends FactoryPerson {
    @Override
    public Person createPerson(String fname, String lname, String email, String phoneNumber, String address, String... additionalParams) {
        return new NaturalPerson(fname, lname, email, phoneNumber, address, additionalParams[0]);
    }
}

// Concrete Factory für LegalPerson
class LegalPersonFactory extends FactoryPerson {
    @Override
    public Person createPerson(String fname, String lname, String email, String phoneNumber, String address, String... additionalParams) {
        return new LegalPerson(fname, lname, email, phoneNumber, address, additionalParams[0], additionalParams[1], additionalParams[2]);
    }
}
