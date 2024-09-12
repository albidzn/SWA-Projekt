package person;

public abstract class Person {
    protected String name; // protected, da die Unterklassen auf die Attribute zugreifen müssen und wir nicht wissen, ob die unterklassen nur mit getter und setter arbeiten
    protected String email;
    protected String phoneNumber;
    protected String address;   
    //protected String birthDate; TODO #3 sollte nicht jede Person es angeben müssen?

    // Konstruktor für gemeinsame Attribute
    public Person(String name, String email, String phoneNumber, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

   //Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //Abstrakte Methode, die in den Unterklassen implementiert werden muss
    public abstract String getPersonType();
}