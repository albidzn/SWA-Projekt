package person;

public class LegalPerson extends Person {
    private String registrationNumber; // Beispiel-Attribut für eine juristische Person
    private String taxNumber; // TODO #2 Überprüfen, ob die Steuernummer immer 13-stellig ist, und Methode zum Überprüfen implementieren

    public LegalPerson(String name, String email, String phoneNumber, String address, String registrationNumber, String taxNumber) {
        super(name, email, phoneNumber, address); // Übergabe aller erforderlichen Parameter an den Superkonstruktor
        this.registrationNumber = registrationNumber;
        this.taxNumber = taxNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    @Override
    public String getPersonType() {
        return "Legal Person";
    }
}
