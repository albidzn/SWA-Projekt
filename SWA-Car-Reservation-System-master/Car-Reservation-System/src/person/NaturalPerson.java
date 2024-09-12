package person;

import java.time.LocalDate;
import java.time.Period;

// Annahme, dass es den Privatkunden repräsentiert
public class NaturalPerson extends Person { 
    private String birthDate; // Birth date of the person, die Person sollte mindestens 18 Jahre alt sein!
    private String driverLicenseNumber; // Führerscheinnummer
    private String driverLicenseDate;
    private String driverLicenseExpireDate;

    // Constructor
    public NaturalPerson(String name, String email, String phoneNumber, String address, String birthDate, String driverLicenseNumber) {
        super(name, email, phoneNumber, address); // Übergibt alle notwendigen Parameter an den Superkonstruktor
        this.birthDate = birthDate;
        this.driverLicenseNumber = driverLicenseNumber;
    }

    // Überprüfen, ob die Person mindestens 18 Jahre alt ist
    public boolean isOver18(){
        LocalDate birthDate = LocalDate.parse(this.birthDate); // Format: yyyy-MM-dd
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears() >= 18;
    }

    // Getter und Setter
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getDriverLicenseDate() {
        return driverLicenseDate;
    }

    public void setDriverLicenseDate(String driverLicenseDate) {
        this.driverLicenseDate = driverLicenseDate;
    }

    public String getDriverLicenseExpireDate() {
        return driverLicenseExpireDate;
    }

    public void setDriverLicenseExpireDate(String driverLicenseExpireDate) {
        this.driverLicenseExpireDate = driverLicenseExpireDate;
    }

    @Override
    public String getPersonType() {
        return "NaturalPerson";
    }
}
